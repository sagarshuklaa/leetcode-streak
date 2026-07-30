# 3014. Minimum Number of Pushes to Type Word I

[Problem Link](https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/)

- **Difficulty:** Easy
- **Date Solved:** 2026-07-29
- **Topics:** `Hash Table` `String` `Greedy` `Counting` `Sorting`

## Approach

Since the keys can be freely remapped, the goal is to assign the most frequently
occurring letters to the cheapest push positions (1 push), the next most frequent
to 2 pushes, and so on. Each key can hold up to 8 letters, giving groups of size 8
for each push-count tier (1 push for the first 8 letters, 2 pushes for the next 8,
3 pushes for the next 8, etc.).

Steps:
1. Count the frequency of each letter in `word` (all distinct letters per constraints
   for this variant, but frequency counting generalizes).
2. Sort the frequency array in ascending order.
3. Iterate from the most frequent letter (end of sorted array) to the least,
   multiplying each frequency by `(i / 8 + 1)` push cost based on its group,
   and summing the total.

This greedy assignment is optimal: pairing the highest frequency with the lowest
cost minimizes the total number of pushes.

## Complexity

| Metric | Complexity |
|--------|------------|
| Time   | O(n + 26 log 26) = O(n) - linear counting pass plus sorting a fixed 26-element array |
| Space  | O(26) = O(1) - fixed size frequency array |

## Key Insight

This is a classic greedy "exchange argument" problem: to minimize total cost when
assigning weighted costs to frequencies, always match the largest frequency with
the smallest cost. Grouping keys into buckets of 8 (since a keypad key can hold
multiple letters) turns the push-cost assignment into a simple index-based formula
after sorting.