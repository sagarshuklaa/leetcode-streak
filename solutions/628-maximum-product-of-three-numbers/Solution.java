import java.util.Arrays;

// 628. Maximum Product of Three Numbers
// https://leetcode.com/problems/maximum-product-of-three-numbers/
// Date: 2026-07-25
// Time Complexity: O(n log n) due to sorting
// Space Complexity: O(log n) to O(n) depending on sort implementation

class Solution {
    public int maximumProduct(int[] nums) {
        final int n = nums.length;

        // Sort the array so smallest and largest elements are at the ends
        Arrays.sort(nums);

        // Maximum product of three numbers is either:
        // 1) The two smallest (possibly negative) numbers multiplied by the largest number
        //    -> handles cases with negative numbers producing a large positive product
        // 2) The three largest numbers
        return Math.max(
            nums[n - 1] * nums[0] * nums[1],
            nums[n - 1] * nums[n - 2] * nums[n - 3]
        );
    }
}
