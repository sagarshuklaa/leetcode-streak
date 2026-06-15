// Problem: Delete the Middle Node of a Linked List
// Link:    https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
// Date:    2026-06-15
// Time:    O(n) | Space: O(1)

public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
class ListNode { int val; ListNode next; ListNode(int v){val=v;} ListNode(int v, ListNode n){val=v;next=n;} }
