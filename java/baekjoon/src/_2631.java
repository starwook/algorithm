import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2631 {
    public static int n;
    public static int[] arr,dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        arr = new int[n];
        int maxCount =0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            dp[i] =1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxCount = Math.max(dp[i],maxCount);
        }
        System.out.println(n-maxCount);

    }
}
