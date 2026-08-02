// 877. Stone Game
// https://leetcode.com/problems/stone-game/
// Date: 2026-08-01
// Time Complexity: O(n^2) - filling the 2D dp table over all (i, j) pairs
// Space Complexity: O(n^2) - for the dp table

class Solution {
    public boolean stoneGame(int[] piles) {
        final int n = piles.length;
        // dp[i][j] := the maximum stones you can get more than your opponent in piles[i..j]
        int[][] dp = new int[n][n];

        // Base case: a single pile means you take all of it
        for (int i = 0; i < n; ++i)
            dp[i][i] = piles[i];

        // Build up solutions for increasing subarray lengths (d = distance between i and j)
        for (int d = 1; d < n; ++d)
            for (int i = 0; i + d < n; ++i) {
                final int j = i + d;
                // Current player picks either the left pile or the right pile,
                // subtracting the opponent's best achievable difference on the remainder
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }

        // Alice (first player) wins if her score difference over the whole array is positive
        return dp[0][n - 1] > 0;
    }
}