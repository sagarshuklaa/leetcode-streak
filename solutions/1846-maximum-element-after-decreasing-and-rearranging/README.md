# 1846. Maximum Element After Decreasing and Rearranging

Link: https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
Difficulty: Medium
Date: 2026-06-28
Topics: Array, Greedy, Sorting

## Approach
Since we can rearrange freely and only decrease values (never increase),
the optimal strategy is greedy: sort ascending, force the first element
to 1, then ensure each subsequent element is at most (previous + 1).

This works because sorting first guarantees we never need an element to
be smaller than something that comes before it in value -- we always
have the freedom to decrease, so capping at previous+1 keeps every step
valid while staying as large as possible.

The final answer is simply the last element after this pass.

## Complexity
Time: O(n log n) -- dominated by sorting
Space: O(1) extra (in-place)

## Key Insight
After sorting, the tightest valid sequence is built by capping each
element at (previous + 1) -- you never want to decrease more than
necessary, since decreasing only this much keeps the chain as tall
as possible while still satisfying the adjacent-difference constraint.
