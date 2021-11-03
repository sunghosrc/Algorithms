import java.util.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int count = 0;
        boolean[] visited = new boolean[ n + 1 ];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        
        while ( scanner.hasNextLine() )
        {
            String s = scanner.nextLine();
            String[] edges = s.split(" ");
            try{
                int from = Integer.parseInt(edges[0]);
                int to = Integer.parseInt(edges[1]);
                if( from == to )
                    continue;
    
                if( !map.containsKey(from) )
                    map.put(from, new HashSet<>());
                if( !map.containsKey(to) )
                    map.put(to, new HashSet<>());
                map.get(from).add(to);
                map.get(to).add(from);
            }catch(Exception e){
                continue;
            }
        }
        
        visited[1] = true;
        
        queue.offer(1);
        
        while( !queue.isEmpty() )
        {
            Set<Integer> nodes = map.get( queue.poll() );
            if(nodes == null)
                continue;
            for( int node : nodes )
                if(!visited[node])
                {
                    visited[node] = true;
                    queue.offer(node);
                    count++;
                }
        }
        
        System.out.println( count );
    }

}
