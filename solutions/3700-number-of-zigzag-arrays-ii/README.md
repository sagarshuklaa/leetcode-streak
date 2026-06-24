# 3700. Number of ZigZag Arrays II

Link: https://leetcode.com/problems/number-of-zigzag-arrays-ii/
Difficulty: Hard
Date: 2026-06-24
Topics: Matrix Exponentiation, Dynamic Programming, Linear Algebra

## Approach
n can be up to 1e9, so the O(n*r) DP from Part I is too slow. But
r - l + 1 = k is at most 75, so the state space is small -- a clear
signal to use matrix exponentiation.

State vector (size 2k):
- First half: ways to form a sequence of current length ending at value v
  with the LAST step going UP.
- Second half: same but last step going DOWN.

Base case (length 2): ending UP at v has (v-1) ways (any smaller starting
value), ending DOWN at v has (k-v) ways (any larger starting value).

Transition matrix M encodes: an UP-ending state at vp extends to a
DOWN-ending state at v only if vp > v (the next element must be smaller
than the previous, continuing the zigzag), and symmetrically for
DOWN -> UP.

Raise M to the power (n-2) using fast exponentiation, multiply by the
base vector, and sum all entries for the final answer.

## Complexity
Time: O(k^3 log n)
Space: O(k^2)

## Key Insight
Doubling the state to explicitly track "last move direction" turns an
alternating two-step recurrence (Part I's approach) into a SINGLE fixed
transition matrix -- which is what makes straightforward matrix
exponentiation possible.
