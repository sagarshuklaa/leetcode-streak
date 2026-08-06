// 3345. Smallest Divisible Digit Product I
// https://leetcode.com/problems/smallest-divisible-digit-product-i/
// Date: 2026-08-05
// Time Complexity: O(1) - at most 10 candidate numbers checked, each with O(log num) digit work (bounded by constraints)
// Space Complexity: O(1) - constant extra space

class Solution {
    public int smallestNumber(int n, int t) {
        // Check at most 10 consecutive candidates starting from n.
        // Guaranteed to find an answer within this range since digit products
        // cycle through enough variety (e.g. any number ending in 0 has product 0,
        // which is divisible by any t) within a span of 10.
        for (int num = n; num < n + 10; ++num)
            if (getDigitProd(num) % t == 0)
                return num;
        throw new IllegalArgumentException();
    }

    // Computes the product of all digits of num
    private int getDigitProd(int num) {
        int digitProd = 1;
        while (num > 0) {
            digitProd *= num % 10;
            num /= 10;
        }
        return digitProd;
    }
}