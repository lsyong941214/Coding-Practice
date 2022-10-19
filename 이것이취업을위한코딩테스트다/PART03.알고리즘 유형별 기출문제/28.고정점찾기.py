'''
오랜만에 쉬운문제를 풀어서 10분만에 완벽하게 풀었다.
다만, 문제해석에서 애매한 부분이 있었는데, 고정점이 배열에서 두개이상일 수는 없는지 여부였다. 1개이하로만 나올 수 있다고 가정하고 풀었고, 해설역시 그랬다.
이 문제를 보고 어떻게 그렇게 해석이 되는지는 아직도 잘모르겠다.

문제 핵심은 O(logN)으로 고정점을 찾아야 한다는 점인데, 오름차순으로 정렬이 되어있기 때문에 이진탐색을 사용하여 쉽게 풀었다.
일반이진탐색처럼 가운데 인덱스의 값을 확인하고 조건에 따라 왼쪽을 선택할지 오른쪽을 선택할지 결정했다.
여기서 조건은 원소와 인덱스의 크기비교이고, 왼쪽 선택 시 right에 mid-1, 반대 시 left에 mid+1을 넣어 재귀함수로 풀었다.
'''
n = int(input())
arr = list(map(int, input().split()))

def binary(left, right):
    if left > right:
        return -1
    mid = (left + right) // 2

    if arr[mid] == mid:
        return mid
    elif arr[mid] > mid:
        return binary(left, mid-1)
    else:
        return binary(mid+1, right) 

print( binary(0, len(arr)))
    
'''
5
-15 -6 1 3 7

7
-15 -4 2 8 9 13 15

7
-15 -4 3 8 9 13 15
'''