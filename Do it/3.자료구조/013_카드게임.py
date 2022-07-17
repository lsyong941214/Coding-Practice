'''
문제설명에 선입선출개념이 들어가 있어서 바로 큐 자료구조를 떠올렸다.
큐의 push, pop 시간복답도는 O(1)이므로, O(N)의 시간복잡도롤 풀이 가능
반복문 한 번당 한 장의 카드를 버리는데, N개의 카드 중 한 장이 남을때 까지 반복해야하므로 총 N-1번 반복문을 수행한다. 
'''

from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
q = deque()

for i in range(1, n+1):
    q.append(i)

# N-1번 반복
for i in range(n-1):
    # 맨 위 카드 한장 버리기
    q.popleft()         
    # 두번째 위에 있는 카드 맨 뒤에 넣기
    num = q.popleft()   
    q.append(num)       

# 마지막 남은 카드 출력
print(q[0])