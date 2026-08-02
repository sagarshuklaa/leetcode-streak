# 877. Stone Game

[Problem Link](https://leetcode.com/problems/stone-game/)

- **Difficulty:** Medium
- **Date Solved:** 2026-08-01
- **Topics:** `Array` `Math` `Dynamic Programming` `Game Theory`

## Approach

This problem is solved using the same "score difference" game-theory DP pattern
as Predict the Winner (486), but implemented bottom-up (iteratively) instead of
via memoized recursion.

Define `dp[i][j]` as the maximum number of stones the current player can end up
ahead of their opponent by, when only piles `i` through `j` remain.

Base case: when `i == j` (a single pile), the current player simply takes it,
so `dp[i][i] = piles[i]`.

Transition: for a range of length `d + 1` (where `d = j - i`), the current player
chooses either:
- The left pile `piles[i]`, leaving the opponent with `[i+1, j]`, so the
  difference becomes `piles[i] - dp[i+1][j]`
- The right pile `piles[j]`, leaving the opponent with `[i, j-1]`, so the
  difference becomes `piles[j] - dp[i][j-1]`

The player picks whichever maximizes their advantage: `dp[i][j] = max(...)`.

Iterating `d` from 1 up to `n-1` ensures smaller subranges are always computed
before the larger ranges that depend on them.

Alice (Player 1, moving first) wins if and only if `dp[0][n-1] > 0`, meaning her
final score exceeds Bob's.

## Complexity

| Metric | Complexity |
|--------|------------|
| Time   | O(n^2) - filling all (i, j) pairs in the dp table |
| Space  | O(n^2) - dp table of size n x n |

## Key Insight

Just like in Predict the Winner, tracking the score **difference** rather than
each player's absolute score turns a two-player adversarial simulation into a
single recurrence: whatever the opponent optimally gains is directly subtracted
from the current player's outcome. Building the solution iteratively by
increasing subrange length (`d`) avoids recursion overhead and stack depth
concerns for larger inputs (`n` up to 500 here vs `n` up to 20 in 486).