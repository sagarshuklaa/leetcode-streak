# 1406. Stone Game III

[Problem Link](https://leetcode.com/problems/stone-game-iii/)

- **Difficulty:** Hard
- **Date Solved:** 2026-08-02
- **Topics:** `Array` `Math` `Dynamic Programming` `Game Theory`

## Approach

This extends the "score difference" game-theory DP pattern (seen in 486 and 877)
to a scenario where a player can take 1, 2, or 3 stones from the front of the row
instead of only from either end.

Define `mem[i]` as the maximum relative score (current player's advantage over
the opponent) achievable starting from index `i` to the end of the array.

At index `i`, the current player tries taking 1, 2, or 3 stones (bounded by the
array length). For each choice `j` (ending index of the taken stones), the
resulting advantage is:
meaning: the stones just taken, minus whatever advantage the opponent can
achieve optimally on the remaining stones. The player picks the option that
maximizes this value.

Since taking 1, 2, or 3 stones only depends on a fixed small window, and each
index `i` is solved independently and memoized, the recursion naturally reduces
to O(n) states with O(1) transitions each.

Finally:
- If the overall relative score `mem[0] > 0`, Alice wins.
- If `mem[0] < 0`, Bob wins.
- If `mem[0] == 0`, it's a Tie.

## Complexity

| Metric | Complexity |
|--------|------------|
| Time   | O(n) - each of the n states is computed once, with at most 3 inner iterations per state |
| Space  | O(n) - memoization array plus O(n) recursion stack depth |

## Key Insight

Unlike Stone Game (877), where a player picks from either end of the array
(leading to an O(n^2) 2D DP over ranges), this variant restricts moves to the
front of the row only, collapsing the state space down to a single dimension
`i`. The same score-difference trick applies, but the fixed take-1-2-or-3
constraint keeps the transition O(1) per state, yielding a linear time solution
even for arrays as large as 5 * 10^4.