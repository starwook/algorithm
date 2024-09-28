import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _11066 {
    public static int[] arr = new int[500];
    public static int testCase;
    public static int N;
    public static int[][] dp;
    public static int[][] sum;
    public static int maxValue =Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        for(int t =0;t<testCase;t++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            dp = new int[N][N];
            sum =new int[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++)dp[i][j] =maxValue;
            }
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i][i] = arr[i];
            }

            System.out.println(getMinimum(0,N-1)-sum[0][N-1]);
        }
    }
    public static int getMinimum(int left, int right) {
        if (left == right) {
            sum[left][right] = arr[left];
            return arr[left];
        }
        if (dp[left][right] != maxValue) return dp[left][right];
        for (int i = left; i < right; i++) {
            if (dp[left][right] > getMinimum(left, i) + getMinimum(i + 1, right)+sum[left][i]+sum[i+1][right]) {
                dp[left][right] = getMinimum(left, i) + getMinimum(i + 1, right)+sum[left][i]+sum[i+1][right];
                sum[left][right] = sum[left][i] + sum[i + 1][right];
            }
        }
        return dp[left][right];
    }
}
