'''
# 1단계 문제분석하기
문제의 시간제한이 0.5초, 파이썬의 초당 연산횟수 2천만번이므로 천만번연산안에 답을 구해야 한다.
합배열을 사용하지 않는 최악의 연산횟수는 1억번이므로 시간이 초과된다.
합배열과 구간합을 이용하여 10만번연산으로 답을 구한다.

# 2단계 손으로 풀어보기
1. 합배열을 만든다.
2. 테스트케이스 루프에서 합배열을 이용하여 구간합을 구한다.

# 3단계 슈도코드 작성
for i 0~n:
    합배열.append(합배열[i] + 숫자배열[i])

for tc
    i, j 입력받기
    i~j구간합 = 합배열[j] - 합배열[i-1]
'''
# 4단계 코드구현
n, tc = map(int, input().split())
arr = list(map(int, input().split()))
sum = [0]
for i in range(len(arr)):
    sum.append(sum[i] + arr[i])

answer = []
for _ in range(tc):
    i, j = map(int, input().split())
    answer.append(sum[j] - sum[i-1])
print(answer)

'''
입출력
5 3
5 4 3 2 1
1 3
2 4
5 5

[12, 9, 1]

메모
합배열 개념 지금까지 
StringTokenizer클래스
'''