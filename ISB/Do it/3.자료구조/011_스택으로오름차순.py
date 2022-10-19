'''
일단 교재의 문제설명은 상당히 문제가 있어보인다... 이딴 설명으로는 절대로 풀 수 없다!!
백준의 문제설명을 보고 이해했다.
이 N은 1~10만이므로, O(nlogn)안에 문제를 풀어야 시간초과가 나지않는다.
문제에 스택을 이용하라고 알려줬기 때문에 스택자료구조를 이용한다.

나의 문제풀이는 아래와 같다.
arr[i] : 입력받은 수열의 i번째 숫자
stk : 스택
asc_num : 스택에 오름차순으로 push하는 1~N까지의 숫자 (1씩 증가한다)

1. asc_num이 arr[i]이 될 때까지 스택에 asc_num을 push 그리고 asc_num++ 반복
2-1. 스택의 top == arr[i]인 경우 -> 스택 pop 그리고 i++
2-2. 만약  top == arr[i]이 아닌 경우 -> 불가능 'NO'출력
3. 위 작업 i < n 까지 반복

Q. 아래 코드의 시간복잡도 계산법 -> https://nulls.co.kr/codeit/341 참고!
for i in range(n):
    while asc_num <= arr[i]:
        ~~~
'''
n = int(input())
arr = [] # 수열
for _ in range(n):
    arr.append(int(input()))

stk = []
answer = []
asc_num = 1 # 1~N까지 1씩 증가하는 오름차순 숫자

for i in range(n):
    while asc_num <= arr[i]:
        stk.append(asc_num)
        answer.append('+')
        asc_num += 1

    if stk[-1] == arr[i]:
        stk.pop()
        answer.append('-')
        i += 1
    else :
        print('NO')
        exit()

for i in answer:
    print(i)

'''
8
4
3
6
8
7
5
2
1

5
1
2
5
3
4
'''