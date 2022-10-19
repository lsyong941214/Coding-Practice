'''
0001100
11111
0000001
11001100110011000001
11101101

1번 풀이: 주어진 문자열을 반복되는 수를 하나로 압축한 뒤, 0카운트값과 1카운트값 중 작은 값을 출력
2번 풀이: 
'''

arr = list(input())
compress = []

prev = 0
for i in arr:
    cur = i

    if int(prev) != int(cur):
        compress.append(prev)
    prev = cur
compress.append(cur)

result = min(compress.count('0'), compress.count('1'))

print(result)