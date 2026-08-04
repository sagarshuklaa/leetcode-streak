# 3731. Find Missing Elements

[Problem Link](https://leetcode.com/problems/find-missing-elements/)

- **Difficulty:** Easy
- **Date Solved:** 2026-08-03
- **Topics:** `Array` `Hash Table` `Sorting`

## Approach

Since the array's smallest and largest values define the original full range,
the problem reduces to finding which integers within `[minVal, maxVal]` are
absent from `nums`.

Steps:
1. Traverse `nums` once, adding every value to a `HashSet` for O(1) lookups,
   while simultaneously tracking `minVal` and `maxVal`.
2. Iterate over every integer from `minVal` to `maxVal` in order, checking
   whether each is present in the set. Any integer not found is appended to
   the result list.

Because the iteration in step 2 proceeds in increasing order, the resulting
list is naturally sorted without needing an explicit sort step.

## Complexity

| Metric | Complexity |
|--------|------------|
| Time   | O(range + n) - one pass to build the set (O(n)), one pass over the range (O(maxVal - minVal)) |
| Space  | O(n) for the hash set, plus O(range) in the worst case for the output list |

## Key Insight

Using a hash set for membership checks avoids repeated linear scans of `nums`,
turning each presence check into O(1). Since the full range is bounded by
`minVal` and `maxVal` (both guaranteed to be present in the array), scanning
that range directly yields a sorted result for free, no separate sorting
step needed.