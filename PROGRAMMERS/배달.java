import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[][] distance = new int[N+1][N+1];
        for( int i = 0; i < road.length; i++ ){
            int n1 = road[i][0];
            int n2 = road[i][1];
            int d = road[i][2];
            
            if( !map.containsKey( n1 ) )
                map.put( n1, new HashSet<>());
            
            if( !map.containsKey( n2 ) )
                map.put( n2, new HashSet<>());
            
            map.get(n1).add(n2);           
            map.get(n2).add(n1);   
            distance[n1][n2] = distance[n1][n2] != 0 ? Math.min(distance[n1][n2],d) : d;
            distance[n2][n1] = distance[n1][n2] != 0 ? Math.min(distance[n1][n2],d) : d;
        }
        Set<Integer> start = map.get(1);
        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        int[] minroute = new int[N+1];
        for( int s : start ){
            travel(visited,s,minroute,map, distance, distance[1][s] );
        }
        
        for( int i = 1; i < N+1; i++ )
            if( minroute[i] <= K )
                answer++;
            
        return answer;
    }
    
    private void travel( boolean[] visited, int n, int[] minroute, Map<Integer, Set<Integer>> map, int[][] distance, int totalD ){
        if( visited[n] )
            return;
        
        if( minroute[n] == 0 )
            minroute[n] = totalD;
        else
            if(minroute[n] < totalD)
                return;
            else
                minroute[n] = totalD;
        
        visited[n] = true;
        
        for( int s : map.get(n) )
            travel(visited,s,minroute,map,distance,totalD+distance[n][s]);
        
        visited[n] = false;
        
    }
}
