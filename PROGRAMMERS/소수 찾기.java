import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set< String >   set     = new HashSet<>();
        Set< Integer >  all     = new HashSet<>();
        int             answer  = 0;
        
        getAllCombinations( "", numbers, set );
        for( String s : set )
            getAllPermutations( s, "", all );
        
        for( int n : all )
            if( isPrime( n ) )
                answer++;
        
        return answer;
    }
    
    public boolean isPrime( int n )
    {
        // System.out.println( n );
        if( n == 0 || n == 1 )
            return false;
        
        int i = 2;
        while( i <= n / 2 )
        {
            if( n % i == 0 )
                return false;
            i++;
        }
        return true;
    }
    
    public void getAllPermutations( String str, String ans, Set< Integer > set )
    {
        if (str.length() == 0) 
        {
            set.add( Integer.parseInt( ans ) );
            return;
        }
  
        for (int i = 0; i < str.length(); i++) {
  
            char    ch  = str.charAt( i );
            String  ros = str.substring( 0, i ) + str.substring( i + 1 );
  
            getAllPermutations( ros, ans + ch, set );
        }
    }
    
    public void getAllCombinations( String prefix, String s, Set< String > set )
    {
        int N = s.length();

        if( prefix.length() > 0 )
            set.add( prefix );

        for (int i = 0 ; i < N ; i++)
          getAllCombinations( prefix + s.charAt( i ), s.substring( i + 1 ), set );
    }
}
