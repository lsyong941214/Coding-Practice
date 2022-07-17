n = int(input())
arr = list(map(int, input().split()))
stk = [0]
answer = [-1] * (n)

for i in range(1, n):
    while stk and arr[i] > arr[stk[-1]]:
        answer[stk.pop()] = arr[i]
    stk.append(i)

for i in answer:
    print(i, end=' ')

'''
4
3 5 2 7

4
9 5 4 8
'''