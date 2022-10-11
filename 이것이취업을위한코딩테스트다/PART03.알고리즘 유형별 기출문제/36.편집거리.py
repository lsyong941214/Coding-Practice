'''
cat
cut
1

sunday
saturday
3

MICROSOFT
NCSOFT
4

이 문제는 edit distance(편집거리)라는 개념을 모르면 풀기 어려운 문제이다.
정답을 보지않고 충분히 고민한다음 해설을 봤는데, 아무리 고민을 했어도 못풀었을 문제였다. 또한 해설을 보고도 잘 이해가 되지않아 다른사람의 해설을 많이 참고했다.
[참고한 해설]
https://hsp1116.tistory.com/41
https://www.youtube.com/watch?v=XYi2-LPrwm4

다이나믹 프로그래밍에서 등장하는 대표유형이므로 문제를 이해하고 외워버리자(못풀었다고 실망하지말고).
str1 -> str2로 3가지 연산을 이용하여 변환하는 문제이다.

edit distance유형의 두가지 핵심포인트
1. 2차원 DP테이블을 생성한다. 테이블의 세로값은 str1의 원소, 가로값은 str2의 원소로 만든다.
테이블에는 str1->str2를 만드는 최소 연산의 수가 들어간다.
2. dp[i][j]의 값은 이전문자비교연산 +1의 목록(3가지연산)중에 가장 작은값을 대입한다.
    2-0. 현재 인덱스의 str1과 str2값이 같은경우: dp[i][j] = dp[i-1][j-1]
    2-1. 삽입연산 경우 dp[i][j] = dp[i-1][j] + 1(삽입연산 카운트)   (현재위치기준 왼쪽으로 1칸)
    2-2. 삭제연산 경우 dp[i][j] = dp[i][j-1] + 1(삭제연산 카운트)   (현재위치기준 위쪽으로 1칸)
    2-3. 대체연산 경우 dp[i][j] = dp[i-1][j-1] + 1(대체연산 카운트) (현재위치기준 왼쪽위 대각선으로 1칸)
'''

import sys
input = sys.stdin.readline
INF = int(1e9)
str1 = input().strip()
str2 = input().strip()

# 2차원 dp테이블 선언
dp = [[0 for _ in range(len(str2)+1)] for _ in range(len(str1)+1)]
# dp = [[0]*(m+1) for _ in range(n+1)] 다른방식의 선언

# dp테이블 초기값 세팅
for i in range(1, len(str1)+1):
    # 1열의 값은 str1의 원소리스트
    dp[i][0] = i

for j in range(1, len(str2)+1):
    # 1행의 값은 str2의 원소리스트
    dp[0][j] = j

# edit_distance 다이나믹 프로그래밍
def edit_distance(str1, str2):
    for i in range(1, len(str1)+1):
        for j in range(1, len(str2)+1):

            if str1[i-1] != str2[j-1]:
                dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1
            else:
                dp[i][j] = dp[i-1][j-1]
    return dp[len(str1)][len(str2)]

print( edit_distance(str1, str2) )