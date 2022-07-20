'''
N의 크기가 5백만이므로, nlogn안에 정렬을 해야하는 문제이다.
파이썬 디폴트 sort함수를 이용해도 풀 수 있지만, 교재대로 퀵소트 함수를 직접 구현하여 문제를 풀었다.

'''
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

# 퀵소트 구현
def QuickSort(arr, start, end):
    pivot = start
    left, right = start + 1, end

    if start >= end: return
    while left <= right:
        while arr[pivot] > arr[left] and left <= end:
            left += 1
        while arr[pivot] < arr[right] and right > start:
            right -= 1
        if left > right:
            arr[right], arr[pivot] = arr[pivot], arr[right]
        else :
            arr[right], arr[left] = arr[left], arr[right]
    QuickSort(arr, start, right-1)
    QuickSort(arr, right+1, end)

# 파이썬의 장점을 이용한 간단한 퀵 소트
def QuickSortPy(arr):
    if len(arr) <= 1:
        return arr
    pivot, sub = arr[0], arr[1:]
    left_side = [i for i in sub if i < pivot]
    right_side = [i for i in sub if i > pivot]

    return QuickSortPy(left_side) + [pivot] + QuickSortPy(right_side)

arr = QuickSortPy(arr)
print(arr)
print(arr[m-1])

'''
5 2
4 1 2 3 5
'''
