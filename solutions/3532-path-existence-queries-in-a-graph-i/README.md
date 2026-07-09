# 3532. Path Existence Queries in a Graph I

Link: https://leetcode.com/problems/path-existence-queries-in-a-graph-i/
Difficulty: Medium
Date: 2026-07-09
Topics: Union Find, Graph, Sorting

## Approach
Since nums is sorted in non-decreasing order, an edge between nodes i
and j exists iff |nums[i] - nums[j]| <= maxDiff. For a sorted array,
transitivity means we only need to check ADJACENT pairs -- if adjacent
nodes are connected, they form a contiguous reachable group.

Build Union-Find by iterating i from 1 to n-1: if nums[i] - nums[i-1]
<= maxDiff, union nodes i and i-1. This captures all connected components
in O(n) passes.

For each query [u, v]: check if find(u) == find(v) -- same connected
component means a path exists.

## Complexity
Time: O(n * alpha(n) + q) -- near linear with path compression + union by rank
Space: O(n)

## Key Insight
Sorted array + adjacency-only union is the key observation: if there is
an edge from i to j (non-adjacent), there must also be edges along every
adjacent pair between them (since nums is sorted and differences only
grow as indices get farther apart). So checking only adjacent pairs is
sufficient to capture all connectivity.
