// Problem: Number of Paths with Max Score
// Link:    https://leetcode.com/problems/number-of-paths-with-max-score/
// Date:    2026-07-05
// Time:    O(n^2) | Space: O(n^2)
//
// Approach: DP from bottom-right (S) to top-left (E).
// dp[i][j] = max sum collectible from (n-1,n-1) to (i,j)
// count[i][j] = number of paths achieving that max sum
// Transitions come from right (i, j+1), down (i+1, j), diagonal (i+1, j+1)
// Skip 'X' (obstacle) and 'S' (start, value 0 handled separately).
// Add cell digit after updating dp from neighbors.

import java.util.*;

public class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        final int MOD = 1_000_000_007;
        final int[][] DIRS = {{0, 1}, {1, 0}, {1, 1}};
        final int n = board.size();

        int[][] dp = new int[n + 1][n + 1];
        Arrays.stream(dp).forEach(A -> Arrays.fill(A, -1));
        int[][] count = new int[n + 1][n + 1];

        dp[n - 1][n - 1] = 0;
        count[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; --i)
            for (int j = n - 1; j >= 0; --j) {
                if (board.get(i).charAt(j) == 'S' || board.get(i).charAt(j) == 'X')
                    continue;
                for (int[] dir : DIRS) {
                    final int x = i + dir[0];
                    final int y = j + dir[1];
                    if (dp[i][j] < dp[x][y]) {
                        dp[i][j] = dp[x][y];
                        count[i][j] = count[x][y];
                    } else if (dp[i][j] == dp[x][y]) {
                        count[i][j] = (count[i][j] + count[x][y]) % MOD;
                    }
                }
                // Add digit value of current cell (skip 'E' which has no digit)
                if (dp[i][j] != -1 && board.get(i).charAt(j) != 'E') {
                    dp[i][j] = (dp[i][j] + board.get(i).charAt(j) - '0') % MOD;
                }
            }

        return new int[]{dp[0][0] == -1 ? 0 : dp[0][0],
                         dp[0][0] == -1 ? 0 : count[0][0]};
    }
}
