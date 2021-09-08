import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for( String name : participant )
        {
            map.put( name, map.getOrDefault( name, 0 ) + 1 );
        }
        for( String name : completion )
        {
            int count = map.get( name );
            if( count - 1 != 0 )
                map.put( name, count - 1 );
            else
                map.remove( name );
        }
        
        for( String name : map.keySet() )
            answer = name;
        
        return answer;
    }
}
