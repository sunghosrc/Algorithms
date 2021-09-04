import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        if( progresses == null || progresses.length == 0 )
            return null;
        
        List< Integer > deploys = new ArrayList<>();
        int             currMax = calculateWorkingDays( progresses[ 0 ], speeds[ 0 ] );
        int             nDeploy = 1;
        
        for( int i = 1; i < progresses.length; i++ )
        {
            int progress    = progresses[ i ];
            int speed       = speeds[ i ];
            int days        = calculateWorkingDays( progress, speed );
            
            if( days > currMax )
            {
                deploys.add( nDeploy );
                currMax = days;
                nDeploy = 1;
            }
            else
            {
                nDeploy++;
            }
        }
        deploys.add( nDeploy );
        
        int     size    = deploys.size();
        int[]   res     = new int[ size ];
        for( int i = 0; i < size; i++ )
        {
            res[ i ] = deploys.get( i );
        }
        return res;
    }
    
    private int calculateWorkingDays( int p, int s )
    {
        
        return ( 100 - p ) % s == 0 ? ( 100 - p ) / s : ( 100 - p ) / s + 1;
    }
}
