# 1344. Angle Between Hands of a Clock

Link: https://leetcode.com/problems/angle-between-hands-of-a-clock/
Difficulty: Medium
Date: 2026-06-18
Topics: Math, Simulation

## Approach
Hour hand moves 30 degrees per hour + 0.5 degrees per minute.
Minute hand moves 6 degrees per minute.
Take absolute difference, return min of diff and 360-diff.

## Complexity
Time: O(1)
Space: O(1)

## Key Insight
Hour hand = (hour % 12 + minutes/60) * 30
Minute hand = minutes * 6
Answer = min(diff, 360 - diff)
