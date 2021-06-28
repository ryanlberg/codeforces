
def solve():
    length = int(input())
    cur = input()
    Ts = []
    Ms = []
    i == 0
    j == len(cur) - 1
    while i <= j:
        if i == j:
            if cur[i] == 'T':
                if Ts:
                    Ts.pop()
            i += 1
        else:
            a = cur[0]
            b = cur[1]
            if a == 'T' and b == 'T':
                Ms.append('M')
                i += 1
                j += 1
            elif (a == 'M' and b == 'T') or (b == 'M' and a == 'T'):
                 



if __name__ == "__main__":
    cases = int(input())
    for case in range(cases):
        a = solve()
        if a:
            print("YES")
        else:
            print("NO")