// Problem: Weighted Word Mapping
// Link:    https://leetcode.com/problems/weighted-word-mapping/
// Date:    2026-06-13
// Time:    O(n x m)
// Space:   O(n)

public class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        var ans = new StringBuilder();
        for (var w : words) {
            int s = 0;
            for (char c : w.toCharArray()) {
                s = (s + weights[c - 'a']) % 26;
            }
            ans.append((char) ('a' + (25 - s)));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] w1 = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        int[] w2 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(sol.mapWordWeights(new String[]{"abcd","def","xyz"}, w1)); // rij
        System.out.println(sol.mapWordWeights(new String[]{"a","b","c"}, w2));        // yyy
    }
}
