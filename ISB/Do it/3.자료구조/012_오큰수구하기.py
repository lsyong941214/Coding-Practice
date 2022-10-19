'''
N의 크기가 백만이므로, O(n) 또는 O(n*logn)안에 풀어야 한다.

스택을 활용하여 풀어야 시간안에 정답을 찾을 수 있다.

핵심 아이디어는 아래 2개이다.
1. i의 오큰수를 구하지 못한 경우, i+1의 오큰수를 구할때 같이 구할 수 있다. (만약 i의 오큰수가 존재한다면, i의 오큰수와 i+1의 오큰수는 같기 때문)
2. 오큰수의 인덱스를 저장하기 위해 스택자료구조를 이용한다.
'''
import sys
input = sys.stdin.readline()

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