from collections import deque

n, m = map(int, input().split())
arr = []
dir = [(-1,0), (0,-1), (1,0), (0,1)]

for i in range(n):
    arr.append(list(map(int, input())))

def bfs(x, y):
    q = deque()
    q.append((x,y))
    
    while q:
        x, y = q.popleft()
        #북동남서 이동가능여부 확인
        for i in dir:
            nx, ny = x + i[0], y + i[1]
            # 범위 체크
            if nx < 0 or ny < 0 or nx > n-1 or ny > m-1:
                continue
            if arr[nx][ny] == 1:
                arr[nx][ny] = arr[x][y]+1
                q.append((nx, ny))

bfs(0,0)
print(arr[n-1][m-1])

'''
4 6
101111
101010
101011
111011

4 6
110110
110110
111111
111101

2 25
1011101110111011101110111
1110111011101110111011101

7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
'''