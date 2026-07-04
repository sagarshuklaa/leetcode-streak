// Problem: Minimum Score of a Path Between Two Cities
// Link:    https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
// Date:    2026-07-04
// Time:    O(n + m) | Space: O(n + m)
//
// Approach: BFS from city 1 (0-indexed: node 0) to explore the entire
// connected component containing node 0. Since we can traverse any road
// multiple times and revisit any city, the answer is simply the minimum
// edge weight in the connected component of node 1 -- because any such
// edge can be included in some valid path from 1 to n.

import java.util.*;

public class Solution {
    public int minScore(int n, int[][] roads) {
        int ans = Integer.MAX_VALUE;
        List<int[]>[] graph = new List[n];
        Arrays.setAll(graph, i -> new ArrayList<>());

        for (final int[] r : roads) {
            final int u = r[0] - 1;
            final int v = r[1] - 1;
            final int d = r[2];
            graph[u].add(new int[]{v, d});
            graph[v].add(new int[]{u, d});
        }

        Queue<Integer> q = new ArrayDeque<>(List.of(0));
        boolean[] seen = new boolean[n];
        seen[0] = true;

        while (!q.isEmpty()) {
            final int u = q.poll();
            for (int[] e : graph[u]) {
                final int v = e[0];
                final int d = e[1];
                ans = Math.min(ans, d);
                if (seen[v]) continue;
                q.offer(v);
                seen[v] = true;
            }
        }

        return ans;
    }
}
