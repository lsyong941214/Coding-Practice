'''
1번 풀이 : 0 또는 1의 수가 포함된 경우는 +연산을 하고, 그 외 나머지 수는 *연산을 한다.
2번 풀이 : +연산, *연산 각각 구한 후 max()를 이용하여 두 수중 큰값을 선택해서 연산을 진행한다.
'''

arr = list(input())

for i in range(len(arr) - 1):
    first = int(arr[i]) * int(arr[i+1])
    second = int(arr[i]) + int(arr[i+1])

    arr[i+1] = max(first, second)

print(arr[-1])

'''
02984
567
'''