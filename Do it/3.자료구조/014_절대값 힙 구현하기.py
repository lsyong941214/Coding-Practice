'''
절대값이 큰 순서대로 큐에 push pop하므로 우선순위큐를 떠올렸다.
우선순위 큐에 절대값과 부호를 저장하여, 절대값이 같은 경우를 처리한다.
우선순위 큐의 시간복잡도는 O(logN)이고, 문제를 푸는데 총 O(NlogN)이므로 시간안에 풀 수 있다.

파이썬의 우선순위큐는 heapq를 임포트하여 사용한다.
우선순위 큐에 (abs(num), num)의 형태로 삽입한다.

'''
import sys, heapq
input = sys.stdin.readline

answer = []
n = int(input())
q = []

for _ in range(n):
    m = int(input())
    if m != 0:
        heapq.heappush(q, (abs(m), m))
    else :
        # 출력
        if not q:
            print(0)
        else :
            print(heapq.heappop(q)[1])
        
'''
18
1
-1
0
0
0
1
1
-1
-1
2
-2
0
0
0
0
0
0
0
========
-1
1
0
-1
-1
1
1
-2
2
0
'''



