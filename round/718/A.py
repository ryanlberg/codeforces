def solve():
    cur = int(input())
    nums = 0
    while cur >= 2050:
        a = 2050
        while a <= cur:
            a *= 10
        a //= 10
        cur -= a
        nums += 1
        
    if cur == 0:
        return nums
    return -1
if __name__ == "__main__":
    cases = int(input())
    for case in range(cases):
        print(solve())