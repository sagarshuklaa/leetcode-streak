\# 3559. Number of Ways to Assign Edge Weights II

Link: https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-ii/

Difficulty: Hard

Date: 2026-06-12

Topics: Tree, Binary Lifting, LCA, Math, DFS



Approach: Binary Lifting + Math

\- DFS to compute depth of each node

\- Sparse table for LCA in O(log n)

\- For path length d: answer is 2^(d-1) mod 1e9+7

\- If u == v: answer is 0



Time: O((n + q) log n)

Space: O(n log n)



Key Insight: Exactly half of all 2^d assignments give odd sum, so answer is always 2^(d-1).

