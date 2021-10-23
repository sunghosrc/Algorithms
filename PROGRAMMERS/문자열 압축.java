class Solution {
    public int solution(String s) {
        if( s.length() < 2 )
            return s.length();
        int min = s.length() * 2;
        for( int i = 1; i <= s.length()/2; i++ )
            min = Math.min( getCompactedLength(s, i), min );
        
        return min;
    }
    
    private int getCompactedLength( String s, int n )
    {
        int iterate = s.length() - n;
        int length = s.length();
        int count = 1;
        
        String prev = "";
        for( int i = 0; i < s.length(); i+= n )
        {
            if( i+n > s.length() )
                break;
            String curr = s.substring(i, i+n);
            if( curr.equals( prev ) )
            {
                count++;
                length-=n;
                
            } else {
                if( count > 1 ) {
                    while( count != 0 )
                    {
                        length++;
                        count = count/10;
                    }
                    count = 1;
                }
                prev = curr;
            }
            
        }

        if( count > 1 ) {
            while( count != 0 )
            {
                length++;
                count = count/10;
            }
        }
        
        return length;
    }
}
