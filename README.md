#!/bin/bash
cd "$(dirname "$0")"

cat > README.md << 'EOF'
<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:FF6B35,100:FFA116&height=200&section=header&text=LeetCode%20Daily%20Streak&fontSize=40&fontColor=ffffff&fontAlignY=35&desc=One%20Problem.%20Every%20Day.%20In%20Java.&descAlignY=55&descSize=18" width="100%"/>

[![LeetCode](https://img.shields.io/badge/LeetCode-sagarshuklaa-FFA116?style=for-the-badge&logo=leetcode&logoColor=white)](https://leetcode.com/sagarshuklaa)
[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com)
[![Streak](https://img.shields.io/badge/🔥_Streak-Active-FF4500?style=for-the-badge)]()
[![Solved](https://img.shields.io/badge/✅_Solved-1-4CAF50?style=for-the-badge)]()

</div>

---

<div align="center">

## 🏆 Achievements

[![trophy](https://github-profile-trophy.vercel.app/?username=sagarshuklaa&theme=onestar&no-frame=true&row=1&column=6)](https://github.com/sagarshuklaa/leetcode-streak)

</div>

---

<div align="center">

## 📊 LeetCode Stats

![LeetCode Stats](https://leetcode-stats-six.vercel.app/api?username=sagarshuklaa&theme=dark)

</div>

---

## 🗓️ Solutions

<table>
  <tr>
    <th align="center">📌 #</th>
    <th>🧩 Problem</th>
    <th align="center">💢 Difficulty</th>
    <th>🏷️ Topics</th>
    <th align="center">📅 Date</th>
  </tr>
  <tr>
    <td align="center"><b>3559</b></td>
    <td><a href="solutions/3559-number-of-ways-to-assign-edge-weights-ii/"><b>Number of Ways to Assign Edge Weights II</b></a></td>
    <td align="center">🔴 Hard</td>
    <td><code>Tree</code> <code>LCA</code> <code>Binary Lifting</code> <code>Math</code></td>
    <td align="center">2026-06-12</td>
  </tr>
</table>

---

<div align="center">

## 📈 GitHub Activity

![GitHub Streak](https://streak-stats.demolab.com?user=sagarshuklaa&theme=dark&hide_border=true&fire=FF6B35&ring=FFA116&currStreakLabel=FFA116)

![GitHub Stats](https://github-readme-stats.vercel.app/api?username=sagarshuklaa&show_icons=true&theme=tokyonight&hide_border=true&count_private=true)

![Top Languages](https://github-readme-stats.vercel.app/api/top-langs/?username=sagarshuklaa&layout=compact&theme=tokyonight&hide_border=true)

</div>

---

## 📁 Structure

\`\`\`
leetcode-streak/
├── solutions/
│   └── 3559-number-of-ways-to-assign-edge-weights-ii/
│       ├── Solution.java
│       └── README.md
├── scripts/
│   └── new-solution.sh
└── .github/workflows/verify.yml
\`\`\`

---

## 🚀 Run Locally

\`\`\`bash
git clone https://github.com/sagarshuklaa/leetcode-streak.git
cd solutions/3559-number-of-ways-to-assign-edge-weights-ii
javac Solution.java && java Solution
\`\`\`

---

<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:FFA116,100:FF6B35&height=100&section=footer" width="100%"/>

*🟩 Consistency is the only shortcut — by [sagarshuklaa](https://github.com/sagarshuklaa)*

</div>
EOF

git add .
git commit -m "🎨 Epic README — stats, trophies, streak, dark theme"
git push

echo ""
echo "✅ Done! Check: https://github.com/sagarshuklaa/leetcode-streak"
