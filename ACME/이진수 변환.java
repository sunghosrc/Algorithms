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
        long n = Long.parseLong(s);
        System.out.println( toBinary(n, new StringBuilder() ).reverse().toString() );

    }
    
    public static StringBuilder toBinary( long n, StringBuilder sb )
    {
        if( n == 0 )
            return sb;
        return toBinary(n/2, sb.append(n%2) );
    }
    
}
