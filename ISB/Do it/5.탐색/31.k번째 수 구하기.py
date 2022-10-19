'''
이분탐색개념으로 풀어야 한다는 것을 알고 풀어도 도저히 못풀겠다. 답을 봐도 이해가 가지않는다.
이 문제를 끝으로 이 문제집을 잠시 제껴두려 한다... 문제설명도 별로일뿐더러 문제난이도가 말이안된다고 느껴진다. 물론 코린이 기준이다.
화가 너무 나서 진행을 못하겠어.. 아무튼 내 실력에 비해 이 문제집은 너무 어려운것 같다.

문제풀이는 아래 포스팅을 보고 그나마 이해할 수 있었다. 문제집보다 훨씬더 설명이 잘 되어있다.
https://st-lab.tistory.com/281
'''
import sys
input = sys.stdin.readline

n = int(input())
k = int(input())

# 2차원 배열에서 x보다 작거나 같은수
def solution(x):
    res = 0

    for i in range(1, n+1):
        res += min(x//i, n)

    return res

start = 1
end = k
while(start < end):
    mid = (start+end) // 2
    res = solution(mid)

    if k <= res:
        end = mid
        print(start, end, mid)
    else :
        print(start, end, mid)
        start = mid+1



'''
3
7
'''