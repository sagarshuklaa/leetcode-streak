# 1. Two Sum

🔗 [View on LeetCode](https://leetcode.com/problems/two-sum/)

**Difficulty:** 🟢 Easy  
**Date Solved:** 2026-06-12  
**Topic Tags:** `Array` `Hash Table`

---

## 📝 Problem Statement

> Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`. You may assume exactly one solution exists.

---

## 💡 Approach

Use a **HashMap** to store each number and its index as we iterate. For every element, check if its complement (`target - nums[i]`) has already been seen. If yes, we found our pair.

This avoids the O(n²) brute-force double loop.

---

## ⏱️ Complexity

| | Complexity |
|---|---|
| **Time** | O(n) |
| **Space** | O(n) |

---

## 🔑 Key Insight

> Look backwards — store what you've seen and check if the current number's complement already exists.
