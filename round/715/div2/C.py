import sys
sys.setrecursionlimit(10000)
def solve():
    num = int(input())
    nums = list(map(int, input().split(' ')))
    nums = sorted(nums)
    start = 0
    end = len(nums) - 1
    def helper(i, j):
        if i == j:
            return 0
        elif (i, j) in seen:
            return seen[(i, j)]
        else:
            a = nums[j] - nums[i]
            seen[(i, j)] = min(a + helper(i+1, j), a + helper(i, j-1))
            return seen[(i, j)]

    return helper(start, end)  


if __name__ == "__main__":
    print(solve())