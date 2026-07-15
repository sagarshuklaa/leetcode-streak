# 3658. GCD of Odd and Even Sums

Link: https://leetcode.com/problems/gcd-of-odd-and-even-sums/
Difficulty: Easy
Date: 2026-07-14
Topics: Math, GCD, Number Theory

## Approach
Pure math -- no iteration needed.

Sum of first n odd numbers:
sumOdd = 1 + 3 + 5 + ... + (2n-1) = n^2

Sum of first n even numbers:
sumEven = 2 + 4 + 6 + ... + 2n = n*(n+1)

GCD(n^2, n*(n+1))
= n * GCD(n, n+1)
= n * 1          [GCD of consecutive integers is always 1]
= n

So the answer is simply n.

## Complexity
Time: O(1)
Space: O(1)

## Key Insight
Sum formulas reduce the problem to GCD(n^2, n*(n+1)) = n * GCD(n, n+1).
Since n and n+1 are consecutive integers, their GCD is 1, giving answer = n.
