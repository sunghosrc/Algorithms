def solution(x):
    sum = calcSum( x )
    print( sum )
    return x % sum == 0

def calcSum( x ):
    n = 0
    while x > 0:
        n += (x % 10)
        x = x // 10
    return n
