# 3517. Smallest Palindromic Rearrangement I

?? [Problem Link](https://leetcode.com/problems/smallest-palindromic-rearrangement-i/)

- **Difficulty:** Medium
- **Date Solved:** 2026-07-27
- **Topics:** \String\ \Greedy\ \Sorting\

## Approach

Since \s\ is guaranteed to already be a palindrome, every character (other than
possibly the middle one in odd-length strings) appears an even number of times.
This means the **first half** of the string contains exactly one copy of each
paired character.

To build the lexicographically smallest palindrome:
1. Extract the first half of the string.
2. Sort that half in ascending order — this gives the smallest possible left side.
3. If the length is odd, keep the original middle character unchanged (it's fixed
   as the palindrome's center).
4. Mirror the sorted half (reversed) to form the right side.

Concatenating sortedHalf + middle (if any) + reverse(sortedHalf) produces the
smallest lexicographic palindrome achievable from a rearrangement of \s\.

## Complexity

| Metric | Complexity |
|--------|------------|
| Time   | O(n log n) — sorting the half-length substring |
| Space  | O(n) — for char array, sorted half, and result string |

## Key Insight

Because a palindrome mirrors around its center, only the first half needs to be
optimized — sorting it directly yields the globally smallest palindrome, since
the second half is forced to mirror the first. This reduces an apparent full-string
rearrangement problem to a much simpler half-string sort.
