

holder = {}
nums = []

def test(i, j, cur, maxnum):
    if cur >= len(nums):
        return min(nums[i], nums[j], maxnum)

    if (i, j, maxnum) in holder:
        return max(holder[(i, j, maxnum)], maxnum)
    
    l = 0
    holder[(i, j, maxnum)] = min(nums[i], maxnum)
    while l + (2+l) < nums[cur]:
        nums[cur] -= l + (2*l)
        nums[j] += l
        nums[i] += (2*l)
        holder[(i, j, maxnum)] = max(holder[(i, j, maxnum)], test(i+1, j+1, cur+1, min(maxnum, nums[i])))
        nums[cur] += l + (2*l)
        nums[j] -= l
        nums[i] -= 2*l
        l += 1

    return holder[(i, j, maxnum)]


if __name__ == "__main__":
    size = int(input())
   
    for x in range(size):
        l = input()
        nums = list(map(int, input().split(' ')))
        print(test(0, 1, 2, 10**9))

