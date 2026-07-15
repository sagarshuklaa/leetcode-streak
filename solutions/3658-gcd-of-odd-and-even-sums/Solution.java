// Problem: GCD of Odd and Even Sums
// Link:    https://leetcode.com/problems/gcd-of-odd-and-even-sums/
// Date:    2026-07-14
// Time:    O(1) | Space: O(1)
//
// Math derivation:
// sumOdd  = 1 + 3 + 5 + ... + (2n-1) = n^2
// sumEven = 2 + 4 + 6 + ... + 2n     = n*(n+1)
// GCD(n^2, n*(n+1)) = n * GCD(n, n+1) = n * 1 = n
// (since GCD of consecutive integers is always 1)

public class Solution {
    public int gcdOfOddEvenSums(int n) {
        return n;
    }
}
