// Problem: Smallest Subsequence of Distinct Characters
// Link:    https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
// Date:    2026-07-18
// Time:    O(n) | Space: O(1)
//
// Approach: Greedy + Monotonic Stack.
// For each char, decrement its remaining count. If already used, skip.
// While the last char in stack is greater than current AND still appears
// later (count > 0), pop it (mark unused). Then push current char.

public class Solution {
    public String smallestSubsequence(String text) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[128];
        boolean[] used = new boolean[128];

        for (final char c : text.toCharArray())
            ++count[c];

        for (final char c : text.toCharArray()) {
            --count[c];
            if (used[c]) continue;
            while (sb.length() > 0 && last(sb) > c && count[last(sb)] > 0) {
                used[last(sb)] = false;
                sb.setLength(sb.length() - 1);
            }
            used[c] = true;
            sb.append(c);
        }

        return sb.toString();
    }

    private char last(StringBuilder sb) {
        return sb.charAt(sb.length() - 1);
    }
}
