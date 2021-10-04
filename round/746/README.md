# Codeforces Round 746
https://codeforces.com/contest/1592
<br>
-1

## Problem A: Gamer Hemose. (Solved in Contest)
https://codeforces.com/contest/1592/problem/A

<ins>Strategy</ins>: Sort the weapons by reverse damage. Take the two weapons that have the most damage. If the healh mod sum of the two weapons ist 0, then the answers is the the health / sum of weaposn * 2. If its not zero. If the mod is less than or equal to the amount of the first weapons the answer is health/ sum of weapons * 2 + 1, otherwise health / sum of weapons * 2 + 2.
<br>
<i>Time Complexity</i>: O(n * log(n)) (sorting)
<br>

---

## Problem B: Hemose Shopping.  (Solved in Contest);
https://codeforces.com/contest/1592/problem/B

<ins>Strategy</ins>:If the moveable amoutn is less than or equal to the size of the array / 2, then the answer is yes. If not, create another array and sort the numbers. If the current number is not where it supposed to be in the array, if the number can move in either direction, then continue, otherwise the answer is no. If you make it through the whole array, then the answer is yes.
<br>
<i>Time Complexity</i>: O(n * log(n)) (sorting)
<br>

---