'''
1단계
문제설명이 구구절절 되어있는데, 'N개의 번호 중에 2개를 더해서 M이 되는 경우의 수를 구하라'로 요약할 수 있다.
문제의 시간제한은 2초 이므로 파이썬언어기준 6000만번안에 해답을 구해야한다.
N의 크기가 1.5만이므로 무지성 2중 for문으로 풀면 시간초과된다.
앞서 배운개념 투포인터를 적용하여 풀어야한다.
'''
import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
numbers = list(map(int, input().split()))
numbers.sort()
answer = 0

# 투 포인터 선언
left = 0
right = n-1

while left < right:
    sum = numbers[left] + numbers[right]
    if sum ==  m:
        answer += 1
        left += 1
        right -= 1
    if sum > m:
        right -= 1
    if sum < m:
        left += 1

print(answer)
'''
TC1 -> 2
6
9
2 7 4 1 5 3

TC2 -> 3
7
9
2 7 4 1 5 3 6
'''