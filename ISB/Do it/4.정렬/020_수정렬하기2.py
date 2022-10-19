'''
문제설명과 풀이는 기초 정렬문제 이므로 패스하고, mergesort구현에 초점을 두겠다.
머지소트를 구현하기 위해 재귀함수를 이용하였고, divide함수와 conquer함수를 각각 만들었다.
먼저, 배열을 길이가 1이 될 때 까지 절반으로 나눈뒤 -> 나눈 절반 한 쌍을 다시 정렬하면서 합쳤다.
구현해놓고 보면 많이 간단해 보이는데,, 구현하는데까지 상당히 많은시간이 소요되었다..
특히, 재귀함수 동작을 이용하는 부분과 conquer의 반복문을 구현하는데 애를 먹었다.
'''
import sys
input = sys.stdin.readline
n = int(input())
arr = []

for _ in range(n):
    arr.append(int(input()))

def mergeSort(arr):
    if len(arr) == 1:
        return arr
    else :
        A, B = divide(arr)
        return conquer(mergeSort(A), mergeSort(B))

def divide(arr):
    A = arr[:len(arr)//2]
    B = arr[len(arr)//2:]
    return A, B

def conquer(A, B):
    idx = 0
    idx2 = 0
    C = []

    while True:
        if A[idx] < B[idx2]:
            C.append(A[idx])
            idx += 1
        else :
            C.append(B[idx2])
            idx2 += 1

        # 만약 A를 전부 방문했다면 -> B의 현재인덱스부터~마지막을 C에 삽입한다.
        if idx >= len(A):
            for i in B[idx2:len(B)]:
                C.append(i)
            break
        # 만약 B를 전부 방문했다면 -> A의 현재인덱스~마지막을 C에 삽입한다.
        if idx2 >= len(B):
            for i in A[idx:len(A)]:
                C.append(i)
            break
    return C
    
answer = mergeSort(arr)

for i in answer:
    print(i)

'''
5
5
4
3
2
1
'''