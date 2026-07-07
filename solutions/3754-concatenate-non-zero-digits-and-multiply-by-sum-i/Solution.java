// Problem: Concatenate Non-Zero Digits and Multiply by Sum I
// Link:    https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/
// Date:    2026-07-07
// Time:    O(log n) | Space: O(1)
//
// Approach: Extract digits right to left. Sum ALL digits into s.
// For non-zero digits, build x by prepending each digit using a
// place-value pointer p (starts at 1, multiplied by 10 only when
// a non-zero digit is placed). Return x * s.

public class Solution {
    public long sumAndMultiply(int n) {
        int p = 1;
        int x = 0, s = 0;
        for (; n > 0; n /= 10) {
            int v = n % 10;
            s += v;
            if (v != 0) {
                x += p * v;
                p *= 10;
            }
        }
        return 1L * x * s;
    }
}
