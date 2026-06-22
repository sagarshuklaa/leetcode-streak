# 1189. Maximum Number of Balloons

Link: https://leetcode.com/problems/maximum-number-of-balloons/
Difficulty: Easy
Date: 2026-06-22
Topics: String, Hash Table, Counting

## Approach
Count frequency of each letter in text.
Word "balloon" needs: b(1), a(1), l(2), o(2), n(1).
For single-occurrence letters (b, a, n), the count itself limits instances.
For double-occurrence letters (l, o), divide count by 2.
Answer is the minimum across all these limits.

## Complexity
Time: O(n)
Space: O(1) — fixed size 26 array

## Key Insight
Letters appearing twice in the target word (l, o) need their count
divided by 2 before comparing — the bottleneck letter determines the answer.
