# 3838. Weighted Word Mapping

Link: https://leetcode.com/problems/weighted-word-mapping/
Difficulty: Easy
Date: 2026-06-13
Topics: String, Array, Math

Approach: For each word sum character weights mod 26, map to letter using reverse order (0->z, 25->a) via 'a' + (25 - result).

Time: O(n x m)
Space: O(n)

Key Insight: Reverse mapping 0->z is just chr('a' + 25 - result). Apply mod at each step.
