// Problem: Count the Number of Complete Components
// Link:    https://leetcode.com/problems/count-the-number-of-complete-components/
// Date:    2026-07-10
// Time:    O(n + m) | Space: O(n + m)
//
// Approach: DFS to find each connected component. For each component,
// track node count (x) and total degree sum (y). A component with x
// nodes is complete iff it has exactly x*(x-1)/2 edges, which means
// total degree = x*(x-1). Check x*(x-1) == y to verify completeness.

import java.util.*;

public class Solution {
    private List<Integer>[] g;
    private boolean[] vis;

    public int countCompleteComponents(int n, int[][] edges) {
        g = new List[n];
        vis = new boolean[n];
        Arrays.setAll(g, k -> new ArrayList<>());

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++)
            if (!vis[i]) {
                int[] t = dfs(i);
                if (t[0] * (t[0] - 1) == t[1]) ans++;
            }

        return ans;
    }

    private int[] dfs(int i) {
        vis[i] = true;
        int x = 1, y = g[i].size();
        for (int j : g[i])
            if (!vis[j]) {
                int[] t = dfs(j);
                x += t[0];
                y += t[1];
            }
        return new int[]{x, y};
    }
}
