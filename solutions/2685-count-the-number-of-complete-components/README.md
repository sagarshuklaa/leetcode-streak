# 2685. Count the Number of Complete Components

Link: https://leetcode.com/problems/count-the-number-of-complete-components/
Difficulty: Medium
Date: 2026-07-10
Topics: DFS, Graph, Connected Components

## Approach
DFS to identify each connected component. For each component track:
- x: number of nodes
- y: sum of all node degrees (each edge counted twice)

A complete component with x nodes must have exactly x*(x-1)/2 edges,
meaning total degree sum = x*(x-1). Check t[0]*(t[0]-1) == t[1].

## Complexity
Time: O(n + m)
Space: O(n + m)

## Key Insight
A connected component is complete iff nodes = x and edges = x*(x-1)/2.
Since degree sum = 2 * edge count, check x*(x-1) == degree_sum.
No need to explicitly enumerate all pairs.
