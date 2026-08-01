# 486. Predict the Winner

[Problem Link](https://leetcode.com/problems/predict-the-winner/)

- **Difficulty:** Medium
- **Date Solved:** 2026-07-31
- **Topics:** `Array` `Math` `Dynamic Programming` `Recursion` `Game Theory`

## Approach

This is a classic minimax game theory problem, solved with top-down dynamic
programming (memoized recursion).

Instead of tracking each player's score separately, track the **score difference**
(current player's score minus opponent's score) for any subarray `[left, right]`.

At each turn, the current player picks either `nums[left]` or `nums[right]`:
- Choosing `nums[left]` gives a difference of `nums[left] - dfs(left + 1, right)`,
  since the opponent then plays optimally on the remaining subarray and their
  optimal difference gets subtracted (their gain is our loss).
- Choosing `nums[right]` gives a difference of `nums[right] - dfs(left, right - 1)`.

The current player picks whichever choice maximizes this difference. The
recursion is memoized in a 2D `dp[left][right]` table since overlapping
subproblems (same `left, right` pairs) are revisited many times.

Player 1 wins or ties if and only if the final score difference `dfs(0, n-1)`
is non-negative.

## Complexity

| Metric | Complexity |
|--------|------------|
| Time   | O(n^2) - each of the O(n^2) (left, right) states is computed once due to memoization |
| Space  | O(n^2) - dp table storage, plus O(n) recursion stack depth |

## Key Insight

Rather than simulating both players' scores explicitly, reframing the problem as
a single "score difference" from the current player's perspective elegantly
captures the adversarial nature of the game: each player's optimal gain is
automatically the other player's optimal loss. This is a common and powerful
trick in two-player zero-sum game DP problems.