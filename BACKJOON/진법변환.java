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
        String number = st.nextToken();
        int n_method = Integer.parseInt(st.nextToken());
               
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        toDecimal( bw, number, n_method );

      
    }
    
    private static void toDecimal( BufferedWriter bw, String number, int n_method ) throws IOException
    {
        
        char[] chars = number.toCharArray();
        int decimal = 0;
        
        if( n_method == 10 )
        {
            bw.write( number );
        }
        else
        {
            for( int i = chars.length - 1; i >= 0 ; i-- )
            {
                int n = chars[i] - 'A';
                if( n < 0 )
                    n = chars[i] - '0';
                else
                    n = n + 10;

                decimal += ( n * Math.pow(n_method,chars.length-1-i) );
            }
            bw.write( decimal + "" );

        }
        
        bw.flush();
        bw.close();
    }
    
}
