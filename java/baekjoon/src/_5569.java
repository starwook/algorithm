import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _5569 {
    public static int W,H;
    public static int[][][] dp;
    public static int[][][] arr;
    public static int divideBy = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        dp = new int[H][W][2];
        for(int i=0;i<W;i++) dp[0][i][1] =1;
        for(int i=0;i<H;i++) dp[i][0][0] =1;




    }

}
