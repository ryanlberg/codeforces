# Harbour Space Round
https://codeforces.com/contest/1553

Rating +142

---
## Problem A: Digits Sum (Solved in Contest)
https://codeforces.com/contest/1553/problem/A 

<ins>Strategy</ins>: Because the interesting change happens when the current value x ends in a 9. It is suffucient to calculate: (x + 1)/10.

<br>
<i>Time Complexity</i>: O(1)
<br>
<i>Space Complexity</i>: O(1)


---
## Prolbem B: Reverse String (Solved in Contest)
https://codeforces.com/contest/1553/problem/B ()

<ins>Strategy</ins>: Locate all the potential starting points in the original string. From each, see if the bottom string can be made by first moving right, then moving left.

<br>
<i>Time Complexity</i>: O(n^2)
<br>
<i>Space Complexity</i>: O(n)

---

## Problem C: Penalty (Solved in Contest)
https://codeforces.com/contest/1553/problem/C

<ins>Strategy</ins>: If there are '?' in the string, Either team one will win the earliest or team two will. Have two separate scenarios when team 1 will score all it can and team two will score no more and vice versa. Calculate the minimum of each scenario and return the result.

<br>
<i>Time Complexity<i>: O(n)
<br>
<i>Space Complexity</i>: O(n)

---

## Problem D: Backspace (Solved in Contest)
https://codeforces.com/contest/1553/problem/D

<ins>Stratgy</ins>: Start from the end of the string. Greedily take a character if you can. If not remove move 2 characters to the left in the original String. At the end, check if the whole string has been created.

<br>
<i>Time Complexity</i>: O(n)
<br>
<i>Space Complexity</i>: O(n)
<br>

---