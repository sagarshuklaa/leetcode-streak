# 1301. Number of Paths with Max Score

Link: https://leetcode.com/problems/number-of-paths-with-max-score/
Difficulty: Hard
Date: 2026-07-05
Topics: Dynamic Programming, Matrix

## Approach
DP from bottom-right corner (S) to top-left corner (E), working
backwards so transitions only look at already-computed cells.

dp[i][j] = maximum digit sum collectible on any path from S to (i,j).
count[i][j] = number of paths achieving that maximum sum.

Initialize dp to -1 (unreachable). Set dp[n-1][n-1] = 0, count = 1 (S).

For each cell (i,j) in reverse order (bottom-right to top-left):
- Skip 'X' (obstacle) and 'S' (already initialized).
- Look at three neighbors: right (i,j+1), down (i+1,j), diagonal (i+1,j+1).
- Take the neighbor with the highest dp value; if tied, sum their counts.
- Add the cell's digit to dp[i][j] (skip 'E' which has no digit value).

If dp[0][0] is still -1 at the end, no valid path exists -- return [0,0].

## Complexity
Time: O(n^2)
Space: O(n^2)

## Key Insight
Process cells in reverse (S to E direction means going up/left/diagonal,
so fill DP from bottom-right). Use dp = -1 as sentinel for "unreachable"
so we never propagate counts through blocked paths. Both max score AND
count are tracked simultaneously in a single DP pass.
