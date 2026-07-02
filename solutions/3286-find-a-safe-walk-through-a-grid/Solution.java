// Problem: Find a Safe Walk Through a Grid
// Link:    https://leetcode.com/problems/find-a-safe-walk-through-a-grid/
// Date:    2026-07-02
// Time:    O(m * n * health) | Space: O(m * n * health)
//
// Approach: BFS with state (row, col, remainingHealth). Start at (0,0)
// with health reduced by grid[0][0]. At each step, move to adjacent
// cells, deducting health for unsafe cells (grid[x][y] == 1). Reach
// (m-1, n-1) with health > 0 to return true. 3D seen array prevents
// revisiting the same (cell, health) state.

import java.util.*;

public class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        record T(int i, int j, int h) {}
        final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        final int m = grid.size();
        final int n = grid.get(0).size();
        final int initialHealth = health - grid.get(0).get(0);
        Queue<T> q = new ArrayDeque<>(List.of(new T(0, 0, initialHealth)));
        boolean[][][] seen = new boolean[m][n][health + 1];
        seen[0][0][initialHealth] = true;

        while (!q.isEmpty())
            for (int sz = q.size(); sz > 0; --sz) {
                final int i = q.peek().i;
                final int j = q.peek().j;
                final int h = q.poll().h;
                if (i == m - 1 && j == n - 1 && h > 0)
                    return true;
                for (int k = 0; k < 4; ++k) {
                    final int x = i + DIRS[k][0];
                    final int y = j + DIRS[k][1];
                    if (x < 0 || x == m || y < 0 || y == n) continue;
                    final int nextHealth = h - grid.get(x).get(y);
                    if (nextHealth <= 0 || seen[x][y][nextHealth]) continue;
                    q.offer(new T(x, y, nextHealth));
                    seen[x][y][nextHealth] = true;
                }
            }

        return false;
    }
}
