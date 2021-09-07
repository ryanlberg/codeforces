# Codeforces Round 742
https://codeforces.com/contest/1567 +23

## Problem A: Domino Disaster: (Solved in Contest)
https://codeforces.com/contest/1567/A

<ins>Solution</ins>: Simply read the string from left to right, If you encounter an L, append LR to the string and advance 2. Otherwise, if you see a 'D' append a 'U' or vice versae, and advance 1 space in the string.
<br>

<i>Time Complexity</i>: O(n) where n is the length of the input of the string.

---

## Problme B: MEXor Mixup: (Solved in Contest)
https://codeforces.com/contest/1567/B

<ins>Solution</ins>: Pre Compute all the xor values from 0 to 3x10^5. Once you have that you can find the xor for all values up to a, instantly. In order to have the xors equal b, you can exor the current up to a with b, and it will give you the value you need to make b. if the current xor value is alrady b, you can return a, if the current xor value xor b == b, you need to more numbers to find the minimum, otherwise you need one more number.

<br>
<i>Time Complexity</i>: O(3x10^5) for initial mex array, the O(1) for each query.

---
