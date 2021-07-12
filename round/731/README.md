# Codeforces round 731
https://codeforces.com/contest/1547

## Problem A: Shortest Path with Obstales (Solved in Contest)
https://codeforces.com/contest/1547/problem/A

<ins>Strategy</ins>: Calculate the manhattan distance from A to B. If f shares and side with a and b and is between, Add 2 to the answer.
<br>
<i>Time Complexity</i>: O(1)
<br>
<i>Space Compleixty</i>: O(1)

<br>

## Problem B: Alphabetical Strings (Solved in Contest)
https://codeforces.com/contest/1547/problem/B

<ins>Strategy</ins>: Locate 'a' within the string. Use 2 pointers to look left and right and see if the next letter of the alphabet can be found on either side.
<br>
<i>Time Complexity</i>: O(n)
<br>
<i>Space Complexity</i>: O(n)

<br>

## Problem C: Pair Programming (Solved in Contest)
https://codeforces.com/contest/1547/problem/C

<ins>Strategy</ins>: for each programmers instruction if you can add the edit do it. If for any reason you cannot add an instruction for one or the other, it cannot be done. 
<br>
<i>Time Complexity</i>: O(a + b)
<br>
<i>Space Compleixty</i>: O(a + b)

<br>

## Problem D: Co-growing Sequence (Solved after Contest)
https://codeforces.com/contest/1547/problem/D

<ins>Strategy</ins>: We can always start with 0. From this we can find the next y[i] by using the previous x[i] ^ y[i] and notting it with the current value.
<br>
<i>Time Complexity</i>: O(n)
<br>
<i>Space Complexity</i>: O(1)

<br>

## Problem E: Air Conditioners (Solved in Contest)
https://codeforces.com/contest/1547/problem/E

<ins>Strategy</ins>: Do a sweep from left to right and from right to left. In each increment, either set the value to the min of the current value, or of the previous sweep value +1.s
<br>
<i>Time Complexity</i>: O(n)
</br>
<i>Space Complexity</i>: O(n)

<br>

## Problem D: Array Stabilization (Solved after Contest)
https://codeforces.com/contest/1547/problem/F

<ins>Strategy</ins>: Use a segment tree to store the gcd of the ranges. We can binary search the length of the initial array to find when the stabilization occurs.
<br>
<i>Time Complexity</i>: O(n*log(n))
<br>
<i>Space Complexity</i>: O(n*log(n))
