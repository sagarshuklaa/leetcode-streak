// Problem: Number of ZigZag Arrays II
// Link:    https://leetcode.com/problems/number-of-zigzag-arrays-ii/
// Date:    2026-06-24
// Time:    O(k^3 log n) where k = r - l + 1
// Space:   O(k^2)
//
// Approach: State vector tracks, for each value v, the count of zigzag
// sequences ending at v with the last step going UP (first half of vector)
// or DOWN (second half). This doubles the state size to 2k but makes the
// transition a SINGLE fixed matrix (no alternation needed), unlike the
// O(n*r) DP from Part I. Since n can be up to 1e9, matrix exponentiation
// on this fixed transition matrix gives O(k^3 log n).

import java.util.*;

public class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int k = r - l + 1;
        int sz = 2 * k;

        // Base case (length 2): X[v-1] = ways ending UP at v = count of u < v
        //                        X[k+v-1] = ways ending DOWN at v = count of u > v
        long[] X = new long[sz];
        for (int v = 1; v <= k; v++) {
            X[v - 1] = v - 1;
            X[k + v - 1] = k - v;
        }

        // Transition: an UP-ending sequence at vp can extend to a DOWN-ending
        // sequence at v only if vp > v (must decrease). Symmetric for DOWN->UP.
        long[][] M = new long[sz][sz];
        for (int vp = 1; vp <= k; vp++) {
            for (int v = 1; v <= k; v++) {
                if (vp > v) M[vp - 1][k + v - 1] = 1;
                if (vp < v) M[k + vp - 1][v - 1] = 1;
            }
        }

        M = power(M, n - 2);

        long ans = 0;
        for (int i = 0; i < sz; i++) {
            long temp = 0;
            for (int j = 0; j < sz; j++) {
                temp = (temp + M[i][j] * X[j]) % MOD;
            }
            ans = (ans + temp) % MOD;
        }

        return (int) ans;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int sz = A.length;
        long[][] C = new long[sz][sz];
        for (int i = 0; i < sz; i++) {
            for (int kk = 0; kk < sz; kk++) {
                if (A[i][kk] == 0) continue;
                long a = A[i][kk];
                for (int j = 0; j < sz; j++) {
                    C[i][j] = (C[i][j] + a * B[kk][j]) % MOD;
                }
            }
        }
        return C;
    }

    private long[][] power(long[][] A, long p) {
        int sz = A.length;
        long[][] res = new long[sz][sz];
        for (int i = 0; i < sz; i++) res[i][i] = 1;
        while (p > 0) {
            if ((p & 1) == 1) res = multiply(res, A);
            A = multiply(A, A);
            p >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.zigZagArrays(3, 4, 5)); // 2
        System.out.println(sol.zigZagArrays(3, 1, 3));  // 10
        System.out.println(sol.zigZagArrays(1000000000, 1, 75)); // large n
    }
}
