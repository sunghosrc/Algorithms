import java.util.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class Main{

    public static void main(String []args) throws IOException{
        int a = 300;
        int b = 60;
        int c = 10;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int t = Integer.parseInt(s);
        if( t % 10 != 0 )
            System.out.println("-1");
        else{
            int div = t / a;
            System.out.print(div + " ");
            t = t % a;
            div = t / b;
            System.out.print(div + " ");
            t = t % b;
            div = t / c;
            System.out.print(div);
        }
    }

}
