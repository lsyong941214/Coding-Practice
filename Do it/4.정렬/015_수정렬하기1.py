'''
버블소트 구현문제
풀이나 설명은 생략
'''
n = int(input())
arr = []
for _ in range(n):
    arr.append(int(input()))

def bubble_sort(arr):
    n = len(arr)
    for i in range(n-1):
        for j in range(1, n-i):
            if arr[j-1] > arr[j]:
                arr[j-1], arr[j] = arr[j], arr[j-1] # 파이썬 swap구문
    
    for i in arr:
        print(i)

bubble_sort(arr)

'''
5
4
1
5
2
3

'''