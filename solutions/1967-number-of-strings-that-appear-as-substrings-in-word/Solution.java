// Problem: Number of Strings That Appear as Substrings in Word
// Link:    https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
// Date:    2026-06-29
// Time:    O(n * m) | Space: O(1)

import java.util.*;

public class Solution {
    public int numOfStrings(String[] patterns, String word) {
        return (int) Arrays.stream(patterns).filter(pattern -> word.contains(pattern)).count();
    }
}
