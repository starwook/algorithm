import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _1010 {
    public static int N,M;
    public static int T;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bufferedReader.readLine());
        while(T>0){
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(st.nextToken());
            M= Integer.parseInt(st.nextToken());
            dp = new int[30][30];
            for(int i=0;i<=M;i++){
                dp[i][0] = 1;
                dp[i][i] =1;
            }
            for(int i=1;i<=M;i++){
                for(int k=1;k<i;k++){
                    dp[i][k] = dp[i-1][k-1]+dp[i-1][k];
                }
            }
            System.out.println(dp[M][N]);

            T--;
        }
    }
}
