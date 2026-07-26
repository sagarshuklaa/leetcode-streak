import java.util.Arrays;

// 3536. Maximum Product of Two Digits
// https://leetcode.com/problems/maximum-product-of-two-digits/
// Date: 2026-07-24
// Time Complexity: O(d log d) where d = number of digits (constant, max 10)
// Space Complexity: O(d) for the char array

class Solution {
    public int maxProduct(int n) {
        // Convert number to its digit characters
        char[] s = String.valueOf(n).toCharArray();

        // Sort digits in ascending order
        Arrays.sort(s);

        final int sz = s.length;

        // The two largest digits are the last two elements after sorting
        // Their product gives the maximum possible product of any two digits
        return (s[sz - 1] - '0') * (s[sz - 2] - '0');
    }
}
