# 3345. Smallest Divisible Digit Product I

[Problem Link](https://leetcode.com/problems/smallest-divisible-digit-product-i/)

- **Difficulty:** Easy
- **Date Solved:** 2026-08-05
- **Topics:** `Math` `Brute Force`

## Approach

Given the small constraints (`n <= 100`, `t <= 10`), a straightforward brute
force search works well.

Starting from `n`, check each consecutive integer's digit product for
divisibility by `t`. Since any number containing the digit `0` has a digit
product of `0` (which is divisible by any `t`), and numbers ending in `0`
appear at least once within any span of 10 consecutive integers, checking up
to 10 candidates starting from `n` is guaranteed to find a valid answer.

For each candidate, `getDigitProd` extracts digits one at a time using modulo
and integer division, multiplying them together to get the digit product.

## Complexity

| Metric | Complexity |
|--------|------------|
| Time   | O(1) - at most 10 candidates checked, each with O(log num) digit extraction, bounded by small constraints |
| Space  | O(1) - constant extra space |

## Key Insight

The key observation that guarantees termination within a small bounded range
is that any number divisible by 10 has a digit product of 0, and 0 is
divisible by every t. Since such a number always appears within any 10
consecutive integers, the brute force search never needs to look beyond a
fixed small window, making this effectively constant time despite looking
like unbounded search at first glance.