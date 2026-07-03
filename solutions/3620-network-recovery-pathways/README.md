# 3620. Network Recovery Pathways

Link: https://leetcode.com/problems/network-recovery-pathways/
Difficulty: Hard
Date: 2026-07-03
Topics: Binary Search, Dijkstra, Graph, DAG

## Approach
Classic "maximize the minimum edge weight on a path" problem, combined
with a total cost constraint (sum of edges <= k).

Binary search on the answer: the minimum edge weight mid ranges from
min(w) to max(w) across all valid (online) edges. For a given mid,
check if there exists a valid path from 0 to n-1 where:
1. All intermediate nodes are online (enforced at graph build time)
2. Every edge has weight >= mid (skip edges with weight < mid in Dijkstra)
3. Total path cost <= k (Dijkstra naturally finds the minimum-cost path)

If Dijkstra reaches n-1 with dist <= k, the check passes and we try a
higher mid. Otherwise, we lower mid. The upper binary search variant
(l = mid when feasible) finds the maximum valid mid.

Final answer: check(l) ? l : -1, since l could still be infeasible if
no valid path exists at all.

## Complexity
Time: O(m log m * log(maxW)) -- Dijkstra O(m log m) run O(log maxW) times
Space: O(n + m)

## Key Insight
"Maximize the minimum value along a path" is a binary search on the
answer pattern -- here combined with Dijkstra (not just BFS) because
we also have a total cost constraint that requires finding the
minimum-sum path among those with all edges >= mid.
