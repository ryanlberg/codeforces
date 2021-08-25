# Codeforces round 740

https://codeforces.com/contest/1561
+9

## Problem A: Simply Strange Sort. (Solved in Contest)
https://codeforces.com/contest/1561/problem/A

<ins>Solution</ins>: For problem A, A sort is described. The constraints of the problem are low enough so that simply implementing the sort in teh problme is sufficient.

<br>
<i>Time Complexity</i>: O(n^2)
<br>
<i>Space Complexity</i>: O(n)


---

## Problem B: Charmed by the Game. (Solved after Contest)
https://codeforces.com/contest/1561/problem/B

<ins>Solution</ins>: The first step is to find the minimum number of breaks that are possible for the tennis match. Since either player can start, the breaks are symmetric so you can add the min_break amount as well as the total game number minus the min break amount. From here you can swap games for the minimum number of a or b. This will add 2 breaks to the minimum number each time. Again add both the min_breaks + the swaps and the sum of both minus that amount.

<br>
<i>Time Complexity</i>: O(min(A, B))
<br>
<i>Space Complexity</i>: O(min(A, B))

---

## Problem C: Deep Down Below. (Solved in Contest)
https://codeforces.com/contest/1561/problem/C

<ins>Solution</ins>: For each cave, I found the minimum power needed to complete the cave. I saved this value as well as the cave size into a list of (min needed to enter, cave size). I sorted this list by min to enter, and the reverse of cave size in case of tie. Iterate through the list starting from the min needed to enter and calculate the current power of here. If hero is not high enough level to enter the cave, the difference between his current power and power needed to enter needs to be added to min power. For each cave calculate this value and at the end the minimum power needed at the start will be obtained.

<br>
<i>Time Complexity</i>: O(n log(n)).
<br>
<i>Space Complexity</i>:O(n)

---