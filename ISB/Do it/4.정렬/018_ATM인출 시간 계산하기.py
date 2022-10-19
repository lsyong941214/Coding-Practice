'''
최소값을 만들기위해 아래의 연산 수행
1. 걸리는시간이 적은순 정렬을 한다.
2. i번째 걸리는 시간 * j명

정렬은 insert sort로 구현했다.
'''
import sys
input = sys.stdin.readline

def insert_sort(arr):
    for i in range(1, len(arr)):
        for j in range(i, 0, -1):
            if arr[j] < arr[j-1]:
                arr[j], arr[j-1] = arr[j-1], arr[j]
            else:
                break
    return arr
n = int(input())
arr = list(map(int, input().split()))
sort_arr = insert_sort(arr)

j = n
answer = 0

for i in sort_arr:
    answer += i*j
    j -= 1
print(answer)

'''
5
3 1 4 3 2
'''