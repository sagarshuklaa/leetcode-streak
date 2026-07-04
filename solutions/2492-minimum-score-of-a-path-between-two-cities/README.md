# 2492. Minimum Score of a Path Between Two Cities

Link: https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
Difficulty: Medium
Date: 2026-07-04
Topics: BFS, Graph, Union Find

## Approach
Key observation: since we can traverse any road multiple times and revisit
any city, a valid path from city 1 to city n can include ANY edge in the
connected component containing city 1. We just need to "reach" that edge
at some point, which we can always do by backtracking.

So the answer is simply the minimum edge weight in the connected component
of node 1 (0-indexed: node 0).

BFS from node 0, tracking all reachable nodes and their edges. At every
edge encountered, update the global minimum. The final minimum is the answer.

No need for shortest path algorithms -- this is purely a connectivity +
minimum-edge-in-component problem.

## Complexity
Time: O(n + m) -- single BFS traversal
Space: O(n + m) -- adjacency list + seen array

## Key Insight
"Can revisit roads and cities" means the constraint is purely about
connectivity, not path structure. Any edge reachable from node 1 can
be part of a valid path, so the answer = min edge weight in the
connected component of node 1.
