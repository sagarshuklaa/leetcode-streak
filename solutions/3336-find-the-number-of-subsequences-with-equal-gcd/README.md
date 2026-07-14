# 3336. Find the Number of Subsequences With Equal GCD

Link: https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/
Difficulty: Hard
Date: 2026-07-13
Topics: Dynamic Programming, Math, GCD, Memoization

## Approach
Top-down DP with memoization over state (i, x, y):
- i: current index in nums
- x: running GCD of elements chosen for seq1 so far (0 = empty)
- y: running GCD of elements chosen for seq2 so far (0 = empty)

At each index i, three choices:
1. Skip nums[i] -- neither subsequence takes it
2. Add to seq1 -- update x = gcd(x, nums[i])
3. Add to seq2 -- update y = gcd(y, nums[i])

Base case (i == n): valid pair iff x == y and x > 0 (both non-empty
and GCDs match). Return 1 for valid, 0 otherwise.

State space: n * maxNum * maxNum = 200 * 200 * 200 = 8M states.
Each state computed once with O(log maxNum) for GCD = manageable.

## Complexity
Time: O(n * maxNum^2 * log(maxNum))
Space: O(n * maxNum^2)

## Key Insight
GCD of a subsequence only depends on the running GCD so far, not on
which specific elements were chosen -- this makes (index, gcd1, gcd2)
a complete DP state. gcd(0, x) = x handles the empty subsequence base
case naturally since gcd(0, x) = x for any x.
