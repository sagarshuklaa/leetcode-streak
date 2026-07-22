# 3501. Maximize Active Section with Trade II

Link: https://leetcode.com/problems/maximize-active-section-with-trade-ii/
Difficulty: Hard
Date: 2026-07-21
Topics: String, Sparse Table, Range Max Query, Greedy, Binary Lifting

## Approach
Extension of Part I but with per-query substrings instead of the whole
string, requiring O(1) range max queries via Sparse Table.

Precompute:
- prefix ones array for O(1) ones-count in any range
- zeroGroups list (each zero-run's start and length)
- zeroGroupIndex[i] = which zero-group contains position i (-1 if '1')
- mergeLengths[i] = zeroGroups[i].length + zeroGroups[i+1].length
- SparseTable over mergeLengths for O(1) range-max queries

For each query [l, r]:
1. ones = prefix ones in [l,r]
2. left = partial length of zero-group containing l (if l is in one)
3. right = partial length of zero-group containing r (if r is in one)
4. Case: l and r in adjacent zero-groups -> ones + left + right
5. Case: fully internal adjacent pairs -> sparse table range max query
6. Case: left boundary merges with first internal zero-group
7. Case: right boundary merges with last internal zero-group
Take the maximum across all cases.

## Complexity
Time: O((n + q) log n)
Space: O(n log n)

## Key Insight
Decompose the query range into: two partial boundary zero-groups (handled
case-by-case) and a range of fully-internal adjacent zero-group pairs
(handled by Sparse Table RMQ). This avoids re-scanning for each query.
