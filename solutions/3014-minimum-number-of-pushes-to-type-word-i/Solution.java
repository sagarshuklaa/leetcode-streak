import java.util.Arrays;

// 3014. Minimum Number of Pushes to Type Word I
// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/
// Date: 2026-07-29
// Time Complexity: O(n + 26 log 26) = O(n) - counting is linear, sorting is on a fixed 26-size array
// Space Complexity: O(26) = O(1) - fixed size frequency array

class Solution {
    public int minimumPushes(String word) {
        int ans = 0;
        int[] count = new int[26];

        // Count frequency of each letter in the word
        for (final char c : word.toCharArray())
            ++count[c - 'a'];

        // Sort frequencies in ascending order
        Arrays.sort(count);

        // Assign most frequent letters to the cheapest push positions.
        // Each key can hold up to 8 letters (positions 0-7 = 1 push, 8-15 = 2 pushes, etc.)
        // Process from the most frequent letter (end of sorted array) downward,
        // multiplying by the required push count for that position group.
        for (int i = 0; i < 26; ++i)
            ans += count[26 - i - 1] * (i / 8 + 1);

        return ans;
    }
}