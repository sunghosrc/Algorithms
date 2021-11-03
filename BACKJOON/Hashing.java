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
        s = bf.readLine();
        char[] chars = s.toCharArray();
        long sum = 0;
        long powerCum = 1;
        for( int i = 0; i < chars.length; i++ )
        {
            long hashVal = chars[i] - 'a' + 1;
            sum += ( hashVal * powerCum  );
            sum = sum % M;
            powerCum *= r;
            powerCum = powerCum % M;
        }
        
        System.out.println( sum % M );

    }
    
}
