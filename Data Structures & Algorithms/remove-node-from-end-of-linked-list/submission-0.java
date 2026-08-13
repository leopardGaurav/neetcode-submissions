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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node handles edge cases (e.g., removing the 1st/head node)
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        // Step 1: Move 'right' pointer n steps forward to build an 'n' node gap
        while (n > 0 && right != null) {
            right = right.next;
            n--;
        }

        // Step 2: Slide both pointers until 'right' hits null (end of list)
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // Step 3: Skip the target nth node
        left.next = left.next.next;

        return dummy.next;
    }
}