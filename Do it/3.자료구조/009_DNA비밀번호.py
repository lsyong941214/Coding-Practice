'''
첫번째 시도(solution1)는 브루트포스로 풀어봤는데 역시나 시간초과가 나왔다.
시간복잡도가 O(kn**2)으로 연산 횟수가 10억 번 이상이기 때문이다.

두번째 시도(solution)는 아래 두가지 방법을 사용하여 풀었다.
    1. 반복문을 최대한 병렬로 배치하는 방법으로 접근했다. (count함수를 초기셋팅에만 사용.)
    2. 현재 인덱스의 DNA 구성을 리스트에 저장하여, 반복문을 돌 때마다 리스트를 갱신하고 조건을 만족하는지 체크했다.
이렇게 풀면 시간복잡도는 O(k)로 예상된다. ( k는 s-p이다. (0~1,000,000) )
내 풀이방식이 이 책에서 소개한 슬라이딩 윈도우인지는 모르겠다...

[note]
- 파이썬의 리스트 슬라이싱 시간복잡도는 O(k)이다.
'''

# 입력값 받기
import sys
input = sys.stdin.readline

s, p = map(int, input().split())            
dna_list = input()                               
rule = list(map(int, input().split()))

# 첫 번째 풀이
def solution1():
    answer = 0
    def isSecure(password):
        # 리스트 카운트의 시간복잡도 : O(n)
        A = password.count('A') 
        C = password.count('C')
        G = password.count('G')
        T = password.count('T')

        if A >= rule[0] and C >= rule[1] and G >= rule[2] and T >= rule[3]:
            return True
        else :
            return False
    
    # 메인
    for i in range(0, s-p+1): # 시간복잡도 O(n)
        if isSecure(dna_list[i:i+p]): # isSecure()의 시간복잡도 : O(n), dna[i:j]의 시간복잡도 : O(k) [j-i=k]
            answer += 1
    return answer

# 두 번째 풀이
def solution2():
    answer = 0
    # DNA A,C,G,T 인덱스 저장
    A, C, G, T = 0, 1, 2, 3

    # 초기 값 세팅
    init_dna = dna_list[0:p]
    cur = [ init_dna.count('A')
        , init_dna.count('C')
        , init_dna.count('G')
        , init_dna.count('T')
    ]
    if cur[A] >= rule[A] and cur[C] >= rule[C] and cur[G] >= rule[G] and cur[T] >= rule[T]:
        answer += 1

    def exclude_left(dna):
        if dna == 'A':
            cur[A] -= 1
        elif dna == 'C':
            cur[C] -= 1
        elif dna == 'G':
            cur[G] -= 1
        elif dna == 'T':
            cur[T] -= 1

    def include_right(dna):
        if dna == 'A':
            cur[A] += 1
        elif dna == 'C':
            cur[C] += 1
        elif dna == 'G':
            cur[G] += 1
        elif dna == 'T':
            cur[T] += 1

    # 메인
    idx = 0
    while idx < s-p:
        exclude_left(dna_list[idx])
        include_right(dna_list[idx+p])
        idx += 1

        if cur[A] >= rule[A] and cur[C] >= rule[C] and cur[G] >= rule[G] and cur[T] >= rule[T]:
            answer += 1

    return answer

print("첫 번째 풀이[ O(kn^2) ] : ", solution1())
print("두 번째 풀이[ O(k)    ] : ", solution2())

'''
tc1
9 8
CCTGGATTG
2 0 1 1

tc2
4 2
GATA
1 0 0 1

tc3
9 3
CCTGGATTG
0 0 0 0
'''