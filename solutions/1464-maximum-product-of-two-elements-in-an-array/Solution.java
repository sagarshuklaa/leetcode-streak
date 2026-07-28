// 1464. Maximum Product of Two Elements in an Array
// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
// Date: 2026-07-26
// Time Complexity: O(n) - single pass through the array
// Space Complexity: O(1) - only two tracking variables used

class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0; // largest element seen so far
        int max2 = 0; // second largest element seen so far

        // Single pass to track the top two maximum values
        for (final int num : nums)
            if (num > max1) {
                // New max found; demote current max1 to max2
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                // Not bigger than max1, but bigger than max2
                max2 = num;
            }

        // Apply the (-1) adjustment to both top values as per problem requirement
        return (max1 - 1) * (max2 - 1);
    }
}