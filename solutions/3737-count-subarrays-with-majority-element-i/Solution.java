// Problem: Count Subarrays With Majority Element I
// Link:    https://leetcode.com/problems/count-subarrays-with-majority-element-i/
// Date:    2026-06-25
// Time:    O(n) | Space: O(n)
//
// Approach: Map target -> +1, everything else -> -1. A subarray has
// target as majority iff its transformed sum is positive. Track the
// running count of subarrays ending at each index whose sum is positive
// using a frequency array indexed by prefix sum, updated incrementally
// as currentSum moves up or down by exactly 1 each step.

public class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int offset = n + 1;
        int[] freq = new int[2 * n + 2];

        freq[0 + offset] = 1;

        int currentSum = 0;
        int totalSubarrays = 0;
        int validSubarraysCount = 0;

        for (int num : nums) {
            if (num == target) {
                currentSum += 1;
                validSubarraysCount += freq[currentSum - 1 + offset];
            } else {
                currentSum -= 1;
                validSubarraysCount -= freq[currentSum + offset];
            }

            totalSubarrays += validSubarraysCount;
            freq[currentSum + offset]++;
        }

        return totalSubarrays;
    }
}
