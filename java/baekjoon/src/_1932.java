import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _1932 {
    public static int N;
    public static int[][] dp;
    public static int[][] arr;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][N+1];
        arr = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=i;j++) {
                int tmp =Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
            }
        }
        dp[1][1] = arr[1][1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+arr[i][j];
                answer = Math.max(dp[i][j],answer);
            }
        }
//        for(int i=1;i<=N;i++){
//            for(int j=1;j<=i;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(answer);
    }
}
