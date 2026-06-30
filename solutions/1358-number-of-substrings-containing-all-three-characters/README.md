# 1358. Number of Substrings Containing All Three Characters

Link: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
Difficulty: Medium
Date: 2026-06-30
Topics: String, Sliding Window, Two Pointers

## Approach
Sliding window technique (related to LC 3 - Longest Substring Without
Repeating Characters, but inverted logic).

Expand the right pointer character by character, tracking counts of
a, b, c. As soon as the window [l, r] contains all three characters,
shrink from the left as far as possible while the window still contains
all three -- this finds the smallest valid left boundary for the
current right endpoint.

Key insight: once l is at its minimal valid position for endpoint r,
every substring starting at index 0, 1, ..., l-1 and ending at r is
ALSO valid (since shrinking further would remove a required character,
meaning anything to the left of l still has all three when paired with r).
So there are exactly l valid substrings ending at r, and we add l to
the running answer at each step.

## Complexity
Time: O(n) -- each character is added and removed from the window at
      most once
Space: O(1) -- fixed size count array of 3

## Key Insight
When counting substrings satisfying some property, look for whether
the valid left boundary is monotonic as the right pointer advances --
if so, a sliding window can count all valid substrings ending at each
position in O(1) amortized per step, without enumerating them directly.
