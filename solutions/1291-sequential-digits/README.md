# 1291. Sequential Digits

Link: https://leetcode.com/problems/sequential-digits/
Difficulty: Medium
Date: 2026-07-12
Topics: BFS, Enumeration

## Approach
BFS starting from single digits 1-9. For each number dequeued, if its
last digit is < 9, generate the next sequential number by appending
(lastDigit + 1): num * 10 + lastDigit + 1.

BFS naturally produces all sequential digit numbers in sorted order
(shorter numbers before longer, and within same length in ascending
order). As soon as a dequeued number exceeds high, stop and return.

Total sequential digit numbers across all lengths is at most 36
(9 of length 1, 8 of length 2, ..., 1 of length 9), so this is
effectively O(1) time and space.

## Complexity
Time: O(1) -- at most 36 sequential digit numbers exist
Space: O(1)

## Key Insight
Model sequential digit generation as a BFS tree: each node spawns
one child by appending the next digit. BFS level order = sorted order
by number of digits, and within each level numbers are naturally sorted.
No need to enumerate all integers in [low, high].
