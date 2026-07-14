// Problem: Find the Number of Subsequences With Equal GCD
// Link:    https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/
// Date:    2026-07-13
// Time:    O(n * maxNum^2 * log(maxNum)) | Space: O(n * maxNum^2)
//
// Approach: Top-down DP with memoization.
// State: dp[i][x][y] = number of valid pairs where we've processed
// nums[0..i-1], current GCD of seq1 is x, current GCD of seq2 is y.
// At each index i, three choices: skip, add to seq1, add to seq2.
// Base case: if i == n, valid iff x == y and x > 0 (both non-empty).
// GCD is updated incrementally: gcd(current_gcd, nums[i]).

import java.util.*;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        final int maxNum = Arrays.stream(nums).max().getAsInt();
        Integer[][][] mem = new Integer[nums.length][maxNum + 1][maxNum + 1];
        return dp(nums, 0, 0, 0, mem);
    }

    private int dp(int[] nums, int i, int x, int y, Integer[][][] mem) {
        if (i == nums.length)
            return (x > 0 && x == y) ? 1 : 0;
        if (mem[i][x][y] != null)
            return mem[i][x][y];

        final int skip  = dp(nums, i + 1, x, y, mem);
        final int take1 = dp(nums, i + 1, gcd(x, nums[i]), y, mem);
        final int take2 = dp(nums, i + 1, x, gcd(y, nums[i]), mem);

        return mem[i][x][y] = (int) (((long) skip + take1 + take2) % MOD);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
