# 1464. Maximum Product of Two Elements in an Array

?? [Problem Link](https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/)

- **Difficulty:** Easy
- **Date Solved:** 2026-07-26
- **Topics:** \Array\ \Sorting\ \Greedy\

## Approach

Instead of sorting the array (O(n log n)), track the two largest values (\max1\
and \max2\) in a single linear pass. For each number:
- If it's bigger than \max1\, the old \max1\ becomes \max2\, and the number
  becomes the new \max1\.
- Else if it's bigger than \max2\ (but not \max1\), it becomes the new \max2\.

Once the pass completes, the answer is \(max1 - 1) * (max2 - 1)\, matching the
problem's required formula, since the maximum product with the \-1\ offset is
always achieved by the two largest elements in the array.

## Complexity

| Metric | Complexity |
|--------|------------|
| Time   | O(n) — single linear scan |
| Space  | O(1) — constant extra space |

## Key Insight

Sorting isn't necessary when you only need the top two values — a single-pass
greedy tracking approach achieves the same result in linear time and constant
space, which is strictly better than the O(n log n) sort-based approach.
