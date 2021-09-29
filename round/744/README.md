# Codeforces Round 744
https://codeforces.com/contest/1579
 
 +138


## Problem A: Casimirs String Solitaire. (Solved in Contest)
https://codeforces.com/contest/1579/problem/A

<ins>Strategy</ins>: Count the number of each letter. If the number of A's + the number of C's was equal to the number of B's, then the answer was YES, otherwise NO.
<br>
<i>Time Complexity</i>: O(n)
<br>

---

## Problem B: Shifting Sort. (Solve in Contest)
https://codeforces.com/contest/1579/problem/B

<ins>Strategy</ins>: Use an alternate array and sort the original. Compare the original array against the sorted, if they dont match, find where the match is and do the rotation of location of next value - currentlocation.
<br>
<i>Time Complexity</i>:  O(n^2)
<br>

---

## Problem C: Ticks. (Solved in Contst)
https://codeforces.com/contest/1579/problem/C

<ins>Strategy</ins>: For each tick mark in the board, go as far up on each side as you can. If the amount is >= to the k value, then mark them on a checked board. If all points have been marked then output "YES" otherwise "NO".
<br>
<i>Time Complexity</i>: O(n^2)
<br>

---

## Problem D: Productive Meeting. (Solved in Contest)
https://codeforces.com/contest/1579/problem/D

<ins>Strategy</ins>: Use a Priority Queue and insert each person. The people with the most meetings will have one first. If they still have meetings left, reinsert them into the Priorty queue, otherwise dont. 
<br>
<i>Time Complexity</i>: O(n*log(n))
<br>

---

## Problem E: Permutation Minization by Deque. (Solved In Conetst).
https://codeforces.com/contest/1579/problem/E1

<ins>Strategy</ins>: Using a deque. If the current value is less than the first value insert it into the front, otherwise insert it into the end.
<br>
<i>Time Complexity</i>: O(n)
<br>

---

## Problem E2: Array Optimization by Deque. (Solved after Contest).
https://codeforces.com/contest/1579/problem/E2

<ins>Strategy</ins>: First of all you need to do cooridnate compression so all values fit in the range from 1 to 2*10^5. Once this is done add each value to a segment tree. Before adding, find the sum of all the values in the range from 1 to current_value -1 and current_value+1 to size of tree. Add the minimum of this to the total, then add the value to the tree. Greedy Solution.
<br>
<i>Time Complexity</i>: O(n * log(n))
<br>

---