# 3699. Number of ZigZag Arrays I

Link: https://leetcode.com/problems/number-of-zigzag-arrays-i/
Difficulty: Hard
Date: 2026-06-23
Topics: Dynamic Programming, Prefix Sum

## Approach
Shift range to [0, r-l] for easier indexing. dp[v] tracks the number of
valid zigzag sequences of current length ending at value v, assuming the
last move alternated correctly.

At each step, alternate between:
- Odd step: dp[v] becomes prefix sum of all dp[u] for u < v (forces next
  value to be smaller than previous, continuing the zigzag down).
- Even step: dp[v] becomes suffix sum of all dp[u] for u > v (forces next
  value to be larger, continuing the zigzag up).

This uses running prefix/suffix sums to update dp in O(r) per step instead
of O(r^2), giving O(n * r) total.

Since a zigzag can start going either up or down, the final count is
doubled (the dp itself only tracks one direction pattern; the other
direction is the mirror).

## Complexity
Time: O(n * r)
Space: O(r)

## Key Insight
Use running prefix/suffix sums instead of recomputing sums from scratch
at every position — this converts an O(r^2) per-step transition into O(r),
making the whole DP feasible for n, r up to 2000.
