# 3737. Count Subarrays With Majority Element I

Link: https://leetcode.com/problems/count-subarrays-with-majority-element-i/
Difficulty: Medium
Date: 2026-06-25
Topics: Array, Prefix Sum, Hash Table

## Approach
Transform the array: target -> +1, everything else -> -1.
A subarray has target as a strict majority iff its transformed sum > 0,
since that means count(target) > count(others) in that range.

Maintain a frequency array of how many times each prefix-sum value has
occurred so far. When currentSum moves +1, every prior prefix sum equal
to (currentSum - 1) now forms a valid subarray ending here, so add that
count. When currentSum moves -1, subtract the count of prefix sums equal
to the new currentSum (since those previously-valid endings are no
longer ahead by one).

The running validSubarraysCount is incrementally maintained, then added
to totalSubarrays at each step (this represents "subarrays ending at
the current index with positive sum").

## Complexity
Time: O(n)
Space: O(n)

## Key Insight
Counting "majority element subarrays" reduces to counting "subarrays
with positive sum" after a +1/-1 transformation -- a classic prefix-sum
trick. The validSubarraysCount is updated incrementally rather than
recomputed, avoiding an O(n) scan per index.
