'''
BFS 구현
 그래프 형태의 자료구조에서 가장 가까운 노드부터 방문하여 탐색하는 알고리즘
 
 Breadth-First-Search(너비우선탐색)은 브루트포스 탐색기법중에 하나로, 모든 경우의 수를 전부 계산하는데 너비기반으로 수행하는 자료구조이다.
 
 Deque자료구조룰 이용하여 구현
 
 시간복잡도는 O(V+E) 또는 O(V^2) //인접행렬로 구현 시
 
 동작과정
  1. 시작노드를 큐에 삽입하고, 방문테이블에 방문처리한다.
  2. 큐에서 가장 먼저들어온 노드를 꺼내서(여기서 deque개념) 꺼낸 노드중에서 방문하지않은 노드를 전부 큐에 삽입한다.
  3. 2번작업을 종료조건이 될 때까지 수행한다.

8 18
1 2
1 3
1 8
2 1
2 7
3 1
3 4
3 5
4 3
4 5
5 3
5 4
6 7
7 2
7 6
7 8
8 1
8 7

'''
# deque자료구조를 사용하기위한 import
from collections import deque

# 노드와 간선 입력받기
n, m = map(int, input().split())

# 그래프 초기화하기
graph = [[] for _ in range(n+1)]

# 그래프 입력받기
for _ in range(m):
    a,b = map(int, input().split())
    graph[a].append(b)

# visit배열 선언
visited = [False] * (n+1)

# BFS 구현
def BFS(start):
    q = deque([start])

    while q:
        dest = q.popleft()
        print(dest, " visit~")

        for i in graph[dest]:
            if not visited[i]:
                q.append(i)
                visited[i] = True
# BFS수행                
BFS(1)