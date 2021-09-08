def solution(a, b):
    month   = [ 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 ]
    day     = [ 'SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT' ]
    days    = sum( month[:a] ) + b
    offset  = 4
    
    return day[ ( days + offset ) % 7 ]
