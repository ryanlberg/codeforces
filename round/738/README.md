# Codeforces Round 738
https://codeforces.com/contest/1559

-39


## Problem A: Mocha and Math. (Solved in contest).

https://codeforces.com/contest/1559/problem/A

<ins>Solution</ins>: Its sufficent to bitwise AND the numbers together to find the solution.

<br>
<i>Time Complexity</i>: O(n).
<br>
<i>Spcae Complexity</i>: O(1).

---

## Problem B: Mocha and Red and Blue.  (Solved in Contest)
https://codeforces.com/contest/1559/problem/B

<ins>Solution</ins>: I maintain two separate strings in case the first character is a '?'. For each string, if the next character is a '?' greedily choose the character that will not add to the <i>imperfectness</i>, otherwise add the letter and add to the <i>imperfectness</i> of the given string. Choose the string that has the least <i>imperfectness</i>. 

<br>
</i>Time Complexity</i>: O(n).
<br>
</i>Space Complexity</i>: O(n).

--- 

## Problem C: Mocha and Hiking. (Solved after Contest).
https://codeforces.com/contest/1559/problem/C

<ins>Solution</ins>: Notice that there are 3 separate cases of possibility to produce a Hamiltonian Path given the particular graph structure.
<ol>
    <li>There is an edge from node <b>n+1</b> to node <b>1</b>. In thise case start from node <b>n+1</b> move to node <b>1</b> and contiue moving to the next node up to node <b>n</b>.</li>
    <li>There is an edge from node <b>n</b> to node <b>n+1</b>. In this case start from node <b>1</b> and continually move to the next node up to node <b>n+1</b>.</li>
    <li>There is a node <b>i</b> in the range from <b>1</b> to <b>n</b> where node <b>i</b> is connted to node <b>n+1</b> and node <b>n+1</b> is conneted to node <b>i+1</b>.</li>
</ol>
<br>
<i>Time Complexity</i>: O(n).
<br>
<i>Space Complexity</i>: O(n).

---

## Problem D1: Mocha and Diane (Easy) (Solved after Contest).
https://codeforces.com/contest/1559/problem/D1

<ins>Solution</ins>:Use a DSU (Disjoin Set Union) for each mocah and diane and added the edges given in the problem. Loop through each set of edges and if it is possible to add one without creating a cycle, then add the edge.

<br>
<i>Time Complexity</i>:  O(n^2).
<br>
<i>Space Compleixty</i>: O(n).

--- 