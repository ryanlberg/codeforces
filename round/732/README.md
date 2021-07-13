# Codeforces Round 732
https://codeforces.com/contest/1546

## Problem A: AquaMoon and Two Arrays (Solved in Contest)
https://codeforces.com/contest/1546/problem/A

<ins>Strategy</ins>: It can only be done if both arrays share the same numbers. Two for loops, If the numbers dont match find a number in the first that can compensate for it up or down.
<br>
<i>Time Compleixty</i>: O(n^2)
<br>
<i>Space Compleixty</i>: O(n)

<br>

## Problem B: AquaMoon and Stolen String (Solved in Contest)
https://codeforces.com/contest/1546/problem/B

<ins>Strategy</ins>: Each letter will show up twice in the position it is in except for the word two be returned. Add all original letters at their index, and subtract them from the mixed up set. You will only be left with the missing word.

<i>Time Complexity</i>: O(words * len(words))
<br>
</i>Space Complexity</i>: O(len(wwords) * 26)

<br>

## Problem C: AquaMoon and Strange Sort (Solved after Contest)
https://codeforces.com/contest/1546/problem/C

<ins>Strategy</ins>: Each word needs to move an even number of spaces. The ones already in an even postion must end in an even position. Keep track of the movements of all odd and even numbers and make sure they are all zero.

<i>Time Complexity</i>: O(n * log(n)) (sorting)
</br>
<i>Space Complextiy</i> O(n)
</br>
