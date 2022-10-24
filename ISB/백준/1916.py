'''
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5

'''
from heapq import heappop, heappush
import heapq
import sys

input = sys.stdin.readline

INF = int(1e9)
n = int(input())
m = int(input())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    a,b,c = map(int, input().split())
    graph[a].append((b, c))

start, end = map(int, input().split())

distance = [INF] * (n+1)

def 다익스트라(start):
    q = [(0, start)]
    distance[start] = 0

    while q:
        now_cost, now_dest  = heapq.heappop(q)
        if distance[now_dest] < now_cost:
            continue
        for (next_dest, next_cost) in graph[now_dest]:
            if distance[next_dest] > now_cost + next_cost:
                distance[next_dest] = now_cost + next_cost
                heapq.heappush(q, (now_cost + next_cost, next_dest))

다익스트라(start)
print(distance[end])