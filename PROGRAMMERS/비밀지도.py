def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        int_row = ( arr1[i] | arr2[i] )
        row     = bin( int_row )[2:].zfill(n)
        str_row = ''
        for s in row:
            str_row += ( ' ' if s == '0' else '#' )
        
        answer.append( str_row )
    return answer
