// Problem: Two Sum
// Link:    https://leetcode.com/problems/two-sum/
// Date:    2026-06-12
//
// Approach: HashMap to store seen values and their indices.
//           For each number, check if (target - num) already exists in map.
// Time:     O(n)
// Space:    O(n)

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }

        return new int[]{}; // no solution found
    }

    // --- Main for local testing ---
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.twoSum(new int[]{2, 7, 11, 15}, 9)));  // [0, 1]
        System.out.println(Arrays.toString(sol.twoSum(new int[]{3, 2, 4}, 6)));       // [1, 2]
        System.out.println(Arrays.toString(sol.twoSum(new int[]{3, 3}, 6)));           // [0, 1]
    }
}
