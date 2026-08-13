/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        // Step 1: Advance 'prev' to the node right before the 'left' position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // 'curr' sits at position 'left' (will become the end of the reversed sublist)
        ListNode curr = prev.next;

        // Step 2: Reverse sublist in-place by moving nodes one-by-one behind 'prev'
        for (int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }
}