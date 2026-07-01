# 2812. Find the Safest Path in a Grid

Link: https://leetcode.com/problems/find-the-safest-path-in-a-grid/
Difficulty: Medium
Date: 2026-07-01
Topics: BFS, Binary Search, Graph, Matrix

## Approach
Two-phase solution:

Phase 1 - Multi-source BFS from all thieves:
Start BFS simultaneously from every thief cell. The BFS level at which
each cell is first reached equals its minimum Manhattan distance to any
thief. This fills distToThief[i][j] for the entire grid in O(n^2).

Phase 2 - Binary search on safeness factor:
The answer lies in [0, 2n]. Binary search on the candidate safeness m:
check if there exists a path from (0,0) to (n-1,n-1) using only cells
with distToThief >= m (BFS path check in O(n^2)). The highest m for
which this is true is the answer.

Total: O(n^2 log n) -- n^2 per BFS check, log n binary search iterations.

## Complexity
Time: O(n^2 log n)
Space: O(n^2)

## Key Insight
"Maximize the minimum value along a path" is the classic binary search
on answer pattern. Combine it with multi-source BFS (all thieves as
simultaneous sources) to precompute distances in one O(n^2) pass instead
of running BFS from each thief separately.
