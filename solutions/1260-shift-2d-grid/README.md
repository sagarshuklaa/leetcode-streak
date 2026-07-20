# 1260. Shift 2D Grid

Link: https://leetcode.com/problems/shift-2d-grid/
Difficulty: Easy
Date: 2026-07-19
Topics: Array, Matrix, Simulation

## Approach
Treat the 2D grid as a 1D array of size m*n using index = i*n + j.
Shifting k times means each element moves k positions forward in this
1D view (wrapping around). So element at (i,j) goes to index
(i*n + j + k) % (m*n), which maps back to row = index/n, col = index%n.

k %= m*n to handle cases where k >= m*n (full rotations cancel out).

## Complexity
Time: O(m*n)
Space: O(m*n)

## Key Insight
2D cyclic shift = 1D rotation when the grid is flattened row by row.
Direct index mapping avoids simulating k individual shifts.
