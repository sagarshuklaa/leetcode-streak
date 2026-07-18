// Problem: Find Greatest Common Divisor of Array
// Link:    https://leetcode.com/problems/find-greatest-common-divisor-of-array/
// Date:    2026-07-17
// Time:    O(n + log(min)) | Space: O(1)

import java.util.*;

public class Solution {
    public int findGCD(int[] nums) {
        final int mn = Arrays.stream(nums).min().getAsInt();
        final int mx = Arrays.stream(nums).max().getAsInt();
        return gcd(mn, mx);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
