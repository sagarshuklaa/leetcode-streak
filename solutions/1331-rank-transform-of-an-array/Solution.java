// Problem: Rank Transform of an Array
// Link:    https://leetcode.com/problems/rank-transform-of-an-array/
// Date:    2026-07-11
// Time:    O(n log n) | Space: O(n)
//
// Approach: Clone and sort the array to get elements in ascending order.
// Use a HashMap to assign ranks using putIfAbsent -- equal elements get
// the same rank, and rank.size()+1 at time of insertion gives the correct
// 1-based rank since duplicates are skipped. Replace each original element
// with its rank.

import java.util.*;

public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = arr.clone();
        Map<Integer, Integer> rank = new HashMap<>();

        Arrays.sort(sortedArr);

        for (final int a : sortedArr)
            rank.putIfAbsent(a, rank.size() + 1);

        for (int i = 0; i < arr.length; i++)
            arr[i] = rank.get(arr[i]);

        return arr;
    }
}
