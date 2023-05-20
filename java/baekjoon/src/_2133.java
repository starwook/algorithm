import java.util.Scanner;

public class _2133 {
    public static int[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[n+1];
        dp[1] =0;
        dp[2] =3;
        for(int i=3;i<=n;i++){
            if(i%2!=0){
                dp[i] =0;
                continue;
            }
            dp[i] += dp[i-2]*3;
            dp[i] += (dp[i-4]*2+2);
        }
        System.out.println(dp[n]);
    }
}
