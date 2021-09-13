class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        char[]  chars   = s.toCharArray();
        int     last_sm = 'z' - 0;
        int     last_cp = 'Z' - 0;
        
        for( int i = 0; i < chars.length; i++ )
        {
            char c = chars[ i ];
            
            if( c == ' ' )
                 answer.append( ' ' );
            else if( c - 0 > last_cp )
                answer.append( (char) ( (c + n) > last_sm ? (c + n - 26) : (c + n) ) );
            else
                answer.append( (char) ( (c + n) > last_cp ? (c + n - 26) : (c + n) ) );
        }
        
        return answer.toString();
    }
}
