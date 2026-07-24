// Problem: Number of Unique XOR Triplets II
// Link:    https://leetcode.com/problems/number-of-unique-xor-triplets-ii/
// Date:    2026-07-23
// Time:    O(n^2 + mx * n) | Space: O(mx)
//
// Approach: Unlike Part I, nums is NOT a permutation so the O(1) math
// trick doesn't apply. Instead:
// Step 1: Compute all unique a^b values using a boolean array st[].
// Step 2: For each unique a^b, XOR with every c in nums to get a^b^c.
// Step 3: Count distinct values in the result array s[].
// mx = 2 * max(nums) to cover all possible XOR values (XOR can't exceed
// next power of 2 above max, but 2*max is a safe upper bound).

public class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int mx = 0;
        for (int x : nums) mx = Math.max(mx, x);
        mx <<= 1;

        boolean[] st = new boolean[mx];
        for (int a : nums)
            for (int b : nums)
                st[a ^ b] = true;

        int[] s = new int[mx];
        for (int ab = 0; ab < mx; ab++)
            if (st[ab])
                for (int c : nums)
                    s[ab ^ c] = 1;

        int ans = 0;
        for (int v : s) ans += v;
        return ans;
    }
}
