import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SyncFailedException;
import java.util.*;
public class _5557 {
    public static long answer;
    public static int N;
    public static int[] arr;
    public static long[][] dp;
    public static int lastNumber;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        visited = new boolean[N];
        dp = new long[N][21];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        lastNumber = arr[N-1];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],-1);
        }
        dp[0][arr[0]]=1;
        System.out.println(dp[N-2][arr[N-1]]);

    }

    private static void bottoUp() {
        for(int i=0;i<N-1;i++){
            for(int number =0;number<=20;number++){
                if(dp[i][number]!=0){
                    if(number+arr[i+1]<=20) dp[i+1][number+arr[i+1]]+= dp[i][number];
                    if(number-arr[i+1]>=0) dp[i+1][number-arr[i+1]]+= dp[i][number];
                }
            }
        }
    }

}
