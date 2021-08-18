# Codeforces Round 739
https://codeforces.com/contest/1560

## Problem A: Dislike of Threes. (Solved in Contest)
https://codeforces.com/contest/1560/problem/A

<ins>Strategy</ins>: Since the queries can only be up to 1000, generate the first 1000 numbers that are not divisible by 3 or the numbers where N % 10 does not equal 3.

<br>
<i>Time Complexity</i>: O(1000) to generate the numbers, O(1) for each query.
<br>
<i>Space Complexity</i>: O(1000) to hold the 1000 numbers

---

## Problem B: Who's Opposite. (Solved in Contest)
https://codeforces.com/contest/1560/problem/B

<ins>Strategy</ins>: Because we have an example, we know that the biggest number we can get is the absolute diffrence of the two numbers in our example multiplied by 2. if any of the numbers are outside the range we can return -1. If our number is in the range, if its greater than half, we know the remaining number has to be below the halfway point, otherwise it has to be above. 

<br>
<i>Time Complexity</i>: O(1)
<br>
<i>Space Complexity</i>: O(1)

---

## Problem C: Infinity Table. (Solved in Contest)
https://codeforces.com/contest/1560/problem/C

<ins>Strategy</ins>: I noticed that moving down the first column, all the numbers are perfect squares. I continued down this column until I reached a perfect square which was greater than the number I was trying to query, then followed the table to the left, then up until hitting upon the requested number.

<br>
<i>Time Complexity</i>:O(N * sqrt(N)).
<br>
<i>Space Complexity</i>: O(1).

---

## Problem D: Make a Power of two. (Solved in Contest)
https://codeforces.com/contest/1560/problem/D

<ins>Strategy</ins>: Since there were so few powers of 2 that fall within the range, I generated all the powers of 2 that fit into a long. Once I had this number, I did a string comparison for the each power of 2 and the current number and pick the minimum value of these or the minimum value of deleting all the numbers, and addind all the numbers in that power of 2.

<br>
<i>Time Complexity</i>: O(n) * number of power of 2s that fit into a long.
<br>
<i>Space Complexity</i>: O(number of powers of 2 that fit into a long)

---

## Problem E: Polycarp and String Transformation. (Solved after Contest)
https://codeforces.com/contest/1560/problem/E

<ins>Strategy</ins>: 
<br>
<i>Time Complexity</i>:
<br>
<i>Space Complexity</i>:

---

## Problem F1: Nearest Beautiful Number (easy verssion). (Solved after Contest)
https://codeforces.com/contest/1560/problem/F1

<ins>Strategy</ins>: 
<br>
<i>Time Complexity</i>:
<br>
<i>Space Complexity</i>:

---

## Problem F2: Nearest Beautiful Number (hard version). (Solved after Contest).
https://codeforces.com/contest/1560/problem/F2

<ins>Strategy</ins>: 
<br>
<i>Time Complexity</i>:
<br>
<i>Space Complexity</i>:

---