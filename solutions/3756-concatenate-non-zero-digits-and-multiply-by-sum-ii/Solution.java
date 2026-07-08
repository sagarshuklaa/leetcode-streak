// Problem: Concatenate Non-Zero Digits and Multiply by Sum II
// Link:    https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/
// Date:    2026-07-08
// Time:    O(m + q) | Space: O(m)
//
// Approach: Prefix arrays for O(1) per query.
// pow10[i] = 10^(number of non-zero digits in s[0..i-1]) mod MOD
// idx[i]   = count of non-zero digits in s[0..i-1]
// x[i]     = concatenation of non-zero digits in s[0..i-1] mod MOD
// total[i] = digit sum of non-zero digits in s[0..i-1]
//
// For query [l, r]:
// nonZeroCount = idx[r+1] - idx[l]
// x[l..r] = x[r+1] - x[l] * pow10[nonZeroCount]  (mod MOD)
// sum[l..r] = total[r+1] - total[l]
// answer = x[l..r] * sum[l..r] mod MOD

import java.util.*;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        long[] pow10 = new long[m + 1];
        int[] idx = new int[m + 1];
        long[] x = new long[m + 1];
        long[] total = new long[m + 1];

        pow10[0] = 1;
        for (int i = 0; i < m; i++) {
            int d = s.charAt(i) - '0';
            pow10[i + 1] = (pow10[i] * 10) % MOD;
            idx[i + 1] = idx[i] + (d != 0 ? 1 : 0);
            x[i + 1] = d != 0 ? (x[i] * 10 + d) % MOD : x[i];
            total[i + 1] = total[i] + d;
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            int nonZeroCount = idx[r + 1] - idx[l];
            long xSub = ((x[r + 1] - x[l] * pow10[nonZeroCount]) % MOD + MOD) % MOD;
            long sumSub = total[r + 1] - total[l];
            result[i] = (int) (xSub * sumSub % MOD);
        }

        return result;
    }
}
