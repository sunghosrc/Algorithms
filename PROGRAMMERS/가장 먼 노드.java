import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int level = 0;
        boolean[] visited = new boolean[n+1];
        int[] counts = new int[n+1];
        Map<Integer, Set<Node>> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        for( int i = 0; i < edge.length;i ++ ){
            int n1 = edge[i][0];
            int n2 = edge[i][1];
            if( !map.containsKey(n1) )
                map.put(n1, new HashSet<>());
            if( !map.containsKey(n2) )
                map.put(n2, new HashSet<>());
            map.get(n1).add( new Node(n2) );
            map.get(n2).add( new Node(n1) );
        }
        visited[1] = true;
        q.offer(new Node(1));
        while(!q.isEmpty()){
            Node curr = q.poll();
            Set<Node> s = map.get(curr.val);
            for( Node node : s ){
                node.level = curr.level+1;
                if( !visited[node.val] ){
                    visited[node.val] = true;
                    
                    q.offer(node);
                    counts[node.level]++;
                    level = Math.max( level, node.level );
                }
                
            }
        }
        return counts[level];
    }
    
    public class Node{
        public int level;
        public int val;
        
        public Node( int val ){
            this.val = val;
            this.level = 0;
        }
    }
}
