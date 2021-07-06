# Codeforce Round 729

## Problem A: Odd Set.
https://codeforces.com/contest/1542/problem/A

<ins>Strategy</ins>: See if the number of odd numbers match the number of sets.
<br>
<i>Runtime</i>: O(N)
<br>
<i>Space Complexity</i>: O(1)
<br>

## Problem B: Plus and Multiply.
https://codeforces.com/contest/1542/problem/B

<ins>Startegy</ins>: First check to see if N is divisible by A or B-1. If so return true, otherwise check if(a^K % b = n % b) for any k where a^k <= N.
<br>
<i>Runtime</i>:: O(k)
<br>
<i>Space Complexity</i>: O(1)


## Probelm C: Strange Function.
https://codeforces.com/contest/1542/problem/C

<ins>Strategy</ins>: Accumulate (LCM of value) - (LCM of value - 1) * i for all i while lcm is < N.
<br>
<i>Runtime</i>: ~O(100)
<br>
<i>Space Complexity</i>: O(1)  

