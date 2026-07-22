// Problem: Maximize Active Section with Trade II
// Link:    https://leetcode.com/problems/maximize-active-section-with-trade-ii/
// Date:    2026-07-21
// Time:    O((n + q) log n) | Space: O(n log n)
//
// Approach: Precompute zero-groups and a Sparse Table on adjacent zero-group
// merge lengths for O(1) range-max queries. For each query [l,r]:
// 1. Count ones in s[l..r] (precomputed prefix sum)
// 2. Handle edge cases: l or r falls inside a zero-group (partial segments)
// 3. Query sparse table for best fully-internal adjacent zero-group pair
// 4. Handle boundary zero-groups merging with first/last internal group

import java.util.*;

class Group {
    int start, length;
    Group(int start, int length) { this.start = start; this.length = length; }
}

class SparseTable {
    private final int[][] st;
    SparseTable(int[] nums) {
        int n = nums.length;
        st = new int[bitLen(n) + 1][n + 1];
        System.arraycopy(nums, 0, st[0], 0, n);
        for (int i = 1; i < st.length; i++)
            for (int j = 0; j + (1 << i) <= n; j++)
                st[i][j] = Math.max(st[i-1][j], st[i-1][j + (1 << (i-1))]);
    }
    int query(int l, int r) {
        if (l > r) return 0;
        int i = bitLen(r - l + 1) - 1;
        return Math.max(st[i][l], st[i][r - (1 << i) + 1]);
    }
    private int bitLen(int n) { return Integer.SIZE - Integer.numberOfLeadingZeros(n); }
}

public class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '1' ? 1 : 0);
        int totalOnes = prefix[n];

        List<Group> zeroGroups = new ArrayList<>();
        int[] zeroGroupIndex = new int[n];
        Arrays.fill(zeroGroupIndex, -1);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i-1) == '0')
                    zeroGroups.get(zeroGroups.size()-1).length++;
                else
                    zeroGroups.add(new Group(i, 1));
                zeroGroupIndex[i] = zeroGroups.size() - 1;
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (zeroGroups.isEmpty()) {
            for (int[] q : queries) ans.add(prefix[q[1]+1] - prefix[q[0]]);
            return ans;
        }

        int[] mergeLengths = new int[zeroGroups.size() - 1];
        for (int i = 0; i < mergeLengths.length; i++)
            mergeLengths[i] = zeroGroups.get(i).length + zeroGroups.get(i+1).length;
        SparseTable st = new SparseTable(mergeLengths);

        for (int[] query : queries) {
            int l = query[0], r = query[1];
            int ones = prefix[r+1] - prefix[l];
            int best = ones;

            int lgi = zeroGroupIndex[l];
            int rgi = zeroGroupIndex[r];

            int left  = (lgi == -1) ? -1 : (zeroGroups.get(lgi).length - (l - zeroGroups.get(lgi).start));
            int right = (rgi == -1) ? -1 : (r - zeroGroups.get(rgi).start + 1);

            // Both endpoints in same zero-group
            if (s.charAt(l) == '0' && s.charAt(r) == '0' && lgi == rgi - 1)
                best = Math.max(best, ones + left + right);

            // Fully internal adjacent pairs via sparse table
            int startAdj = (lgi == -1 ? 0 : lgi + 1);
            int endAdj   = (s.charAt(r) == '1' ? rgi : rgi - 1) - 1;
            if (startAdj <= endAdj)
                best = Math.max(best, ones + st.query(startAdj, endAdj));

            // Left boundary zero-group merges with first internal group
            if (s.charAt(l) == '0' && lgi + 1 <= (s.charAt(r) == '1' ? rgi : rgi - 1))
                best = Math.max(best, ones + left + zeroGroups.get(lgi + 1).length);

            // Right boundary zero-group merges with last internal group
            if (s.charAt(r) == '0' && lgi < rgi - 1)
                best = Math.max(best, ones + right + zeroGroups.get(rgi - 1).length);

            ans.add(best);
        }
        return ans;
    }
}
