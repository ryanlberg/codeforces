# Codeforces Delitx summer 2021

https://codeforces.com/contest/1556

+11

## Problme A: A varitey of Operation. (Solved in contest)
https://codeforces.com/contest/1556/problem/A

<ins>Solution</ins>: There are a few cases. First we can check if the difference betweent he 2 numbers is even. If its not, it is impossible. Next we can check if the two numbers are equal. If the numbera are equal and  0 we need 0 moves. If the numbers are equal and not 0 it requires one move. Lastly the if the difference between the two numbers is even and they are not equal, then it will take 2 moves.

<br>
<i>Time Complexity</i>: O(1)
<br>
<i>Space Complexity</i> O(1)
<br>

---

## Problem B: Take your places. (Solved in contest)
https://codeforces.com/contest/1556/problem/B


<ins>Solution</ins>: The the absoule difference between the counts of the parity of numbers is > 1, then there is no solution. If the difference is 1, the parity with the greater number will start and end the solution, otherwise we will have to check both starting parity. We can greedily choose the next number for the parity we need and swap with the current if there is no match.

<br>
<i>Time Complexity</i>: O(n)
<br>
<i>Space Complexity</i>: O(n)
<br>

---

## Problem D: Take a guess. (solved after contest)
https://codeforces.com/contest/1556/problem/D

<ins>Solution</ins>: We can query for the "and and or" of numbers (1, 2), (2, 3), (1, 3). The sume of the and and or of these numbers will be the sum of the numbers themselves, thus by doing algebra we can come up wit the numbers. ((1,2) + (2, 3) - (1, 3))/2. Continuously do this to find all the numbers, sort then return the k'th number.

<br>
<i>Time Complexity</i>: O(n)
<br>
<i>Space Complexity</i> O(n)
<br>

---