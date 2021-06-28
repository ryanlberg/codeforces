
import sys
sys.setrecursionlimit(10000)

if __name__ == "__main__":
    n, m, k = map(int, input().split(' '))
    costs = {}
    for x in range(n):
        cost = list(map(int, input().split(' ')))
        for i, c in enumerate(cost):
            costs[(x, i, x, i+1)] = c
            costs[(x, i+1, x, i)] = c

    for x in range(n-1):
        cost = list(map(int, input().split(' ')))
        for i, c in enumerate(cost):
            costs[(x, i, x+1, i)] = c
            costs[(x+1, i, x, i)] = c

    seen = {}

    def isValid(r, c):
        return r >= 0 and r < n and c >= 0 and c < m

    def getCost(startr, startc, curr, curc, movesleft):
        if movesleft == 0:
            if startr == curr and startc == curc:
                return 0
            return float('inf')
        elif movesleft < 0:
            return float('inf')
        elif (curr, curc, movesleft) in seen:
           
            return seen[(curr, curc, movesleft)]
        else:
            around = [[0, 1], [0, -1], [1, 0], [-1, 0]]
            seen[(curr, curc, movesleft)] = float('inf')
            for x, y in around:
                newx = curr + x
                newy = curc + y
                if isValid(newx, newy):
                    
                    seen[(curr, curc, movesleft)] = min(seen[(curr, curc, movesleft)], 2 * costs[(curr, curc, newx, newy)] + getCost(newx, newy, newx, newy, movesleft - 2))
            return seen[(curr, curc, movesleft)]

    out = [[-1 for x in range(m)] for y in range(n) ]
    if not k % 2 == 0:
        for x in out:
            print(' '.join(str(y) for y in x))
    else:
        for x in range(n):
            for y in range(m):
                out[x][y] = getCost(x, y, x, y, k)
        
        for x in out:
            print(' '.join(str(y) for y in x))