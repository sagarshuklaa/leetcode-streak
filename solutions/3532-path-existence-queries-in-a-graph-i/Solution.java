// Problem: Path Existence Queries in a Graph I
// Link:    https://leetcode.com/problems/path-existence-queries-in-a-graph-i/
// Date:    2026-07-09
// Time:    O(n * alpha(n) + q) | Space: O(n)
//
// Approach: Since nums is sorted, an edge exists between i and j only if
// |nums[i] - nums[j]| <= maxDiff. For sorted arrays, this means we only
// need to check adjacent elements -- if nums[i] - nums[i-1] <= maxDiff,
// union nodes i and i-1. Then each query is just a Union-Find connectivity
// check in near O(1) with path compression + union by rank.

class UnionFind {
    private int[] id;
    private int[] rank;

    public UnionFind(int n) {
        id = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) id[i] = i;
    }

    public void unionByRank(int u, int v) {
        int i = find(u), j = find(v);
        if (i == j) return;
        if (rank[i] < rank[j]) id[i] = j;
        else if (rank[i] > rank[j]) id[j] = i;
        else { id[i] = j; rank[j]++; }
    }

    public int find(int u) {
        return id[u] == u ? u : (id[u] = find(id[u]));
    }
}

public class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        UnionFind uf = new UnionFind(n);

        for (int i = 1; i < n; i++)
            if (Math.abs(nums[i] - nums[i - 1]) <= maxDiff)
                uf.unionByRank(i, i - 1);

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++)
            ans[i] = uf.find(queries[i][0]) == uf.find(queries[i][1]);

        return ans;
    }
}
