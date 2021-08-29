import java.util.*;
class Solution {
    public long solution(long n, int[] times) {
        Arrays.sort( times );
        
        long max    = times[ times.length - 1 ] * n; 
            // ( n / times.length );
        long start  = 1;
        long end    = max;
        long mid    = 0;
        long cnt    = calculateCount( times, max );
        long answer = 0;
        
        if( cnt == n )
            return max;
        
        while( start <= end )
        {
            mid         = ( end + start ) / 2;
            cnt         = calculateCount( times, mid );
            if( cnt >= n )
            {
                end = mid - 1;
                answer = mid;
            }
            else
            {
                start = mid + 1;
            }
        }
//         while( start <= end )
//         {
//             mid         = ( end + start ) / 2;
//             cnt         = calculateCount( times, mid );
//             int side    = calculateSide( cnt, n, times );
            
//             if( side == 0 )
//                 return calculateAns( mid, times );
//             else if( side == -1 )
//                 end     = mid;
//             else
//                 start   = mid + 1;
//         }
        
        
        return answer;
    }
    
    private long calculateAns( long mid, int[] times )
    {
        int minRmd      = times[ times.length - 1 ];

        for( int time : times )
        {
            int rmd = (int) ( mid % (long) time );
            if( rmd == 0 )
                return mid;
            else
            {
                if( minRmd > rmd )
                    minRmd  = rmd;
            }
        }
        
        return mid - minRmd;
    }
    
    private int calculateSide( long count, long n, int[] times )
    {
        long target = n;
        
        if( target == count )
            return 0;
        else if( target < count ) //our value is too big -> move to left
        {
            if( count - times.length + 1 > target )
                return -1;
            
            int divisible = 0;
            for( long time : times )
            {
                if( count % time == 0 )
                    divisible++;
            }
            
            if( divisible > 1 )
                if( count - ( divisible - 1 ) <= target )
                    return 0;
                else
                    return -1;
            else
                return -1;
        }
        else //our value is too small -> move to right
            return 1;
    }
    
    private long calculateCount( int[] times, long num )
    {
        long count = 0;
        for( long time : times )
        {
            count += num / time;
        }
        return count;
    }
}
