import java.util.*;

class Solution {
    public String solution(String p) {
        StringBuilder sb = new StringBuilder();
        int l = 0;
        int r = 0;
        boolean needsToBeFixed = false;
        char[] chars = p.toCharArray();
        if( chars.length == 0 )
            return "";
        
        for( int i = 0; i < chars.length; i++ )
        {
            if( chars[i] == '(' )
                l++;
            else
                r++;
            
            if( r > l )
                needsToBeFixed = true;
            
            if( l > 0 && r > 0 && l == r )
                if(needsToBeFixed)
                    return sb.append("(").append(solution(p.substring(i+1)))
                    .append(")").append(flip(p.substring(0,i+1))).toString(); 
                else
                    return sb.append(p.substring(0,i+1))
                        .append(solution(p.substring(i+1))).toString(); 
        }
        
        return sb.toString();
    }
    
    private String flip( String s )
    {
        if( s.length() < 2 )
            return "";
        StringBuilder sb = new StringBuilder();
        for( int i = 1; i < s.length()-1; i++ )
        {
            if( s.charAt(i) == ')' )
                sb.append('(');
            else
                sb.append(')');
                
        }
        // System.out.println("flipped: " + sb.toString());
        
        return sb.toString();
        
        
    }
    
}
