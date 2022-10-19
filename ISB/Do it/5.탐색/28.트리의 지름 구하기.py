'''
https://www.acmicpc.net/problem/1167
가장 간단한 문제풀이방식은 BFS를 노드의 갯수만큼 반복하여 가장 큰값을 구하는 것인데, O(100,000,000,000)으로 시간초과이다.
골드2난이도이기 때문에, 이렇게 간단하게 풀릴리가 없다. 노드의 개수가 100,000이기 때문에 최소한 O(nlogn)안에 풀이해야 한다.
10분 고민해봤는데, 노드를 전부 방문하지 않고 문제를 푸는 방법이 전혀 감이오지 않아 해답확인
해답의 아이디어1을 아무리봐도 무슨소리인지를 모르겠다. -> '임의의 노드에서 가장 긴 경로로 연결돼 있는 노드는 트리의 지름에 해당하는 두 노드중 하나다.'

트리의 정의를 명확하게 알지 못했기 때문에 위의 논리를 이해하지 못했었다. -> https://moonsbeen.tistory.com/101 를 보고 겨우 이해했다.
트리의 조건 중 하나가 사이클이 존재하지 않는건데, 이 조건을 활용하면 임의의 노드에서 가장 먼 노드는 트리전체중 가장 먼 노드 중에 하나이다.
따라서, 임의의 노드로 BFS를 수행하고, 임의의 노드에서 가장 먼 노드를 다시 BFS수행하면 트리의 지름이 된다.
'''
from collections import deque
import sys
input = sys.stdin.readline

v = int(input())
graph = [[] for _ in range(v+1)]

# 엣지 입력받기
for _ in range(v):
    arr = list(map(int, input().split()))
    for i in range(1, len(arr)-2, 2):
        graph[arr[0]].append((arr[i], arr[i+1]))

# BFS 수행
def bfs(start):
    visited = [False] * (v+1)
    dist = []
    q = deque()
    visited[start] = True
    q.append((start, 0))

    while q:
        now, distance = q.popleft()
        
        for (dest,cost) in graph[now]:
            if not visited[dest]:
                visited[dest] = True
                dist.append((dest, cost + distance))
                q.append((dest, cost + distance))

    max_val, max_idx = 0, 0
    for idx, cost in dist:
        if max_val < cost:
            max_val = cost
            max_idx = idx
    return max_val, max_idx

# 임의의 숫자로 BFS를 수행하고
randomNumber = 1
long_dist, long_vertax = bfs(randomNumber)

# 가장 긴 경로의 노드값으로 다시한번 BFS를 수행한다.
answer_dist, answer_vertax = bfs(long_vertax)
print(answer_dist)

'''
5
1 3 2 -1
2 4 4 -1
3 1 2 4 3 -1
4 2 4 3 3 5 6 -1
5 4 6 -1
'''