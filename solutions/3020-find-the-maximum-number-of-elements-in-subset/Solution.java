// Problem: Find the Maximum Number of Elements in Subset
// Link:    https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/
// Date:    2026-06-27
// Time:    O(n log log maxNum) | Space: O(n)
//
// Approach: Each chain must follow x, x^2, x^4, ... pattern (palindrome
// shape). For every starting value num (except 1, handled separately),
// repeatedly square it as long as the next power exists in the count
// map with at least 2 copies (needed for both sides of the palindrome).
// Track the chain length, then decide whether the final unmatched power
// can sit alone in the middle (+1) or must be dropped (-1).
// 1s are special: any even count of 1s can all pair up except possibly
// one leftover, since 1^2 = 1 always.

import java.util.*;

public class Solution {
    public int maximumLength(int[] nums) {
        final int maxNum = Arrays.stream(nums).max().getAsInt();
        Map<Integer, Integer> count = new HashMap<>();

        for (final int num : nums)
            count.merge(num, 1, Integer::sum);

        int ans = count.containsKey(1) ? count.get(1) - (count.get(1) % 2 == 0 ? 1 : 0) : 1;

        for (final int num : nums) {
            if (num == 1) continue;
            int length = 0;
            long x = num;
            while (x <= maxNum && count.containsKey((int) x) && count.get((int) x) >= 2) {
                length += 2;
                x *= x;
            }
            // x is now x^k, and the pattern is [x, ..., x^(k/2), x^(k/2), ..., x].
            // Try inserting x^k once more in the middle (+1); if that value
            // doesn't exist, the best we can do is drop the last pair (-1).
            ans = Math.max(ans, length + (count.containsKey((int) x) ? 1 : -1));
        }

        return ans;
    }
}
