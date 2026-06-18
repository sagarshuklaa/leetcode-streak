// Problem: Angle Between Hands of a Clock
// Link:    https://leetcode.com/problems/angle-between-hands-of-a-clock/
// Date:    2026-06-18
// Time:    O(1) | Space: O(1)

public class Solution {
    public double angleClock(int hour, int minutes) {
        final double hourHand = (hour % 12 + minutes / 60.0) * 30;
        final double minuteHand = minutes * 6;
        final double diff = Math.abs(hourHand - minuteHand);
        return Math.min(diff, 360 - diff);
    }
}
