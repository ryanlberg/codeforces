# Codeforces Round 736
https://codeforces.com/contest/1549

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