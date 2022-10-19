'''
https://www.acmicpc.net/problem/14501
첫번째 시도 2시간동안 풀어봤지만, 풀지못했다.
정답을 보니, 한가지 아이디어를 생각하지못해서 풀지 못했는데, 뒤에서부터 다이나믹프로그래밍을 진행하는 것이었다.
dp[i]테이블을 i번째부터 n번째날까지의 최대이익으로 설정한 뒤, 마지막날부터 거꾸로 dp테이블을 계산한다.
이 거꾸로 계산해야겠다는 아이디어는 어디서 유추할 수 있을까를 고민해봤는데 점화식에서 답이 나왔다.
점화식은 다음과 같은데 dp[i] = max(p[i] + dp[i+t[i]], max_value) dp[i]의 값을 계산하기위해서는 dp[i+@]이 필요하다. 즉 i를구하기위해 i+@인덱스가 필요하기 때문에 뒤에서부터 계산한 것이다.
'''
# 입력받기
n = int(input())
dp = [0] * (n+2)
t = [0]
p = [0]
for _ in range(n):
    a, b = map(int, input().split())
    t.append(a)
    p.append(b)

max_value = 0
# 다이나믹 프로그래밍
for i in range(n, -1, -1):
    if t[i]+i > n+1:
        dp[i] = max_value
    else:
        dp[i] = max(p[i] + dp[t[i]+i], max_value)
        max_value = dp[i]

print(max_value)