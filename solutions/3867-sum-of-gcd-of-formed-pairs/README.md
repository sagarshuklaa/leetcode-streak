# 3867. Sum of GCD of Formed Pairs

Link: https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/
Difficulty: Medium
Date: 2026-07-15
Topics: Array, Math, GCD, Sorting, Greedy

## Approach
Step 1 - Build prefixGcd:
For each index i, compute prefixGcd[i] = gcd(nums[i], mxi) where
mxi = max(nums[0..i]). Track running max alongside the loop.

Step 2 - Sort prefixGcd ascending.

Step 3 - Pair and sum:
Use two-pointer pairing (smallest with largest) and accumulate
gcd(prefixGcd[i], prefixGcd[n-1-i]) for i in 0..n/2-1.
Middle element (if n is odd) is ignored per problem statement.

## Complexity
Time: O(n log n) -- sorting dominates; each gcd call is O(log maxNum)
Space: O(n) -- prefixGcd array

## Key Insight
prefixGcd[i] = gcd(nums[i], running_max) captures how each element
relates to the maximum seen so far. Sorting then pairing smallest with
largest is a greedy strategy that satisfies the pairing rule described
in the problem.
