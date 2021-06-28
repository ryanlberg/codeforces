import math
def getPrimesFactors(n):
    factors = set()
    while n % 2 == 0:
        factors.add(2)
        n //= 2
    for i in range(3, int(math.sqrt(n)) +1, 2):
        while n % i == 0:
            factors.add(i)
            n //= i

        if n < i:
            break
    if n > 2:
        factors.add(n)
    
    return factors

fact = {}
num = []

def solve(l, r):
    fseen = set()
    parts = 1
    for x in range(l, r):
        l = fact[nums[x]]
        for y in l:
            if y in fseen:
                parts += 1
                fseen = set()
                x -= 1
                break
            else:  
                fseen.add(y)
    return parts
            
if __name__ == "__main__":
    size, queries = map(int, input().split(' '))
    fact = {}
    num = []
    nums = list(map(int, input().split(' ')))
    for x in nums:
        if x not in fact:
            fact[x] = getPrimesFactors(x)

    for x in range(queries):
        l, r = map(int, input().split(' '))
        l -= 1
        r
        print(solve(l, r))
