import math
def solve():
    a, b = map(int, input().split(' '))
    
    return (a ** b) % (10**9 + 7) 

if __name__ == "__main__":
    cases = int(input())
    for case in range(cases):
        print(solve())