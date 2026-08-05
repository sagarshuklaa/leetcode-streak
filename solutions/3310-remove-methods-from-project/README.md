# 3310. Remove Methods From Project

[Problem Link](https://leetcode.com/problems/remove-methods-from-project/)

- **Difficulty:** Medium
- **Date Solved:** 2026-08-04
- **Topics:** `Array` `Hash Table` `Depth-First Search` `Breadth-First Search` `Graph`

## Approach

Model methods and invocations as a directed graph, where an edge `u -> v` means
method `u` invokes method `v`.

**Step 1: Find the suspicious set.**
Run a BFS (or DFS) starting from `k`. Every method reachable from `k` (directly
or indirectly) is suspicious and a candidate for removal.

**Step 2: Validate the removal.**
The suspicious group can only be removed if no method *outside* the group
invokes a method *inside* the group. Iterate over all non-suspicious methods
`u`; for each of `u`'s invoked methods `v`, if `v` is suspicious, that means an
outside method depends on the suspicious group, so removal is invalid. In that
case, return every method from `0` to `n - 1` unchanged.

**Step 3: Build the result.**
If no such violation is found, the answer is simply every non-suspicious
method, collected in order.

## Complexity

| Metric | Complexity |
|--------|------------|
| Time   | O(n + e) - BFS visits each node and edge once; the validation pass revisits each edge once more |
| Space  | O(n + e) - adjacency list storage, BFS queue, and the seen array |

## Key Insight

This is a graph reachability + "cut validity" problem: once you identify the
reachable set from the buggy method `k`, removal is only safe if that set forms
a closed component with no incoming edges from outside. Checking every outside
node's outgoing edges for a suspicious target directly verifies this in a
single additional linear pass, no need for more complex graph algorithms like
strongly connected components or topological sorting.