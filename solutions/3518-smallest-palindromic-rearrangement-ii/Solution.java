// 3518. Smallest Palindromic Rearrangement II
// https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/
// Date: 2026-07-28
// Time Complexity: O(len * 26 * 26) - for each of the len positions in the left half,
//                   try up to 26 characters, each requiring an O(26) countWays computation
// Space Complexity: O(26) for frequency arrays, O(len) for the resulting string builder

class Solution {

    // Cap counting at a large threshold to avoid overflow, since we only care
    // whether ways >= k, not the exact large count
    static final long limit = 1_000_001L;

    public String smallestPalindrome(String s, int k) {

        // Count frequency of each character in the original palindrome
        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        // Since s is a palindrome, each character count is either even,
        // or exactly one character has an odd count (the middle character).
        // Only half of each character's count needs to be placed in the left half.
        int[] half = new int[26];
        int len = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            len += half[i];

            if ((freq[i] & 1) == 1)
                mid = (char) ('a' + i);
        }

        // If there are fewer than k distinct rearrangements possible, return empty
        if (countWays(half, len) < k)
            return "";

        // Greedily construct the left half character by character
        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < len; pos++) {

            for (int ch = 0; ch < 26; ch++) {

                if (half[ch] == 0)
                    continue;

                // Tentatively place this character and count how many
                // arrangements are possible for the remaining positions
                half[ch]--;

                long ways = countWays(half, len - pos - 1);

                if (ways >= k) {
                    // Enough arrangements remain with this choice; commit to it
                    left.append((char) ('a' + ch));
                    break;
                }

                // Not enough arrangements with this character at this position;
                // skip past all of them and try the next character
                k -= ways;
                half[ch]++;
            }
        }

        // Build the final palindrome: left half + middle char (if any) + mirrored left half
        StringBuilder ans = new StringBuilder();

        ans.append(left);

        if (mid != 0)
            ans.append(mid);

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    // Counts the number of distinct permutations of the multiset described by cnt[],
    // using a total of 'total' characters, capped at 'limit' to avoid overflow
    private long countWays(int[] cnt, int total) {

        long res = 1;

        int remaining = total;

        for (int i = 0; i < 26; i++) {

            int c = cnt[i];

            // Incrementally compute multinomial coefficient contribution for this character
            for (int j = 1; j <= c; j++) {

                res = res * (remaining - c + j) / j;

                if (res > limit)
                    return limit;
            }

            remaining -= c;
        }

        return Math.min(res, limit);
    }
}