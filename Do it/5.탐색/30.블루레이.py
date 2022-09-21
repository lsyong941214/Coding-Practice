import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

min_val = max(arr)
max_val = sum(arr)
result = max_val

# 길이가 num일 때의 블루레이 갯수 구하기
def get_blueray_cnt(num):
    sum = 0
    blueray_cnt = 1
    idx = 0

    for idx in range(n):
        target = sum + arr[idx]
        if target <= num:
            sum = target
        else:
            blueray_cnt += 1
            sum = arr[idx]

    return blueray_cnt

# 이진탐색( 블루레이 갯수가 m보다 크면 왼쪽 탐색, 반대면 오른쪽 탐색)
def binary_search(left, right):
    global result
    if left > right:
        return result
    
    mid = (left+right) // 2
    blueray_cnt = get_blueray_cnt(mid)
    print(mid, blueray_cnt)

    # 왼쪽 탐색
    if blueray_cnt <= m :
        result = min(result, mid)
        return binary_search(left, mid-1)
    elif blueray_cnt > m:
        return binary_search(mid+1, right)

print( binary_search(min_val, max_val) )

''''
9 3
1 2 3 4 5 6 7 8 9

9 5
1 2 3 4 5 6 7 8 9

5 4
6 5 4 3 2
'''
