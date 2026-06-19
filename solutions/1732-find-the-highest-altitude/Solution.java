// Problem: Find the Highest Altitude
// Link:    https://leetcode.com/problems/find-the-highest-altitude/
// Date:    2026-06-19
// Time:    O(n) | Space: O(1)

public class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int currAltitude = 0;
        for (final int g : gain) {
            currAltitude += g;
            ans = Math.max(ans, currAltitude);
        }
        return ans;
    }
}
