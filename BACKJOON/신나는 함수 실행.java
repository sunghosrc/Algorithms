import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) throws IOException	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<int[]> list = new ArrayList<>();
        int a = 0, b = 0, c = 0, max = 0;
        
        while( true ){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int _a = Integer.parseInt(st.nextToken());
            int _b = Integer.parseInt(st.nextToken());
            int _c = Integer.parseInt(st.nextToken());
            
            if(_a == -1 && _b == -1 && _c == -1)
                break;
            
            list.add(new int[]{_a, _b, _c});
            
            if(_a <= 0)
                _a = 0;
            if(_b <= 0)
                _b = 0;
            if(_c <= 0)
                _c = 0;
            if( _a > 20 || _b > 20 || _c > 20 ){
                _a = 20;
                _b = 20;
                _c = 20;
            }
            if(_a >= a){
                if( _b >= b ){
                    if( _c >= c ){
                        a = _a;
                        b = _b;
                        c = _c;
                    }
                }
            }
        }
        
        int[][][] dp = new int[a+1][b+1][c+1];

        for(int i = 0; i < a+1; i++ ){
            for(int j = 0; j < b+1; j++ ){
                for( int k = 0; k < c+1; k++){
                    if( i == 0 || j == 0 || k == 0 ){
                        dp[i][j][k] = 1;
                    } else if( i < j && j < k ){
                        dp[i][j][k] = dp[i][j][k-1]+dp[i][j-1][k-1]-dp[i][j-1][k];
                    } else {
                        dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
                    }
                }
            }
        }
        
        for( int[] abc : list ){
            int _a = abc[0];
            int _b = abc[1];
            int _c = abc[2];
            
            
            
            if(_a <= 0 || _b <= 0 || _c <= 0){
                _a = 0;
                _b = 0;
                _c = 0;
            }
            
            if( _a > 20 || _b > 20 || _c > 20 ){
                _a = 20;
                _b = 20;
                _c = 20;
            }
            
            sb.append("w(").append(abc[0]) 
                .append(", ").append(abc[1])
                .append(", ").append(abc[2])
                .append(") = ").append(dp[_a][_b][_c]).append("\n");
            
        }
        
        System.out.println(sb.toString());
        
        
    }
}
