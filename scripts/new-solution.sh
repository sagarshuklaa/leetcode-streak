#!/bin/bash
# Usage: ./scripts/new-solution.sh 0042 trapping-rain-water

set -e

NUM=$1
SLUG=$2

if [ -z "$NUM" ] || [ -z "$SLUG" ]; then
  echo "Usage: ./scripts/new-solution.sh <problem-number> <problem-slug>"
  echo "Example: ./scripts/new-solution.sh 0042 trapping-rain-water"
  exit 1
fi

DIR="solutions/${NUM}-${SLUG}"

if [ -d "$DIR" ]; then
  echo "❌ Directory already exists: $DIR"
  exit 1
fi

mkdir -p "$DIR"

# Create Solution.java from template
cat > "$DIR/Solution.java" << EOF
// Problem: $(echo "$SLUG" | tr '-' ' ' | awk '{for(i=1;i<=NF;i++) $i=toupper(substr($i,1,1)) substr($i,2)}1')
// Link:    https://leetcode.com/problems/${SLUG}/
// Date:    $(date +%Y-%m-%d)
//
// Approach: [Brief description]
// Time:     O(?)
// Space:    O(?)

public class Solution {

    // TODO: Add your solution method here

    public static void main(String[] args) {
        Solution sol = new Solution();
        // TODO: Add test cases
    }
}
EOF

# Create README.md from template
cat > "$DIR/README.md" << EOF
# ${NUM#0}. $(echo "$SLUG" | tr '-' ' ' | awk '{for(i=1;i<=NF;i++) $i=toupper(substr($i,1,1)) substr($i,2)}1')

🔗 [View on LeetCode](https://leetcode.com/problems/${SLUG}/)

**Difficulty:** 🟢 Easy / 🟡 Medium / 🔴 Hard
**Date Solved:** $(date +%Y-%m-%d)
**Topic Tags:** \`Tag1\` \`Tag2\`

---

## 📝 Problem Statement

> Paste or summarize the problem here.

---

## 💡 Approach

Explain your thought process here.

---

## ⏱️ Complexity

| | Complexity |
|---|---|
| **Time** | O(?) |
| **Space** | O(?) |

---

## 🔑 Key Insight

> One-liner describing the "aha" moment.
EOF

echo "✅ Created: $DIR"
echo "   → $DIR/Solution.java"
echo "   → $DIR/README.md"
