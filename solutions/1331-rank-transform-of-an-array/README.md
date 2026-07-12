# 1331. Rank Transform of an Array

Link: https://leetcode.com/problems/rank-transform-of-an-array/
Difficulty: Easy
Date: 2026-07-11
Topics: Array, Hash Table, Sorting

## Approach
Clone the array and sort it to get elements in ascending order.
Iterate through sorted array and use putIfAbsent to assign ranks --
the first time an element is seen it gets rank = current map size + 1
(1-based). Duplicates are skipped by putIfAbsent so equal elements
always share the same rank.

Finally replace each element in original array with its rank from map.

## Complexity
Time: O(n log n) -- sorting
Space: O(n) -- rank map + sorted clone

## Key Insight
putIfAbsent + rank.size() is an elegant one-liner for rank assignment:
since duplicates don't update the map, rank.size() at insertion time
naturally gives the next available rank without needing a separate
counter variable.
