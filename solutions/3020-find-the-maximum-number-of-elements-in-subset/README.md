# 3020. Find the Maximum Number of Elements in Subset

Link: https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/
Difficulty: Medium
Date: 2026-06-27
Topics: Array, Hash Table, Math, Greedy

## Approach
Valid subsets form a palindrome-shaped chain: x, x^2, x^4, ..., x^(k/2),
x^k, x^(k/2), ..., x^2, x. Each value except the very center must appear
twice (once on each side).

Build a frequency map of all numbers. For each candidate starting value
num (skip 1, handled separately), repeatedly square it: as long as the
next power exists with count >= 2, extend the chain by 2 (one for each
side). Stop when the next power either doesn't exist or has fewer than
2 copies.

At that stopping point x = num^k for some k. Try placing x itself as the
lone center element (+1 to length) if it exists in the map; otherwise
the chain's last matched pair can't have a center, so drop one copy
from the pair (-1) to leave a valid odd-length palindrome.

Special case for 1: since 1^2 = 1, any number of 1s greater than 1 can
all be used (paired up), with one extra 1 in the center if the count is
odd. If count is even, drop one to keep a valid center.

## Complexity
Time: O(n log log maxNum) -- squaring shrinks the chain length very fast
Space: O(n) for the frequency map

## Key Insight
The valid shapes are exactly palindromes built from repeated squaring.
Greedily extending each starting value's chain via squaring, then
checking the one extra "center" value, covers all cases in near-linear
time -- no need to explore all subsets.
