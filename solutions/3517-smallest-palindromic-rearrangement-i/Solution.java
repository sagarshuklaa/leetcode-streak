import java.util.Arrays;

// 3517. Smallest Palindromic Rearrangement I
// https://leetcode.com/problems/smallest-palindromic-rearrangement-i/
// Date: 2026-07-27
// Time Complexity: O(n log n) - dominated by sorting the first half of the string
// Space Complexity: O(n) - for the char array and resulting strings

class Solution {
    public String smallestPalindrome(String s) {
        final int n = s.length();

        // Sort only the first half of the string to get the smallest arrangement
        final String sortedHalf = getSortedHalf(s);

        // Build the full palindrome:
        // sortedHalf + (middle character if odd length) + reverse(sortedHalf)
        return sortedHalf + (n % 2 == 1 ? String.valueOf(s.charAt(n / 2)) : "") + reversed(sortedHalf);
    }

    // Extracts and sorts the first half of the string in ascending order
    private String getSortedHalf(final String s) {
        final String half = s.substring(0, s.length() / 2);
        char[] chars = half.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // Returns the reverse of a given string
    private String reversed(final String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
