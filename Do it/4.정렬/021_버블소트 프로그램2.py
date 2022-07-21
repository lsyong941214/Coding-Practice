'''
N의 크기는 50만
O(nlogn)안에 스왑의 횟수를 구해야 한다.
머지소트관련문제라 나도 모르게 머지소트를 이용해서 풀이해야겠다는 생각을 하게되었다. 실전에서는 이생각을 하느냐 하지못하느냐가 관건일텐데 역시나 실전에서는 불가능할 것 같다..
머지소트로 구현하려고 했으나, 인덱스가 이동한 거리를 구하는동작에서 시간초과 없이 구하는 방법이 떠오르지 않았다.

해답을 보니, 인덱스이동거리 구하는 식은 생각보다 아주아주 간단했다.
각 반복문에서 인덱스 이동거리 = 왼쪽배열길이 - 왼쪽배열의 현재 인덱스

[솔루션 포인트]
    1 : 데이터의 범위를 보고 O(nlogn)인 머지소트를 떠올리는 것.
    2 : 이동거리를 구하는 방식
'''

import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
answer = 0

def DNC(arr):
    if len(arr) == 1:
        return arr
    else :
        A = arr[:len(arr)//2]
        B = arr[len(arr)//2:]
        return conquer(DNC(A), DNC(B))

def conquer(A, B):
    global answer
    idx = 0
    idx2 = 0
    C = []

    while True:
        if A[idx] <= B[idx2]:
            C.append(A[idx])
            idx += 1
        else :
            C.append(B[idx2])
            answer += (len(A) - idx) # 이 문제의 킥
            idx2 += 1

        if idx >= len(A):
            for i in B[idx2:len(B)]:
                C.append(i)
            break
        if idx2 >= len(B):
            for i in A[idx:len(A)]:
                C.append(i)
            break
    return C
    
DNC(arr)
print(answer)


'''
8
3 2 8 1 7 4 5 6
==
11
'''