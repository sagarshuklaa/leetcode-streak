# 628. Maximum Product of Three Numbers

?? [Problem Link](https://leetcode.com/problems/maximum-product-of-three-numbers/)

- **Difficulty:** Easy
- **Date Solved:** 2026-07-25
- **Topics:** \Array\ \Math\ \Sorting\ \Greedy\

## Approach

Sort the array first. The maximum product of three numbers must come from one of
two candidate combinations:

1. The **three largest numbers** (when all numbers are positive or mostly positive).
2. The **two smallest numbers** (which could be large negative numbers, making their
   product positive) multiplied by the **largest number** — this can outperform
   option 1 when there are two large-magnitude negative numbers.

Taking the max of both candidates after sorting guarantees the correct answer,
covering all sign combinations in the array.

## Complexity

| Metric | Complexity |
|--------|------------|
| Time   | O(n log n) — dominated by sorting |
| Space  | O(log n) – O(n) — depends on sort implementation |

## Key Insight

Negative numbers can flip the sign twice to produce a large positive product.
Instead of brute-forcing all triplets (O(n^3)), sorting reduces the problem to
comparing just two candidate products — the top three, or the two smallest
paired with the largest.
