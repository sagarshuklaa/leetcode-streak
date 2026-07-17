// Problem: Sorted GCD Pair Queries
// Link:    https://leetcode.com/problems/sorted-gcd-pair-queries/
// Date:    2026-07-16
// Time:    O(maxNum * log(maxNum) + q * log(maxNum)) | Space: O(maxNum)
//
// Approach:
// Step 1: countDivisor[d] = count of nums divisible by d (via divisor enumeration)
// Step 2: countGcdPair[g] = pairs with GCD exactly g, using inclusion-exclusion:
//         Start with C(countDivisor[g], 2) pairs sharing divisor g,
//         subtract pairs with GCD = multiple of g (already counted).
//         Process g from maxNum down to 1.
// Step 3: Build prefix sum prefixCountGcdPair for binary search.
// Step 4: For each query q, binary search for smallest g where
//         prefixCountGcdPair[g] >= q+1 (0-indexed query).

import java.util.*;

public class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        int[] ans = new int[queries.length];
        int[] countDivisor = new int[maxNum + 1];
        long[] countGcdPair = new long[maxNum + 1];
        long[] prefixCountGcdPair = new long[maxNum + 1];

        // Count how many nums are divisible by each d
        for (final int num : nums)
            for (int i = 1; (long) i * i <= num; ++i)
                if (num % i == 0) {
                    ++countDivisor[i];
                    if (i != num / i)
                        ++countDivisor[num / i];
                }

        // Inclusion-exclusion: pairs with GCD exactly g
        for (int gcd = maxNum; gcd >= 1; --gcd) {
            countGcdPair[gcd] = (long) countDivisor[gcd] * (countDivisor[gcd] - 1) / 2;
            for (int largerGcd = 2 * gcd; largerGcd <= maxNum; largerGcd += gcd)
                countGcdPair[gcd] -= countGcdPair[largerGcd];
        }

        // Prefix sum for binary search
        for (int gcd = 1; gcd <= maxNum; ++gcd)
            prefixCountGcdPair[gcd] = prefixCountGcdPair[gcd - 1] + countGcdPair[gcd];

        for (int i = 0; i < queries.length; ++i)
            ans[i] = getNthGcdPair(queries[i], prefixCountGcdPair);

        return ans;
    }

    private int getNthGcdPair(long query, long[] prefixCountGcdPair) {
        int l = 1, r = prefixCountGcdPair.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (prefixCountGcdPair[m] < query + 1) l = m + 1;
            else r = m;
        }
        return l;
    }
}
