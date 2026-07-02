# 3286. Find a Safe Walk Through a Grid

Link: https://leetcode.com/problems/find-a-safe-walk-through-a-grid/
Difficulty: Medium
Date: 2026-07-02
Topics: BFS, Graph, Matrix, Dynamic Programming

## Approach
BFS over state space (row, col, remainingHealth). Each state tracks the
current position and how much health remains after reaching it.

Start at (0,0) with health reduced by grid[0][0] (the starting cell may
itself be unsafe). For each state, expand to 4 adjacent cells, deducting
1 health if the next cell is unsafe (grid value 1). Prune states where
health drops to 0 or below, and skip already-seen (cell, health) combos
via a 3D boolean array. Return true the moment we reach (m-1, n-1) with
health > 0.

BFS guarantees we find a valid path if one exists, and the seen array
ensures we never re-expand the same state.

## Complexity
Time: O(m * n * health) -- state space bounded by grid size * health range
Space: O(m * n * health) -- 3D seen array

## Key Insight
The key insight is that health is part of the state -- the same cell
can be visited multiple times with different health values, and those
are distinct states. Without tracking health in the seen array, we'd
either miss valid paths or loop infinitely.
