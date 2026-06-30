// Problem: Number of Substrings Containing All Three Characters
// Link:    https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
// Date:    2026-06-30
// Time:    O(n) | Space: O(1)
//
// Approach: Sliding window. Similar to LeetCode 3 (Longest Substring
// Without Repeating Characters). Expand right pointer, and whenever the
// window contains all of a, b, c, shrink from the left as much as
// possible while still containing all three. At that point, every
// substring starting from index 0..l-1 and ending at the current right
// pointer is valid, so add l to the answer.

public class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int[] count = new int[3];

        int l = 0;
        for (final char c : s.toCharArray()) {
            ++count[c - 'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0)
                --count[s.charAt(l++) - 'a'];
            // s[0..r], s[1..r], ..., s[l - 1..r] are satisfied substrings.
            ans += l;
        }

        return ans;
    }
}
