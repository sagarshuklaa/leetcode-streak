# 1833. Maximum Ice Cream Bars

Link: https://leetcode.com/problems/maximum-ice-cream-bars/
Difficulty: Medium
Date: 2026-06-21
Topics: Array, Greedy, Sorting, Counting Sort

## Approach
Greedy: sort costs ascending, buy the cheapest bars first to maximize
the count of bars purchasable with the given coins.

Iterate through sorted costs, subtracting from coins while affordable.
The moment a bar can't be afforded, return how many were bought so far.

Note: Problem suggests counting sort since costs[i] <= 1e5 (bounded range),
giving O(n) instead of O(n log n), but Arrays.sort is simpler and still
efficient enough here.

## Complexity
Time: O(n log n)
Space: O(1)

## Key Insight
Buying cheaper items first is always optimal when maximizing count under
a budget constraint — a classic greedy pattern.
