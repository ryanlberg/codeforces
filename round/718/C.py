def isvalid(x, y, s):
    return x >= 0 and x < s and y >= 0 and y < s

def solve(s, diag):
    out = [[-1 for _ in range(s)] for _ in range(s)]
    for x in range(s):
        out[x][x] = diag[x]
    
    order = [(x, x) for x in diag]
    order = order[::-1]
    i = 0
    while order:
        cur = order.pop()
        
        num = out[i][i]
        amount = out[i][i] - 1
        r = i
        c = i
        
        for x in range(amount):
            if isvalid(r, c-1, s) and out[r][c-1] == -1:
                out[r][c-1] = num
                c -= 1
            else:
                out[r+1][c] = num
                r += 1
        i += 1
    for x in range(len(out)):
        print(' '.join(str(y) for y in out[x][:x+1]))



if __name__ == "__main__":
    s = int(input())
    diag = list(map(int, input().split(' ')))
    solve(s, diag)