import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String,String>  map     = new HashMap<>();
        List<String[]>        list    = new ArrayList<>();
        StringBuilder       sb      = new StringBuilder();
        int                 size    = 0;
        
        for( String log : record )
        {
            String[] parse = log.split( " " );
            if( parse[ 0 ].equalsIgnoreCase( "Enter" ) 
               || parse[ 0 ].equalsIgnoreCase( "Change" ) )
            {
                map.put( parse[ 1 ], parse[ 2 ] );
                if( parse[ 0 ].equalsIgnoreCase( "Enter" ) )
                {
                    String[] msg = { parse[1], "님이 들어왔습니다." };
                    list.add( msg );
                    size++;
                }
            }
            else if( parse[ 0 ].equalsIgnoreCase( "Leave" ) )
            {
                String[] msg = { parse[1], "님이 나갔습니다." };
                list.add( msg );
                size++;
            }
            else
                continue;
        }
        
        String[] answer = new String[ size ];
        
        for( int i = 0; i < size; i++ )
        {
            String[] msg = list.get( i );
            String union = new StringBuilder().append(
                            map.get( msg[0] ) ).append( msg[ 1 ] ).toString();
            answer[ i ]  = union;
        }
        
        return answer;
    }
}
