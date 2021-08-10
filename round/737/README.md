# Codeforces round 737
https://codeforces.com/contest/1557

+15

## Problem A: Ezzat and Two Subsequences. (Solved in Contest)
https://codeforces.com/contest/1557/problem/A

<ins>Strategy</ins>: Start of by finding the maximum number. If we add any other number to an array containing this number, the average can only shrink. The two arrays should be the largest number, and the rest, then add the two averages together.
<br>
<i>Time Complexity</i>: O(n) (sorting)
<br>
<i>Space Complexity</i>: O(1) (no need to store all the numbers, just the sum)

---

## Problem B: Moamen and k-subarrays. (Solved in Contest)
https://codeforces.com/contest/1557/problem/B

<ins>Strategy</ins>. As we're reading int he numbers, we know that if we go from a lower higher number to a lower number, or if the next number we're going to has a number inbetween we need to create a new subarray. Keeping track of this we can find the minimum number of subarrays we need to make this sorted. If that number is > k, it cant be done, otherwise it can.
<br>
<i>Time Complexity</i> O(n log(n)). need to sorted the original numbers.
<br>
<i>Space Complexity</i> O(n) need to keep track of the final sorted indexes of the valuse.

---