n = int(input())
scores = list(map(int, input().split()))
sum = 0

max = max(scores)
for score in scores:
    sum += score/max * 100
avg = sum/len(scores)

print(avg)

'''
입출력
3
40 80 60
75.0

4
1 100 100 100
75.25

5
1 2 4 8 16
38.75
'''