// Problem: Number of Unique XOR Triplets I
// Link:    https://leetcode.com/problems/number-of-unique-xor-triplets-i/
// Date:    2026-07-22
// Time:    O(1) | Space: O(1)
//
// Math insight: nums is a permutation of [1..n].
// For n < 3: answer is n (only trivial single-element triplets).
// For n >= 3: we can always achieve any XOR value from 0 to 2^(floor(log2(n))+1) - 1.
// The highest bit in n is x = floor(log2(n)).
// With 3 elements from [1..n] we can form all values 0..2^(x+1)-1.
// Answer = 2^(x+1) = 1 << (x+1).

public class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int n = nums.length;
        if (n < 3) return n;
        final int x = (int) (Math.log(n) / Math.log(2));
        return 1 << (x + 1);
    }
}
