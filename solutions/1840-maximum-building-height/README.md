# 1840. Maximum Building Height

Link: https://leetcode.com/problems/maximum-building-height/
Difficulty: Hard
Date: 2026-06-20
Topics: Array, Binary Search, Greedy, Sorting

## Approach
Add building 1 (height 0) and building n (height n-1, max possible) as
virtual restrictions. Sort all restrictions by building id.

Forward pass: propagate the height limit forward — a building can be at
most (previous height + distance) tall, since height changes by at most 1
per step.

Backward pass: same idea but propagating backward from the next constraint.

After both passes, each pair of adjacent constrained buildings forms a
"tent" shape. The peak height between two constrained points l (height hL)
and r (height hR) is:
    max(hL, hR) + (distance - |hL - hR|) / 2

Take the max peak across all adjacent pairs.

## Complexity
Time: O(k log k) — dominated by sorting
Space: O(k)

## Key Insight
Treat the building heights as a 1D "tent profile" problem. Constraints
propagate at a max rate of 1 per building (like a light cone), and the
highest point between two fixed heights is a simple peak formula derived
from meeting in the middle.
