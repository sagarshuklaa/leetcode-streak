# 2095. Delete the Middle Node of a Linked List

Link: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
Difficulty: Medium
Date: 2026-06-15
Topics: Linked List, Two Pointers

## Approach
Dummy node + slow/fast pointer trick.
Fast starts from dummy so slow stops ONE node before the middle.
Then simply skip the middle: slow.next = slow.next.next

## Complexity
Time: O(n)
Space: O(1)

## Key Insight
Start both pointers from dummy (not head) so slow lands before the middle — no need to track previous node separately.
