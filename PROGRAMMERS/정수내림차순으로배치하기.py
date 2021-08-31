def solution(n):
    sorted = [ x for x in str(n) ]
    sorted.sort()
    res = ""
    for i in range( len(sorted) - 1, 0 - 1, -1 ):
        res += sorted[i]
        
    return int(res)
