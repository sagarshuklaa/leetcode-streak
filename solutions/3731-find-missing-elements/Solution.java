import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 3731. Find Missing Elements
// https://leetcode.com/problems/find-missing-elements/
// Date: 2026-08-03
// Time Complexity: O(range + n) where range = maxVal - minVal, n = nums.length
// Space Complexity: O(n) for the hash set, plus O(range) for the output list in the worst case

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> missing = new ArrayList<>();
        Set<Integer> presenceSet = new HashSet<>();

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        // Find bounds and populate hash set
        for (int num : nums) {
            presenceSet.add(num);
            if (num < minVal) minVal = num;
            if (num > maxVal) maxVal = num;
        }

        // Collect missing values in ascending order
        for (int i = minVal; i <= maxVal; i++) {
            if (!presenceSet.contains(i)) {
                missing.add(i);
            }
        }

        return missing;
    }
}