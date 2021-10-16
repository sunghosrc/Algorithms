import java.util.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class HelloWorld{

    public static void main(String []args) throws IOException{
        boolean isConsecutive = false;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int size = Integer.parseInt(s);
        int[] arr = new int[size+1];
        int[] dp = new int[size+1];
        int max = 0;
        for( int i = 0; i < size; i++ )
        {
            s = bf.readLine();
            arr[i+1]= Integer.parseInt(s);
        }
        
        for( int i = 1; i < size+1; i++ )
        {
            if(i == 1)
                dp[i]=arr[i];
            else if(i==2)
                dp[i]=arr[i]+dp[i-1];
            else
            {
                dp[i]=Math.max((dp[i-3]+arr[i-1]+arr[i]), (dp[i-2]+arr[i]));
            }
        }
        
        System.out.println( dp[size] );

    }
    
}
