# Codeforces round 741
https://codeforces.com/contest/1562

-54 :(

## Problem A: The Miracle and the Sleeper. (Solved in Contest)
https://codeforces.com/contest/1562/problem/A

<ins>Solution</ins>: If a == b solution is zero. If A/2 is > b, the solution is the max of(a%a/2, a$a+1/2), otherwise the b is greater than a/2 and the solution is a % b.

<br>
<i>Time Complexity</i>: O(1)
<br>
<i>Space Complexity</i>: O(1)

---

## Problem B: Scenes from a Memory. (Solved in Contest)
https://codeforces.com/contest/1562/problem/B

<ins>Solution</ins>: If there is a single digit in the number that is in (1, 4, 6, 8, 9) then the answer is one of those digits. Otherwise loop through and find a 2 digit number of any of the numbers in order that is not prime.

<br>
<i>Time Complexity</i>: O(k^2)
<br>
<i>Space Complexity</i>: O(1)

---

## Problem C: Rings (Solved after Contest)
https://codeforces.com/contest/1562/problem/C

<ins>Solution</ins>: We can make the observation that if a 0 falls in the left half of the number, we can get a number with the zero til the end of the string, and the number from the 0+1 to the end. Here K = 1. If there is a zero in the right half of the string we can take the number from the the start to the zero and the number from the start to the zero -1. Here k = 2. Otherwise the string is all 1s and we can just take the left half and the right half. Here again k = 1.

<br>
<i>Time Complexity</i>: O(n)
<br>
<i>Space Complexity</i>:O(n) (for the original string.)