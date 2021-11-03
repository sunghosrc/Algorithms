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
        while( n != 0 )
        {
            System.out.println( calculateFactorialNum(n) );
            s = bf.readLine();
            n = Integer.parseInt(s);
        }
    }
    
    private static int calculateFactorialNum( int n )
    {
        int x = 1;
        int f = 1;
        int res = 0;
        while( n != 0 )
        {
            int r = n % 10;
            res += ( r * x );
            n = n / 10;
            f++;
            x *= f;
        }
        return res;
    }
}
