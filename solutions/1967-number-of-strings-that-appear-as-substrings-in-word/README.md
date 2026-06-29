# 1967. Number of Strings That Appear as Substrings in Word

Link: https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
Difficulty: Easy
Date: 2026-06-29
Topics: String, Stream

## Approach
Direct check using String.contains() for each pattern against word,
counted via Java Streams filter + count.

Given the tiny constraints (length <= 100 for both), the naive O(n*m)
substring check per pattern is more than fast enough.

## Complexity
Time: O(n * m) where n = patterns.length, m = average pattern/word length
Space: O(1)

## Key Insight
With constraints this small, the simplest built-in check (contains)
is the right tool -- no need for KMP, suffix automaton, or other
substring-matching machinery.
