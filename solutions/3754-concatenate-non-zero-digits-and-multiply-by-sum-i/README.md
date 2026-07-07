# 3754. Concatenate Non-Zero Digits and Multiply by Sum I

Link: https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/
Difficulty: Easy
Date: 2026-07-07
Topics: Math, String

## Approach
Extract digits one by one from right to left (n % 10, then n /= 10).

Track two things simultaneously:
- s: sum of ALL digits (including zeros)
- x: the concatenation of NON-ZERO digits, built using a place-value
  pointer p. p starts at 1 and is multiplied by 10 only when a non-zero
  digit is placed, effectively prepending non-zero digits in order.

Return x * s as a long (x and s fit in int, but product may overflow).

## Complexity
Time: O(log n) -- one pass through digits
Space: O(1)

## Key Insight
Building x without converting to string: use a running place-value
multiplier p that only advances for non-zero digits, so zeros are
naturally skipped while the relative order of non-zero digits is
preserved (since we process right to left and prepend each digit).
