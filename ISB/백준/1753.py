'''
stdin.readline으로 받지 않으면 시간초과 발생 -> ..?
for문 안에서 문자를 입력받을 때는 input대신 sys.stdin.readline()으로 입력받는 것이 유리하다
input은 프롬포터 메세지를 받아 출력하는 기능과 버퍼에 저장하는 기능이 있기 때문에, 개행문자포함한 한줄을 읽는 readline()으로 입력받는게 훨씬 빠르다
'''
import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)
n, m  = map(int, input().split())
start = int(input())
graph = [ [] for _ in range(n+1) ]
distance = [INF] * (n+1)

for _ in range(m):
    a,b,c = map(int, input().split())
    graph[a].append((b,c))

def 다익스트라(start):
    q = [[0, start]]
    distance[start] = 0

    while q:
        cur_cost, cur_node = heapq.heappop(q)
        
        if cur_cost > distance[cur_node]:
            continue

        for (next_node, next_cost) in graph[cur_node]:
            if next_cost + cur_cost < distance[next_node]:
                distance[next_node] = next_cost + cur_cost
                heapq.heappush(q, (next_cost + cur_cost, next_node))

다익스트라(start)        
for i in distance[1:]:
    if i == INF:
        print('INF')
    else:
        print(i)