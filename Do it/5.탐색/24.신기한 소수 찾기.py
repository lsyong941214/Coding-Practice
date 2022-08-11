'''
혼자서는 풀지 못해서 교재를 보고 힌틀를 얻어서 풀었다.

내가 생각하지 못한 3가지 때문에 정답을 구하지 못했었다.
1. dfs설계 (depth에 들어갈수록 자릿수가 증가하도록 설계)
2. 소수 판별 함수에서 n/2까지만 체크하는 것 -> 연산횟수가 반으로 줄어듦
3. 현재 방문한 수가 짝수인 경우 넘어가는 로직 -> 연산횟수가 반으로 줄어듦

'''
import sys
input =sys.stdin.readline

n = int(input())
answer = []

# n의 소수여부를 반환
def isPrime(n):
    for i in range(2, n//2): # n//2까지만 계산해도 소수인지 판별 가능
        if n%i == 0:
            return False
    return True

def dfs(num):
    if num//10**(n-1)>1 and num//10**(n-1) < 10: #  num의 자릿수가 n인 경우 출력
        print(num)
        return

    for i in range(10):
        if i%2 == 0: # 짝수인 경우는 skip
            continue

        a = int(str(num) + str(i))

        if isPrime(a):
            dfs(a) # 방문한 숫자가 소수인 경우 -> dfs 수행

dfs(2)
dfs(3)
dfs(5)
dfs(7)