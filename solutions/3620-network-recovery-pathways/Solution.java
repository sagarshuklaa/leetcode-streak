// Problem: Network Recovery Pathways
// Link:    https://leetcode.com/problems/network-recovery-pathways/
// Date:    2026-07-03
// Time:    O(m log m * log(maxW)) | Space: O(n + m)
//
// Approach: Binary search on the answer (minimum edge weight on path),
// combined with Dijkstra to verify feasibility.
//
// Binary search: find the largest minimum edge weight mid such that
// a valid path exists from 0 to n-1 using only edges with weight >= mid,
// only online intermediate nodes, and total cost <= k.
//
// Check function: standard Dijkstra from node 0, but skip edges with
// weight < mid (enforcing minimum edge constraint). Track shortest total
// cost to each node. If we reach n-1 with cost <= k, return true.

import java.util.*;

public class Solution {
    int n;
    List<int[]>[] g;
    long k;

    boolean check(int mid) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE / 4);
        dist[0] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            if (d > k) return false;
            if (u == n - 1) return true;
            if (dist[u] < d) continue;
            for (int[] e : g[u]) {
                int v = e[0], w = e[1];
                if (w < mid) continue; // enforce minimum edge weight
                long nd = d + w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new long[]{nd, v});
                }
            }
        }
        return false;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        this.k = k;
        n = online.length;
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        int l = Integer.MAX_VALUE;
        int r = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            if (!online[u] || !online[v]) continue; // skip offline nodes
            g[u].add(new int[]{v, w});
            l = Math.min(l, w);
            r = Math.max(r, w);
        }

        // Binary search for the largest valid minimum edge weight
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }

        return check(l) ? l : -1;
    }
}
