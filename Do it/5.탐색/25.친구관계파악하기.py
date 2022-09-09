'''
문제설명에 '이와 같은 친구관계...'라는 의미를 depth가 5이상이라는 의미로 이해하는데에 실패..
'''
import sys
sys.setrecursionlimit(10**9) # 재귀에러 해결
input = sys.stdin.readline

n, m = map(int, input().split())
answer = 0
graph = [[] for _ in range(n+1)]
visited = [False] * n

for i in range(m):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(now, depth):
    if depth >= 5:
        print(1)
        exit()
        
    for i in graph[now]:
        if visited[i] == False:
            visited[now] = True
            dfs(i, depth+1)
            visited[now] = False

for i in range(n):
    depth = 1
    visited[i] = True
    dfs(i, depth)
    visited[i] = False

print(0)


'''
5 5
0 1
1 2
2 3
3 0
1 4


8 8
1 7
3 7
4 7
3 4
4 6
3 5
0 4
2 7

6 5
0 1
0 2
0 3
0 4
0 5

5 5
0 1
1 2
2 3
3 0
1 4
'''