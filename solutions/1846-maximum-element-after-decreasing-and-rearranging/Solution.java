// Problem: Maximum Element After Decreasing and Rearranging
// Link:    https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
// Date:    2026-06-28
// Time:    O(n log n) | Space: O(1)
//
// Approach: Sort the array, then greedily force the smallest valid
// sequence: first element becomes 1, and every next element is capped
// at (previous + 1) since we can only decrease values, never increase.

import java.util.*;

public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;

        for (int i = 1; i < arr.length; ++i)
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);

        return arr[arr.length - 1];
    }
}
