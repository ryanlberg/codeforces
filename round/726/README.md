# Round 726
https://codeforces.com/contest/1537


## A: Arithmetic Array
https://codeforces.com/contest/1537/problem/A

<ins>Startegy</ins>: Essentially if the total is <= 0 or the difference between the total and the number of numbers is < 0.
<br>
<ins>Time Complexity</ins>: O(n)
<br>
<ins>Space Complexity</ins>: O(1)

## B: Bad Boy
https://codeforces.com/contest/1537/problem/B

<ins>Strategy</ins>: Only consider the four corners as potential spots for the yoyos. Find the maximum of visiting each corner. From that corner again find the maxium of visiting each corner and returning to start postion.
<br>
<ins>Time Complexity</ins>: O(1)
<br>
<ins>Spcae complexity</ins> O(1)


## C: Challenging Cliffs
https://codeforces.com/contest/1537/problem/C

<ins>Strategy</ins>: Sort the Array, then scan adjacent pairs to determine which values will be your start and end values. From here you can fill the array Starting from you end value and wrapping around to your<br>beginning value. Size 2 is a special case where the sorted array is the answer.
<br>
<ins>Time Complexity</ins>: O(n)
<br>
<ins>Space Complexity</ins>: O(n)

## D: Deleting Divisors
https://codeforces.com/contest/1537/problem/D

Game Theory.. I dont know.