class Solution {
    public int[] solution(int[] answers) {
        int[] pattern1  = { 1, 2, 3, 4, 5 };
        int[] pattern2  = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] pattern3  = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        int[] scores    = new int[ 3 ];
        
        for( int i = 0; i < answers.length; i++ )
        {
            int answer = answers[ i ];
            if( answer == pattern1[ i % pattern1.length ] )
                scores[ 0 ]++;
            if( answer == pattern2[ i % pattern2.length ] )
                scores[ 1 ]++;
            if( answer == pattern3[ i % pattern3.length ] )
                scores[ 2 ]++;
        }
        
        if( scores[ 0 ] > scores[ 1 ] && scores[ 0 ] > scores[ 2 ] )
            return new int[]{ 1 };
        else if( scores[ 1 ] > scores[ 0 ] && scores[ 1 ] > scores [ 2 ] )
            return new int[]{ 2 };
        else if( scores[ 2 ] > scores[ 0 ] && scores[ 2 ] > scores[ 1 ] )
            return new int[]{ 3 };
        else if( scores[ 0 ] == scores[ 1 ] && scores[ 0 ] > scores[ 2 ] )
            return new int[]{ 1, 2 };
        else if( scores[ 1 ] == scores[ 2 ] && scores[ 1 ] > scores[ 0 ] )
            return new int[]{ 2, 3 };
        else if( scores[ 2 ] == scores[ 0 ] && scores[ 2 ] > scores[ 1 ] )
            return new int[]{ 1, 3 };
        else
            return new int[]{ 1, 2, 3 };
    }
}
