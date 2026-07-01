// Problem: Find the Safest Path in a Grid
// Link:    https://leetcode.com/problems/find-the-safest-path-in-a-grid/
// Date:    2026-07-01
// Time:    O(n^2 log n) | Space: O(n^2)
//
// Approach: Multi-source BFS + Binary Search on answer.
// Step 1: Multi-source BFS from all thieves simultaneously to compute
//         distToThief[i][j] = min Manhattan distance from (i,j) to any thief.
// Step 2: Binary search on the safeness factor m. For each candidate m,
//         check if there exists a path from (0,0) to (n-1,n-1) using
//         only cells with distToThief >= m (BFS/DFS path check).

import java.util.*;

public class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] distToThief = getDistToThief(grid);
        int l = 0;
        int r = grid.size() * 2;

        while (l < r) {
            final int m = (l + r) / 2;
            if (hasValidPath(distToThief, m))
                l = m + 1;
            else
                r = m;
        }

        return l - 1;
    }

    private boolean hasValidPath(int[][] distToThief, int safeness) {
        if (distToThief[0][0] < safeness)
            return false;

        final int n = distToThief.length;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        boolean[][] seen = new boolean[n][n];
        seen[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1];
            if (distToThief[i][j] < safeness) continue;
            if (i == n - 1 && j == n - 1) return true;
            for (int[] dir : DIRS) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x < 0 || x == n || y < 0 || y == n || seen[x][y]) continue;
                q.offer(new int[]{x, y});
                seen[x][y] = true;
            }
        }

        return false;
    }

    private int[][] getDistToThief(List<List<Integer>> grid) {
        final int n = grid.size();
        int[][] distToThief = new int[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] seen = new boolean[n][n];

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    seen[i][j] = true;
                }

        for (int dist = 0; !q.isEmpty(); ++dist) {
            for (int sz = q.size(); sz > 0; --sz) {
                int[] cur = q.poll();
                int i = cur[0], j = cur[1];
                distToThief[i][j] = dist;
                for (int[] dir : DIRS) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || x == n || y < 0 || y == n || seen[x][y]) continue;
                    q.offer(new int[]{x, y});
                    seen[x][y] = true;
                }
            }
        }

        return distToThief;
    }
}
