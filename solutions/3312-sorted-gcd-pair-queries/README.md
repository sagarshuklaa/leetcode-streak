# 3312. Sorted GCD Pair Queries

Link: https://leetcode.com/problems/sorted-gcd-pair-queries/
Difficulty: Hard
Date: 2026-07-16
Topics: Array, Math, GCD, Binary Search, Inclusion-Exclusion, Prefix Sum

## Approach
Directly computing all O(n^2) GCD pairs is too slow for n=1e5.
Instead, count pairs by GCD value using number theory:

Step 1 - countDivisor[d]:
For each num, enumerate its divisors in O(sqrt(num)) and increment
countDivisor for each divisor. Result: countDivisor[d] = how many
nums are divisible by d.

Step 2 - countGcdPair[g] via inclusion-exclusion:
C(countDivisor[g], 2) = pairs sharing g as a common divisor (not
necessarily GCD exactly g). Subtract pairs with GCD = 2g, 3g, ...
(Mobius-style sieve from large to small) to isolate pairs with
GCD exactly g.

Step 3 - Prefix sum:
prefixCountGcdPair[g] = total pairs with GCD <= g. This gives a
sorted implicit representation of all GCD pairs without materializing
the array.

Step 4 - Binary search per query:
For query q (0-indexed), find smallest g where
prefixCountGcdPair[g] >= q+1. This is the q-th element in the
sorted gcdPairs array.

## Complexity
Time: O(maxNum * log(maxNum) + q * log(maxNum))
Space: O(maxNum)

## Key Insight
Never build the O(n^2) GCD array. Instead, count pairs per GCD value
using divisor counting + inclusion-exclusion sieve, build a prefix sum,
and answer each query with binary search -- classic offline query
technique combined with number-theoretic counting.
