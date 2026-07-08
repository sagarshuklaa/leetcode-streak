# 3756. Concatenate Non-Zero Digits and Multiply by Sum II

Link: https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/
Difficulty: Medium
Date: 2026-07-08
Topics: String, Prefix Sum, Math, Modular Arithmetic

## Approach
Precompute 4 prefix arrays over the string s (length m), then answer
each query in O(1).

pow10[i] = 10^(non-zero digit count in s[0..i-1]) mod MOD
idx[i]   = count of non-zero digits in s[0..i-1]
x[i]     = value formed by concatenating non-zero digits of s[0..i-1] mod MOD
total[i] = digit sum of ALL digits in s[0..i-1] (zeros contribute 0 anyway)

For a query [l, r]:
- nonZeroCount = idx[r+1] - idx[l]
- x for substring = x[r+1] - x[l] * pow10[nonZeroCount]  (mod MOD)
  This "removes" the prefix contribution of s[0..l-1] from x[r+1]
- sum for substring = total[r+1] - total[l]
- answer = x_sub * sum_sub mod MOD

The subtraction trick for x works because appending nonZeroCount more
digits to x[l] shifts it left by pow10[nonZeroCount], so subtracting
that from x[r+1] isolates the contribution of s[l..r].

## Complexity
Time: O(m + q) -- O(m) preprocessing, O(1) per query
Space: O(m)

## Key Insight
The "concatenation of non-zero digits" in a range is a prefix-removable
quantity: x[l..r] = x[0..r] - x[0..l-1] * 10^(nonZeroCount in [l..r]).
This is analogous to prefix sum subtraction but for digit concatenation,
requiring a running power-of-10 index to correctly shift the prefix out.
