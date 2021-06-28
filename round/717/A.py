def solve():
    size, changes = map(int, input().split(' '))
    nums = list(map(int, input().split(' ')))
    for x in range(len(nums)-1):
        if changes == 0:
            break
        changeable = min(nums[x], changes)
        nums[x] = nums[x] - changeable
        changes -= changeable
        nums[-1] += changeable
    return ' '.join(str(x) for x in nums)

if __name__ == "__main__":
    cases = int(input())
    for case in range(cases):
        print(solve())
