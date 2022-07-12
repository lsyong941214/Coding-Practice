'''
이 문제는 3중for문이기 때문에 단순for문 연산으로는 시간초과가 발생한다. -> 투 포인터 알고리즘을 활용해야 한다.
그러나 나는 처음에 문제를 잘못 해석해서, 집합자료형으로 간단히 풀이가 가능한 줄 알았다.
중복이라는 어떠한 단어도 없었음에도 단순히 '다른 두 수의'라는 워딩만 보고 input값 자체가 중복없이 들어오는 것으로 해석하여
집합을 이용하였고 오답을 받았다.

결국 교재에서 다루는 투 포인터를 이용하여 풀이를 시도했지만 실패했다. 어떤 알고리즘을 써야하는지 알고있었는데도 못풀어서 충격이었다.
일단 N의 갯수만큼 반복문을 돌린다.
반복문안에서 하나의 투 포인터 반복문을 이용하여 두 수의 합을 구하고, 이 합이 A[i]와 같다면 A[i]는 '좋은수'이다.

[참고]
입력숫자의 범위가 10억이길래 파이썬의 int 범위를 확인해봤으나 무제한이었다.
자바의 int 범위 : -2,147,483,648 ~ 2,147,483,647
파이썬의 int 범위 : 무제한

파이썬 set자료형, dict자료형의 탐색 시간복잡도 : O(1) -> 해시테이블을 이용하기 때문에
교집합, 차집합, 합집합의 시간복잡도 : O(len(setA) + len(setB))

'다른 두 수의 합'
A = [0 0 1 1] -> A[0]과 A[1]은 0으로 같은 수 이지만, 이 문제에선 다른 두 수로 여긴다.
'''

n = int(input())
arr = list(map(int, input().split()))
arr.sort()
answer = 0

for k in range(len(arr)):
    target = arr[k ]
    start = 0
    end = len(arr) - 1

    while start < end:
        sum = arr[start] + arr[end]

        if target > sum:
            start += 1
        elif target < sum:
            end -= 1
        else:
            if k!= start and k != end:
                answer += 1
                break # k로 만들 수 있는 방법의 수가 아니라, k의 개수 자체를 구해야 하므로 여기서 반복문 종료
            elif k == start:
                start += 1
            elif k == end:
                end -= 1
    
print(answer)

'''
tc1 -> 8
10
1 2 3 4 5 6 7 8 9 10

tc2
4
0 0 1 1
'''