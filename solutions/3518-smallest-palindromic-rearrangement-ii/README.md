# 3518. Smallest Palindromic Rearrangement II

[Problem Link](https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/)

- **Difficulty:** Hard
- **Date Solved:** 2026-07-28
- **Topics:** `String` `Math` `Combinatorics` `Greedy` `Counting`

## Approach

Since `s` is guaranteed to be a palindrome, only the left half needs to be determined;
the right half is always its mirror, and the middle character (if any) is fixed.

The problem reduces to: find the k-th lexicographically smallest permutation of the
left half's character multiset. This is a classic "k-th permutation" combinatorics
problem, solved greedily:

1. Compute how many of each character belong in the left half (half of each frequency).
2. For each position from left to right, try characters in increasing order (a to z).
   For each candidate character, tentatively place it and count how many distinct
   permutations are possible for the remaining positions using `countWays`.
3. If that count is >= k, commit to this character and move to the next position.
4. Otherwise, subtract that count from k (skipping past all those arrangements) and
   try the next character.
5. If k exceeds the total number of possible arrangements from the start, return "".

`countWays` computes a multinomial coefficient (total! / (c1! * c2! * ... * c26!))
incrementally, capping the result at a large limit to avoid integer overflow, since
we only need to compare against k, not the exact value once it's very large.

## Complexity

| Metric | Complexity |
|--------|------------|
| Time   | O(len * 26 * 26) - len positions, up to 26 character tries per position, O(26) work per countWays call |
| Space  | O(26) for frequency arrays, O(len) for the output string |

## Key Insight

Reducing a palindrome rearrangement problem to a half-length permutation problem
cuts the search space in half immediately. Combined with a greedy "count remaining
permutations" technique (similar to finding the k-th permutation of a sequence),
this avoids ever generating permutations explicitly, making an otherwise
combinatorially explosive problem tractable in polynomial time.