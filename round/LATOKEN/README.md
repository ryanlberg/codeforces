# CODEFORCES LATOKEN ROUND
https://codeforces.com/contest/1534

## Problem A: Color the flag
https://codeforces.com/contest/1534/problem/A

<ins>Strategy</ins>: Create both Arrays One which starts with 'W' one with 'R' and fill. Compare input aginst both
<br>
<i>Time Complexity</i>: O(n*m)
<br>
<i>Space Complexity</i> O(n*m)
<br>
* Implementation

## Problem B: Histogram Ugliness
https://codeforces.com/contest/1534/problem/B

<ins>Strategy</ins>: Create and array that is the differences between the current height and one height to the right. Pad the array on left and right with 0. If a column is higher than both columns on left and right, that can be decreased by the max of the two and that amound can be subtracted from the score.
<br>
<i>Time Complexity</i> O(n)
<br>
<i>Space Compleixty</i> O(n)
<br>
* implementation
* greedy

## Problem C: Little Alawn's Puzzle
https://codeforces.com/contest/1534/problem/C

<ins>Strategy</ins>: Read in the first array and store the values along with another array that stores the locations of the items in first array. Read in the second array. Use the second array to index into the first and use dfs to find the number of connected components within the two arrays.
<br>
* DFS
* Union Find

<br>
<i>Time Complexity</i>: O(n)
<br>
<i>Space Compleixty</i>: O(n)
<br>

## Problem D: Lost Tree
https://codeforces.com/contest/1534/problem/D

<ins>Strategy</ins>: Query the first Node. Check to see if the majority of the nodes are even or odd jumps away from first. Query through the lesser of the two and add all edges that are 1 away.
<br>
* constructive?

<br>
<i>Time Complexity</i>: O(n^2)
<br>
<i>Space Complexity</i>: O(n)