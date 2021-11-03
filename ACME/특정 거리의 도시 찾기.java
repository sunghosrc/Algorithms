import java.util.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class Main{

    public static void main(String []args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] map = new ArrayList[n+1];
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        
        for( int i = 0; i < m; i++ ){
            s = bf.readLine();
            st = new StringTokenizer(s);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            if( map[start] == null )
                map[start] = new ArrayList<Integer>();
            
            map[start].add(end);
        }
        
        q.offer(x);
        visited[x]=true;
        while( !q.isEmpty() && k != 0 ){
            int start = q.poll();
            if(map[start] != null)
                for( int c : map[start] ){
                    if(!visited[c]){
                        temp.add(c);
                        visited[c] = true;
                    }
                }
            if(q.isEmpty()){
                k--;
                for( int c : temp )
                    q.offer(c);
                temp = new ArrayList<>();
            }
        }
        
        if( k == 0 ){
            if( q.isEmpty() )
                System.out.println("-1");
            else {
                for( int c : q )
                    res.add(c);
                Collections.sort(res);
                for( int c : res ){
                    System.out.println(c);
                }
            }
        } else {
            System.out.println("-1");
        }
    }
    
}특정 거리의 도시 찾기
