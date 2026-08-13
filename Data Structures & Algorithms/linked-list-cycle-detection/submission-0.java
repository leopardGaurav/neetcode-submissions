/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;            // Step 1 node at a time
            fast = fast.next.next;       // Step 2 nodes at a time

            if (slow == fast) {
                return true;             // Fast pointer caught up to slow pointer -> cycle detected
            }
        }

        return false;                    // Reached end of list -> no cycle
    }
}