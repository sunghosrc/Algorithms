import java.util.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class Main{

    public static void main(String []args) throws IOException{
        int M = 1234567891;
        int r = 31;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = Integer.parseInt(s);
        
        
        System.out.println( factorial(n) );

    }
    
    private static int factorial( int n )
    {
        if( n == 0 )
            return 1;
        if( n == 1 )
            return 1;
        return factorial( n - 1 ) * n;
    }
    
}
