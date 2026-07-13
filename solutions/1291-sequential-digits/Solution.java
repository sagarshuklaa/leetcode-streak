// Problem: Sequential Digits
// Link:    https://leetcode.com/problems/sequential-digits/
// Date:    2026-07-12
// Time:    O(1) | Space: O(1)
//
// Approach: BFS from single digits 1-9. For each number, if its last
// digit < 9, generate the next sequential number by appending lastDigit+1.
// BFS naturally produces numbers in sorted order (by length then value).
// Stop as soon as a dequeued number exceeds high.

import java.util.*;

public class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        while (!q.isEmpty()) {
            final int num = q.poll();
            if (num > high) return ans;
            if (low <= num) ans.add(num);
            final int lastDigit = num % 10;
            if (lastDigit < 9)
                q.offer(num * 10 + lastDigit + 1);
        }

        return ans;
    }
}
