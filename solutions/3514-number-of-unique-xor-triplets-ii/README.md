# 3514. Number of Unique XOR Triplets II

Link: https://leetcode.com/problems/number-of-unique-xor-triplets-ii/
Difficulty: Medium
Date: 2026-07-23
Topics: Array, Bit Manipulation, XOR, Hashing

## Approach
Unlike Part I (permutation of [1..n]), nums here is an arbitrary array
so the O(1) math formula doesn't work. We enumerate directly but avoid
the O(n^3) brute force.

Step 1: Compute all distinct a^b values (n^2 pairs) into boolean array
st[] of size 2*max. This collapses n^2 pairs into at most 2*max distinct
XOR values.

Step 2: For each distinct a^b value, XOR with every c in nums and mark
the result in s[]. This is O(distinct_ab * n) instead of O(n^3).

Step 3: Count set entries in s[].

Key savings: distinct a^b values << n^2 in practice, so Step 2 is much
faster than naive O(n^3). Worst case is still O(n^2 + mx*n) but with
small constants.

## Complexity
Time: O(n^2 + mx * n) where mx = 2 * max(nums)
Space: O(mx)

## Key Insight
Separate the triplet XOR into two phases: first collect all pairwise
XORs (a^b) into a set, then extend each unique pair-XOR by one more
element. This avoids redundant work when many pairs share the same XOR.
