# 3739. Count Subarrays With Majority Element II

Link: https://leetcode.com/problems/count-subarrays-with-majority-element-ii/
Difficulty: Hard
Date: 2026-06-26
Topics: Fenwick Tree, Coordinate Compression, Prefix Sum, Binary Indexed Tree

## Approach
Same core idea as Part I (target -> +1, others -> -1, majority subarray
means positive sum), but n is up to 1e5 here so the value range is too
large to index a frequency array directly by offset.

Define V[k] = 2 * count(target in nums[0..k-1]) - k. This is exactly the
running transformed sum after k elements. A subarray (i, j] has target
as majority iff V[j] > V[i].

So for each j, we need the count of earlier i with V[i] < V[j] -- the
classic "count of smaller elements seen so far" problem. Solve it with:
1. Coordinate compression: sort + dedupe all V values to get ranks.
2. Fenwick Tree (BIT): for each V[j] in order, query how many earlier
   ranks are strictly smaller (query(rank-1)), then insert this rank.

Sum all these counts for the final answer.

## Complexity
Time: O(n log n) -- sorting + n Fenwick operations
Space: O(n)

## Key Insight
"Count pairs i < j with V[i] < V[j]" is the textbook use case for a
Fenwick Tree with coordinate compression -- turning an O(n^2) comparison
into O(n log n) via online rank queries.
