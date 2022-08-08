'''
6 5
1 2
2 5
5 1
3 4
4 6

6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3
연결 요소의 개수를 구하는 기본적인 dfs/bfs문제이다.
연결 요소란 노드간에 서로 연결된 것을 의미하여, 이 연결요소의 개수를 구하기 위해서는 한 노드에서 DFS를 수행하여 방문한 노드들의 그룹이 연결요소가 된다.
노드의 갯수만큼 반복하여, 해당 노드가 방문한 상태가 아니라면 dfs를 수행한다. dfs수행 횟수가 정답이 된다.
그런데, 계속 백준에서 런타임 에러 (RecursionError)가 발생하였다. 원인은 최대 재귀 깊이를 초과해서였다.
BOJ채점서버에서 파이썬의 최대 재귀 깊이는 1,000이라서 오류가 발생한 것이다.

sys.setrecursionlimit(10**6)
위의 명령어로 깊이를 10^6까지 증가시켜서 문제를 해결했다.
'''
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
visited = [False] * (n+1)

# 그래프 입력 받기
graph = [[] for _ in range(n+1)]
for i in range(m):
    a, b = map(int, input().split())
    # 무방향이므로 양쪽 노드에 다 저장한다.
    graph[a].append(b)
    graph[b].append(a)

# DFS 수행
def dfs(node):
    visited[node] = True
    for i in graph[node]:
        if not visited[i]:
            dfs(i)

# 메인
answer = 0
for i in range(1, n+1):
    if visited[i] == False:
        dfs(i)
        answer += 1
print(answer)