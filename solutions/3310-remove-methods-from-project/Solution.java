import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

// 3310. Remove Methods From Project
// https://leetcode.com/problems/remove-methods-from-project/
// Date: 2026-08-04
// Time Complexity: O(n + e) where e = invocations.length - BFS plus one pass over all methods and edges
// Space Complexity: O(n + e) for the adjacency list, queue, and seen array

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> ans = new ArrayList<>();
        List<Integer>[] graph = new List[n];
        Arrays.setAll(graph, i -> new ArrayList<>());

        // Build directed graph: u invokes v
        for (int[] invocation : invocations) {
            final int u = invocation[0];
            final int v = invocation[1];
            graph[u].add(v);
        }

        // BFS from k to find all methods reachable from k (the suspicious set)
        Queue<Integer> q = new ArrayDeque<>(List.of(k));
        boolean[] seen = new boolean[n];
        seen[k] = true;

        while (!q.isEmpty())
            for (int sz = q.size(); sz > 0; --sz)
                for (final int v : graph[q.poll()])
                    if (!seen[v]) {
                        q.offer(v);
                        seen[v] = true;
                    }

        // Check if any non-suspicious method invokes a suspicious one.
        // If so, the suspicious group cannot be safely removed, return all methods.
        for (int u = 0; u < n; ++u) {
            if (seen[u])
                continue;
            for (final int v : graph[u])
                if (seen[v]) {
                    ans = new ArrayList<>(n);
                    for (int i = 0; i < n; ++i)
                        ans.add(i);
                    return ans;
                }
            ans.add(u);
        }

        return ans;
    }
}