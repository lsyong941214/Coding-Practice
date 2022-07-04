'''
# 1단계
이 문제는 최악의 경우 연산횟수가 1억번이므로 합배열을 활용해야 한다.
2차원 합배열을 만드는게 포인트
그림참고.

'''
n, tc = map(int, input().split())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))
tcArr = []
for _ in range(tc):
    tcArr.append(list(map(int, input().split())))

# 합배열 구하기
sum = [[0 for _ in range(n+1) ] for _ in range(n+1)]
for i in range(1, n+1):
    for j in range(1, n+1):
        sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i-1][j-1]

for i in tcArr:
    x1,y1,x2,y2 = i[0], i[1], i[2], i[3]
    print(sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1])

'''
입출력
4 3
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
3 4 3 4
1 1 4 4

27
6
64
'''