// Problem: Shift 2D Grid
// Link:    https://leetcode.com/problems/shift-2d-grid/
// Date:    2026-07-19
// Time:    O(m*n) | Space: O(m*n)
//
// Approach: Flatten the 2D grid to 1D index, shift by k (mod m*n),
// then map back to 2D coordinates. Each element at (i,j) moves to
// new index (i*n + j + k) % (m*n), then convert back to (x, y).

import java.util.*;
import java.util.stream.*;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        final int m = grid.length;
        final int n = grid[0].length;
        int[][] arr = new int[m][n];
        k %= m * n;

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                final int index = (i * n + j + k) % (m * n);
                arr[index / n][index % n] = grid[i][j];
            }

        List<List<Integer>> ans = new ArrayList<>();
        for (int[] row : arr)
            ans.add(Arrays.stream(row).boxed().collect(Collectors.toList()));
        return ans;
    }
}
