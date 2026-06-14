// Problem: Maximum Twin Sum of a Linked List
// Link:    https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
// Date:    2026-06-14
// Time:    O(n) | Space: O(1)

public class Solution {
    public int pairSum(ListNode head) {
        int ans = 0;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = reverseList(slow);
        while (tail != null) {
            ans = Math.max(ans, head.val + tail.val);
            head = head.next;
            tail = tail.next;
        }
        return ans;
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
class ListNode { int val; ListNode next; ListNode(int v){val=v;} }
