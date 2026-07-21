// Problem: Maximize Active Section with Trade I
// Link:    https://leetcode.com/problems/maximize-active-section-with-trade-i/
// Date:    2026-07-20
// Time:    O(n) | Space: O(1)
//
// Approach: Segment-based greedy. Process consecutive runs of same char.
// Track totalOnes and the best pair of adjacent zero-segments (separated
// by a ones-segment). The optimal trade converts one ones-block to zeros,
// then the two surrounding zero-blocks merge into ones -- net gain is
// the sum of the two adjacent zero-segment lengths.
// Use previousZeroSegmentLength to track the last seen zero-run length,
// update maxZeroSegmentSum when a new zero-run is encountered.

public class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int totalOnes = 0;
        int currentIndex = 0;
        int previousZeroSegmentLength = Integer.MIN_VALUE;
        int maxZeroSegmentSum = 0;

        while (currentIndex < n) {
            int segmentEnd = currentIndex + 1;
            while (segmentEnd < n && s.charAt(segmentEnd) == s.charAt(currentIndex))
                segmentEnd++;

            int currentSegmentLength = segmentEnd - currentIndex;

            if (s.charAt(currentIndex) == '1') {
                totalOnes += currentSegmentLength;
            } else {
                maxZeroSegmentSum = Math.max(maxZeroSegmentSum,
                        previousZeroSegmentLength + currentSegmentLength);
                previousZeroSegmentLength = currentSegmentLength;
            }

            currentIndex = segmentEnd;
        }

        return totalOnes + maxZeroSegmentSum;
    }
}
