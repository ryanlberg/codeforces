import math

def isSquare(x):
    a = int(math.sqrt(x))
    return (a * a) == x

def solve():
    a = int(input())
    b = list(map(int, input().split(' ')))
    for x in b:
        if not isSquare(x):
            return "YES"
    return 'NO'


if __name__ == "__main__":
    cases = int(input())
    for case in range(cases):
        print(solve())