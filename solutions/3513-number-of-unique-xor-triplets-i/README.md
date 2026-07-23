# 3513. Number of Unique XOR Triplets I

Link: https://leetcode.com/problems/number-of-unique-xor-triplets-i/
Difficulty: Medium
Date: 2026-07-22
Topics: Array, Math, Bit Manipulation, XOR

## Approach
Since nums is a permutation of [1..n], we have all values 1 to n available.

For n < 3: only trivial same-index triplets exist, giving unique values = n.

For n >= 3: Let x = floor(log2(n)) -- the position of the highest set bit in n.
With three elements chosen from [1..n], we can form every XOR value from
0 to 2^(x+1) - 1 inclusive. This is because:
- We have values with bit x set (like 2^x itself) and without.
- XOR of three elements can zero out or set any combination of bits up to bit x.
- The value n >= 2^x ensures bit x is reachable, and using the same element
  twice (i <= j <= k allows i==j or j==k) lets us cancel bits freely.

Answer = 2^(x+1) = 1 << (x+1).

## Complexity
Time: O(1) -- just log and bit shift
Space: O(1)

## Key Insight
The actual values of the permutation don't matter -- only n matters, because
[1..n] always contains enough variety to cover all XOR combinations up to
the next power of 2 above n. The answer depends solely on the highest bit
of n.
