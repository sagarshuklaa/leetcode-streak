# 3499. Maximize Active Section with Trade I

Link: https://leetcode.com/problems/maximize-active-section-with-trade-i/
Difficulty: Medium
Date: 2026-07-20
Topics: String, Greedy, Simulation

## Approach
Process the string as consecutive runs (segments) of identical characters.

The trade works as follows (with augmented '1's at both ends):
- Pick a ones-block surrounded by zeros, convert it to zeros.
- The two surrounding zero-blocks now merge into one big zero-block
  surrounded by ones, so convert that to ones.
- Net effect: the ones-block disappears, but the two zero-blocks
  become ones. Gain = left_zero_len + right_zero_len - ones_block_len.
  But since we're maximizing, the best trade is simply:
  totalOnes + max(left_zero + right_zero) over all adjacent zero-pairs.

Track totalOnes (sum of all 1-segments) and previousZeroSegmentLength
(last seen 0-segment length). When a new 0-segment appears, update
maxZeroSegmentSum = max(maxZeroSegmentSum, prev + current).

Answer = totalOnes + maxZeroSegmentSum.

## Complexity
Time: O(n)
Space: O(1)

## Key Insight
The optimal trade always picks two adjacent zero-segments (with a
ones-block between them) and merges them. Track the best such pair
greedily in a single pass using a sliding window of two consecutive
zero-segment lengths.
