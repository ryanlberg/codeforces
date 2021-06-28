import sys
sys.setrecursionlimit(10000)

def solve():
    length = int(input())
    evens = []
    odds = []
    nums = list(map(int, input().split(' ')))
    for x in nums:
        if x % 2 == 0:
            evens.append(x)
        else:
            odds.append(x)
    total = odds + evens
    return ' '.join(str(x) for x in total)

if __name__ == "__main__":
    cases = int(input())
    for case in range(cases):
        print(solve())