from collections import deque
import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

n, m, start = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)

dfs_list = []
bfs_list = []

for _ in range(m):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 각 노드별 오름차순으로 정렬
for node in graph:
    node.sort()

# DFS
def dfs(now, graph, visited):
    visited[now] = True
    dfs_list.append(now)

    for next in graph[now]:
        if not visited[next]:
            dfs(next, graph, visited)

# BFS
def bfs(start, graph, visited):
    q = deque()
    q.append(start)
    visited[start] = True

    while q:
        now = q.popleft()
        bfs_list.append(now)
        
        for next in graph[now]:
            if not visited[next]:
                q.append(next)
                visited[next] = True

dfs(start, graph, visited)
visited = [False] * (n+1)
bfs(start, graph, visited)

for i in dfs_list:
    print(i, end=" ")
print("")
for i in bfs_list:
    print(i, end=" ")

'''
4 5 1
1 2
1 3
1 4
2 4
3 4

5 5 3
5 4
5 2
1 2
3 4
3 1

1000 1 1000
999 1000
'''