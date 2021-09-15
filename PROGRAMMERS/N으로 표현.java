import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Map<Integer, Set<Integer>> setMap = new HashMap<>();
        if( number == N )
            return 1;
        
        setMap.put( 1, new HashSet<>() );
        setMap.get( 1 ).add( repeatingNnumber( N, 1 ) );
        
        for( int i = 2; i < 9; i++ )
        {
            Set<Integer> temp = new HashSet<>();
            temp.add( repeatingNnumber( N, i ) );
            for( int j = 1; j < i; j++ )
            {
                for( int x : setMap.get( j ) )
                {
                    for( int y : setMap.get( i - j ) )
                    {
                        temp.add( x - y );
                        temp.add( x + y );
                        if( y != 0)
                            temp.add( x / y );
                        temp.add( x * y );
                    }
                }
            }
            if( temp.contains( number ) )
                return i;
            
            setMap.put( i, temp );
            
        }
        
        return -1;
    }
    
    private int repeatingNnumber( int n, int i )
    {
        StringBuilder sb = new StringBuilder();
        for( int k = 0; k < i; k++ )
            sb.append( n );
        
        return Integer.parseInt( sb.toString() );
    }
}
