# 1288. Remove Covered Intervals

Link: https://leetcode.com/problems/remove-covered-intervals/
Difficulty: Medium
Date: 2026-07-06
Topics: Array, Greedy, Sorting, Intervals

## Approach
Sort intervals by start ascending. For ties in start, sort by end
descending -- this guarantees that if two intervals share a start,
the wider one comes first, so the narrower one will be correctly
identified as covered.

Walk through the sorted intervals maintaining prevEnd (the farthest
right boundary seen so far). An interval [l, r] is covered by a
previous interval iff r <= prevEnd (since l is already >= all previous
starts due to sorting). If r > prevEnd, the interval is NOT covered --
count it and update prevEnd.

## Complexity
Time: O(n log n) -- sorting
Space: O(1) extra

## Key Insight
Sorting end descending for equal starts is the key trick -- it ensures
a wider interval always precedes a narrower one with the same left
boundary, so the single-pass greedy correctly handles all coverage cases
without needing to compare pairs explicitly.
