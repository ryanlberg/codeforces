# Codeforces Round 736
+33

https://codeforces.com/contest/1549


---

## Problem A: Gregor and Cryptography. (Solved in Contest)
https://codeforces.com/contest/1549/problem/A

<ins>Strategy</ins>: Since the smallest prime possible is 5 we know that if we mode any by 2 we will have 1 as a remaineder. We will also have 1 as a remainded if we mod any N with N-1.

<br>
<i>Time Complexity</i>: O(1)
<br>
<i>Space Complexity</i>: O(1)
<br>

--- 

## Problem B: Gregor and the Pawn Game. (Solved in Contest)
https://codeforces.com/contest/1549/problem/B

<ins>Strategy</ins>: Greedily choose the furthest left spot a pawn can go to reach the end of the board.

<br>
<i>Time Compleixty</i>: O(n)
<br>
</i>Space Complexity</i>: O(n)

--- 

## Problem C: Web of Lies. (Solved in Contest)
https://codeforces.com/contest/1549/problem/C

<ins>Strategy</ins>: We know that any friend that is friends with someone higher than them will eventually die. When we add a friend, we can update whether or not they have a friend higher than them or not, and update the number of nobles that die in this way. Conversely we can do the same when we remove a frined.

<br>
<i>Time Complexity</i>: O(n + m + q) (nobles, friends, queries)
<br>
<i>Space Complexity</i> O(n + m) (object space)

---

## Problem D: Integers Have Friends. (Solved after Contest)
https://codeforces.com/contest/1549/problem/C

<ins>Strategy</ins> Create a new array consisting of the absolute difference of A[i] - A[i+1]. From here create a segment tree for the gcds of the sub ranges. Use two pointers and find the longest subarray in the new array where the gcd is > 1.

<br>
<i>Time Complexity</i>: O(n log^2 n)
<br>
</i>Space Compleixty</i>:O(n) for segment tree. (my implementation is rather large though).

---
