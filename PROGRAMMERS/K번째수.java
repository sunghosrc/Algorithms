import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[]   answer  = new int[ commands.length ];
        int     idx     = 0;
        
        for( int[] command : commands )
        {
            int i = command[ 0 ] - 1;
            int j = command[ 1 ] - 1;
            int k = command[ 2 ];
            
            int[] arr       = Arrays.copyOfRange( array, i, j + 1 );
            Arrays.sort( arr );
            answer[ idx++ ] = arr[ k - 1 ];    
        }
        return answer;
    }
}
