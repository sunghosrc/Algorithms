import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityMap map     = new PriorityMap();
        
        for( String operation : operations )
        {
            if( operation.startsWith( "I" ) )
            {
                int n = Integer.parseInt( operation.substring( 2 ) );
                map.add( n );
            }
            else if( operation.startsWith( "D" ) )
            {
                if( operation.equals( "D 1" ) )
                {
                    map.removeMax();
                }
                else if( operation.equals( "D -1" ) )
                {
                    map.removeMin();
                }
                else
                    continue;
            }
            else
                continue;
        }
        return new int[]{ map.getMax(), map.getMin() };
    }
    
    public class PriorityMap{
        public Map<Integer, Integer> map;
        public Map<Integer, Integer> reverse;
        public int                   size;
        
        public PriorityMap(){
            map     = new TreeMap<>();
            reverse = new TreeMap<>( Collections.reverseOrder() );
            size    = 0;
        }
        
        public void add( int n ){
            map.put( n, map.getOrDefault( n, 0 ) + 1 );
            reverse.put( n, reverse.getOrDefault( n, 0 ) + 1 );
            size++;
        }
        
        public void removeMin(){
            for( int n : map.keySet() )
            {
                remove( n );
                break;
            }
        }
        
        public void removeMax(){
            for( int n : reverse.keySet() )
            {
                remove( n );
                break;
            }
        }
        
        public void remove( int n ){
            if( map.containsKey( n ) )
            {
                int count = map.get( n );
                if( count == 1 )
                {
                    map.remove( n );
                    reverse.remove( n );
                }
                else
                {
                    map.put( n, count - 1 );
                    reverse.put( n, count - 1);
                }
                size--;
            }
            else
                return;
        }
        
        public int getMin()
        {
            if( size > 0 )
            {
                for( int n : map.keySet() )
                {
                    remove( n );
                    return n;                    
                }
                return 0;
            }
            else
                return 0;
        }
        
        public int getMax()
        {
            if( size > 0 )
            {
                for( int n : reverse.keySet() )
                {
                    remove( n );
                    return n;                    
                }
                return 0;
            }
            else
                return 0;
        }
    }
}
