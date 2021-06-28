def solve():
    r, m = map(int, input().split(' '))
    paths = []
    for _ in range(r):
        path = list(map(int, input().split(' ')))
        path = sorted(path)
        paths.append(path)
    out = [[] for x in range(r)]
    for x in range(m):
        mins = [10**9+1, -1]
        
        for i, x in enumerate(paths):
            if x[0] < mins[0]:
                mins = [x[0], i]
        
        for i, x in enumerate(paths):
            if not i == mins[1]:
                out[i].append(paths[i].pop())
            else:
                out[i].append(paths[mins[1]].pop(0))
    for p in out:
        print(' '.join(str(x) for x in p))

if __name__ == "__main__":
    cases = int(input())
    for case in range(cases):
        solve()