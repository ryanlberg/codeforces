def solve():
    size = int(input())
    nums = list(map(int, input().split(' ')))
    l = set(nums)
    if len(l) == 1:
        return "YES"
    a = 0
    for x in nums:
        a ^=  x

    if a == 0:
        return "YES"
    return "NO"


if __name__ == "__main__":
    cases = int(input())
    for case in range(cases):
        print(solve())