import java.util.Arrays;

// 1406. Stone Game III
// https://leetcode.com/problems/stone-game-iii/
// Date: 2026-08-02
// Time Complexity: O(n) - each index i is computed once due to memoization, with O(1) work per index (at most 3 inner iterations)
// Space Complexity: O(n) - for the memoization array, plus O(n) recursion stack depth

class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int[] mem = new int[stoneValue.length];
        Arrays.fill(mem, Integer.MIN_VALUE);
        final int score = stoneGameIII(stoneValue, 0, mem);
        return score > 0 ? "Alice" : score < 0 ? "Bob" : "Tie";
    }

    // Returns the maximum relative score Alice can make from stoneValue[i..n).
    private int stoneGameIII(int[] stoneValue, int i, int[] mem) {
        if (i == stoneValue.length)
            return 0;
        if (mem[i] > Integer.MIN_VALUE)
            return mem[i];

        int sum = 0;
        // Try taking 1, 2, or 3 stones starting at index i.
        // For each choice, the current player's advantage is the stones taken
        // minus whatever advantage the opponent achieves optimally afterward.
        for (int j = i; j < i + 3 && j < stoneValue.length; ++j) {
            sum += stoneValue[j];
            mem[i] = Math.max(mem[i], sum - stoneGameIII(stoneValue, j + 1, mem));
        }

        return mem[i];
    }
}