# 1732. Find the Highest Altitude

Link: https://leetcode.com/problems/find-the-highest-altitude/
Difficulty: Easy
Date: 2026-06-19
Topics: Array, Prefix Sum

## Approach
Running sum (prefix sum) of gains gives altitude at each point.
Track the maximum altitude seen so far while accumulating.

## Complexity
Time: O(n)
Space: O(1)

## Key Insight
Altitude at point i+1 = altitude at point i + gain[i].
No need to store all altitudes — just track running sum and max.
