# 3016. Minimum Number of Pushes to Type Word II

[Problem Link](https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/)

- **Difficulty:** Medium
- **Date Solved:** 2026-07-30
- **Topics:** `Hash Table` `String` `Greedy` `Counting` `Sorting`

## Approach

This is the follow-up to 3014, generalized to allow repeated letters and a much
larger input size (up to 10^5). The core greedy strategy is identical:

1. Count the frequency of each letter in `word` (now letters may repeat).
2. Sort the frequency array in ascending order.
3. Assign the most frequent letters to the cheapest push positions. Each key can
   hold up to 8 letters, so letters are grouped in buckets of 8: the top 8 most
   frequent letters cost 1 push each, the next 8 cost 2 pushes each, and so on.
4. Sum frequency * push-cost across all letters to get the minimum total pushes.

Since pushing is proportional to (frequency * cost), and cost only depends on
which bucket of 8 a letter falls into after sorting by frequency, pairing the
highest frequencies with the lowest costs greedily minimizes the total, same
exchange-argument reasoning as 3014, just applied to non-distinct letter counts.

## Complexity

| Metric | Complexity |
|--------|------------|
| Time   | O(n + 26 log 26) = O(n) - linear counting pass over word plus sorting a fixed 26-element array |
| Space  | O(26) = O(1) - fixed size frequency array |

## Key Insight

Even though this variant allows repeated letters and much larger word lengths,
the underlying optimization problem is unchanged: minimize sum(frequency * cost)
by greedily pairing the largest frequencies with the smallest costs. The fixed
alphabet size (26) keeps the sort and assignment step constant time regardless
of how large `word` itself becomes.