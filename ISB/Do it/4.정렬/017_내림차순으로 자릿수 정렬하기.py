'''
select sort구현
시간복잡도 : O(N^2)

첫번째 loop i는 1~N까지
    두번째 loop j는 i+1부터 N까지
        1. 최대값의 인덱스를 찾는다.
    2. i번째 값과 최대값인덱스의 값을 스왑한다.

'''

n = list(input())
arr = []
for ch in n:
    arr.append(int(ch))

for i in range(len(arr)):
    max_idx = i

    for j in range(i+1, len(arr)):
        if arr[j] > arr[max_idx]:
            max_idx = j
    
    arr[i], arr[max_idx] = arr[max_idx], arr[i]

for i in arr:
    print(i, end='')