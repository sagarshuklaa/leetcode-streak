// Problem: Remove Covered Intervals
// Link:    https://leetcode.com/problems/remove-covered-intervals/
// Date:    2026-07-06
// Time:    O(n log n) | Space: O(1)
//
// Approach: Sort by start ascending, then by end descending (for same start).
// Walk through intervals tracking the farthest end seen so far (prevEnd).
// An interval is NOT covered iff its end exceeds prevEnd -- count those.
// Sorting end descending for equal starts ensures a wider interval always
// comes before a narrower one with the same start, so the narrower is
// correctly identified as covered.

import java.util.*;

public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,
            Comparator.comparingInt((int[] i) -> i[0])
                      .thenComparingInt((int[] i) -> -i[1]));

        int ans = 0;
        int prevEnd = 0;

        for (int[] interval : intervals)
            if (prevEnd < interval[1]) {
                prevEnd = interval[1];
                ++ans;
            }

        return ans;
    }
}
