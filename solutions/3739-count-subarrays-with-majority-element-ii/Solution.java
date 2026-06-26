// Problem: Count Subarrays With Majority Element II
// Link:    https://leetcode.com/problems/count-subarrays-with-majority-element-ii/
// Date:    2026-06-26
// Time:    O(n log n) | Space: O(n)
//
// Approach: Part I's array is too big here for the offset-frequency-array
// trick (n up to 1e5, sum range too large to index directly), so we use
// a Fenwick Tree with coordinate compression instead.
//
// Define V[k] = 2*count(target in first k elements) - k. A subarray
// (i, j] has target as majority iff V[j] > V[i] (the transformed +1/-1
// sum over that range is positive). So we need, for each j, the count
// of earlier indices i < j with V[i] < V[j] -- a classic "count smaller
// elements before me" problem, solved with a Fenwick Tree over
// compressed V values.

import java.util.*;

public class Solution {

    class FenwickTree {
        private int[] tree;
        private int size;
        public FenwickTree(int size) {
            this.size = size;
            this.tree = new int[size + 1];
        }
        public void add(int i, int delta) {
            while (i <= size) {
                tree[i] += delta;
                i += i & (-i);
            }
        }
        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & (-i);
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] V = new int[n + 1];
        int countTarget = 0;
        V[0] = 0;
        for (int k = 1; k <= n; k++) {
            if (nums[k - 1] == target) countTarget++;
            V[k] = 2 * countTarget - k;
        }

        int[] sortedV = V.clone();
        Arrays.sort(sortedV);

        int uniqueCount = 0;
        for (int i = 0; i < sortedV.length; i++) {
            if (i == 0 || sortedV[i] != sortedV[i - 1]) {
                sortedV[uniqueCount++] = sortedV[i];
            }
        }

        FenwickTree bit = new FenwickTree(uniqueCount);
        long totalSubarrays = 0;
        for (int val : V) {
            int rank = Arrays.binarySearch(sortedV, 0, uniqueCount, val) + 1;
            totalSubarrays += bit.query(rank - 1);
            bit.add(rank, 1);
        }
        return totalSubarrays;
    }
}
