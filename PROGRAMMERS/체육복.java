import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[]   gymsuits    = new int[ n ];
        int     count       = 0;
        
        Arrays.fill( gymsuits, 1 );
        
        for( int g : lost )
            gymsuits[ g - 1 ]--;
        
        for( int g : reserve )
            gymsuits[ g - 1 ]++;
        
        for( int i = 0; i < n; i++)
        {
            if( gymsuits[ i ] == 0 )
            {
                if( i - 1 >= 0 && gymsuits[ i - 1 ] == 2 )
                {
                    gymsuits[ i - 1 ] = 1;
                    count++;
                }
                else if( i + 1 < n && gymsuits[ i + 1 ] == 2 )
                {
                    gymsuits[ i + 1 ] = 1;
                    count++;
                }
            }
            else
                count++;
        }
        return count;
    }
}
