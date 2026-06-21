// Problem: Maximum Ice Cream Bars
// Link:    https://leetcode.com/problems/maximum-ice-cream-bars/
// Date:    2026-06-21
// Time:    O(n log n) | Space: O(1)

import java.util.*;

public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        for (int i = 0; i < costs.length; ++i)
            if (coins >= costs[i])
                coins -= costs[i];
            else
                return i;

        return costs.length;
    }
}
