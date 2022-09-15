# if target in numbers 를 이용하면 시간초과
# binary search를 사용해야한다.
import sys
input = sys.stdin.readline

n = int(input())
numbers = list(map(int, input().split()))

m = int(input())
targets = list(map(int, input().split()))

def binary_search(arr, target):
    if len(arr) < 1:
        return None

    mid = len(arr) // 2

    if arr[mid] == target:
        return True
    elif arr[mid] > target:
        return binary_search(arr[:mid-1], target)
    else :
        return binary_search(arr[mid+1:], target)

def binary_search_2(arr, target, start, end):
    if start > end:
        return None
    
    mid = (start+end) // 2

    if arr[mid] == target:
        return True
    elif arr[mid] > target:
        return binary_search_2(arr, target, start, mid-1)
    else:
        return binary_search_2(arr, target, mid+1, end)
    

numbers.sort()

for target in targets:
    # if binary_search_2(numbers, target, 0, len(numbers)-1):
    if binary_search(numbers, target):
        print(1)
    else:
        print(0)

'''
5
4 1 5 2 3
5
1 3 7 9 5
'''