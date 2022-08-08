# import sys
# input = sys.stdin.readline

# n  = int(input())

# sum = 1
# count = 1
# start_index = 1
# end_index = 1

# while end_index < n:
#     if sum < n:
#         end_index += 1
#         sum += end_index
#     elif sum > n:
#         sum -= start_index
#         start_index += 1
#     else :
#         end_index += 1
#         sum += end_index
#         count += 1

# print(count)

# '''
# [1단계]
# n의 범위가 천만이므로, O(n)의 시간복잡도로 정답을 구해야한다.
# 투 포인터를 이용하면 하나의 반복문으로 답을 구할 수 있다.

# [2단계]

# '''



'''
백준 2018번
https://www.acmicpc.net/problem/2018
1번처럼 그냥 2중 for문으로 풀면 시간초과가 발생한다. 구간합이 더 커지거나 정답을 찾은경우에 break를 걸었음에도 시간초과다.
투 포인터를 이용해서 문제를 풀어야 시간초과가 걸리지 않는다.

'''

# 1번 풀이
n = int(input())
answer = 0
sums = [0 for _ in range(n+1)]

for i in range(1, n+1):
    sums[i] = sums[i-1] + i
print(sums)

front = 0
back = front + 1

while front <= n and back <= n:
    sum = sums[back] - sums[front]
    if sum < n:
        back += 1
    else:
        front += 1
        back = front+1
        
print(answer)