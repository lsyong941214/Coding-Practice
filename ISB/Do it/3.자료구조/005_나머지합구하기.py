n, m = map(int, input().split())
arr = list(map(int, input().split()))
answer = 0

for i in range(1, n+1):
    for j in range(n-i+1):
        num = sum(arr[j:j+i]) 
        if num % m == 0:
            answer += 1

print(answer)

'''
입출력
5 3
1 2 3 1 2

1단계
교재에 n=106 오타를 보고, 부르트포스로 푸는 것이 가능하여 부르트포스로 진행 -> 시간초과
실제로는 n=1,000,000 이므로 부분합을 이용하여 풀어야 시간제한안에 연산이 가능하다
수학적 개념이 들어가기 때문에 일단 스킵..

'''