'''
https://www.acmicpc.net/problem/10989
N이 1000만이기 때문에, 문제의 입력값을 단순히 배열에 저장하면 메모리 초과가 발생한다(파이썬언어 기준).
수의 범위가 1만이기 때문에 카운트소트를 이용하여 길이가 1만인 배열로 문제를 해결했다.
'''

# from collections import deque

# import sys
# input = sys.stdin.readline

# n = int(input())
# arr = []

# for _ in range(n):
#     arr.append(int(input()))

# def getMaxDigit(num):
#     maxDigit = 1

#     while num >= 10:
#         num = num/10
#         maxDigit += 1

#     return maxDigit

# def getDigitNum(num, digit):
#     digitNum = num % 10**(digit+1)
#     return (digitNum // (10**digit))

# #O(kn)
# def radixSort(arr):
#     k = getMaxDigit(max(arr))
#     q = [deque() for _ in range(10)] # 0 ~ 9

#     for i in range(k):
#         for j in arr:
#             # 수의 i번째 자리 기준으로 큐에 푸시
#             a = getDigitNum(j, i)
#             q[a].append(j)

#         arr.clear()
#         for i in range(len(q)):
#             while q[i]:
#                 arr.append(q[i].popleft())

#     return arr

# answer = radixSort(arr)

# for i in answer:
#     print(i)



def solution():
    n = int(input())
    bucket = [0] * (10001)
    arr = []

    for _ in range(n):
        bucket[int(input())] += 1
        
    for i in range(len(bucket)):
        for j in range(bucket[i]):
            print(i)

solution()
'''
10
5
2
3
1
4
2
3
5
1
7
'''