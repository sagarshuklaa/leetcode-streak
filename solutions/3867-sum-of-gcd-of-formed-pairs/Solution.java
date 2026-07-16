// Problem: Sum of GCD of Formed Pairs
// Link:    https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/
// Date:    2026-07-15
// Time:    O(n log n) | Space: O(n)
//
// Approach:
// Step 1: Build prefixGcd where prefixGcd[i] = gcd(nums[i], max(nums[0..i])).
//         Track running max mx alongside iteration.
// Step 2: Sort prefixGcd ascending.
// Step 3: Pair smallest with largest (two-pointer style: i=0, n-1-i),
//         sum up gcd of each pair. Middle element ignored if n is odd.

import java.util.*;

public class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int mx = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            mx = Math.max(mx, x);
            prefixGcd[i] = gcd(x, mx);
        }

        Arrays.sort(prefixGcd);

        long ans = 0;
        for (int i = 0; i < n / 2; i++)
            ans += gcd(prefixGcd[i], prefixGcd[n - i - 1]);

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
