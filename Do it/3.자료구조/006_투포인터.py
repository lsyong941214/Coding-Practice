import sys
input = sys.stdin.readline

n  = int(input())

sum = 1
count = 1
start_index = 1
end_index = 1

while end_index < n:
    if sum < n:
        end_index += 1
        sum += end_index
    elif sum > n:
        sum -= start_index
        start_index += 1
    else :
        end_index += 1
        sum += end_index
        count += 1

print(count)

'''
[1단계]
n의 범위가 천만이므로, O(n)의 시간복잡도로 정답을 구해야한다.
투 포인터를 이용하면 하나의 반복문으로 답을 구할 수 있다.

[2단계]

'''