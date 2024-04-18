import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17404 {
    public static int N;
    public static int[][] arr,sum;
    public static int[][] dp;
    public static int MAX_VALUE =10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        dp = new int[N][3];
        sum = new int[N][3];
        int answer = MAX_VALUE;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        for(int index=0;index<3;index++){

            for(int i=0;i<3;i++){
                if(index==i){
                    dp[0][i] = arr[0][i];
                }
                else dp[0][i] =MAX_VALUE;
            }
            for(int i=1;i<N;i++){
                dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+ arr[i][0];
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) +arr[i][1];
                dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) +arr[i][2];
            }
            for(int i=0;i<3;i++){
                if(i!=index) answer =Math.min(answer,dp[N-1][i]);
            }
        }
        System.out.println(answer);


    }

}
