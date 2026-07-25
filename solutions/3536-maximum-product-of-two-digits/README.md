# 3536. Maximum Product of Two Digits

?? [Problem Link](https://leetcode.com/problems/maximum-product-of-two-digits/)

- **Difficulty:** Easy
- **Date Solved:** 2026-07-24
- **Topics:** \Math\ \Sorting\ \Greedy\

## Approach

Convert the integer \
\ into its individual digits, then sort them in ascending order.
Since we want the maximum product of any two digits (repetition allowed if a digit
appears multiple times), the best choice is always the two largest digits — which,
after sorting, are the last two elements of the array. Multiply them to get the answer.

## Complexity

| Metric | Complexity |
|--------|------------|
| Time   | O(d log d) — d = number of digits (max 10, so effectively constant) |
| Space  | O(d) — storage for digit array |

## Key Insight

To maximize the product of two numbers picked from a fixed set, always pick the two
largest values — sorting makes them trivially accessible at the end of the array.
No need to check all pairs; greedy selection of the top two digits is provably optimal.
