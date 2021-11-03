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
        int n = Integer.parseInt(s);
        s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        Map<Integer, Integer> map = new HashMap<>();
        int[] n_list = new int[n];
        for( int i = 0; i < n; i++ )
        {
            int card = Integer.parseInt(st.nextToken());
            map.put( card, map.getOrDefault( card, 0 ) + 1 );
        }
        s = bf.readLine();
        int m = Integer.parseInt(s);
        s = bf.readLine();
        st = new StringTokenizer(s);
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for( int i = 0; i < m; i++ )
        {
            int card = Integer.parseInt(st.nextToken());
            if( i == 0 )
                if( map.containsKey( card ) )
                    bw.write( map.get(card) + "" );
                else
                    bw.write( "0" );
            else
                if( map.containsKey( card ) )
                        bw.write( " " + map.get(card) );
                    else
                        bw.write( " 0" );
        }
        bw.flush();
        bw.close();
            
     }
}
