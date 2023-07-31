import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _5573 {
    public static int H,W,N;
    public static int[][] arr;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp= new int[H+1][W+1];
        arr = new int[H+1][W+1];
        for(int i=0;i<H;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<W;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] =N-1;
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                dp[i][j+1] +=(dp[i][j]/2);
                dp[i+1][j] +=(dp[i][j]/2);
                if(arr[i][j]==1){
                    dp[i][j+1] +=(dp[i][j]%2);
                }
                if(arr[i][j]==0){
                    dp[i+1][j] +=(dp[i][j]%2);
                }
            }
        }
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                dp[i][j] = (arr[i][j]+dp[i][j])%2;
          }
        }
//        for(int i=0;i<H;i++){
//            for(int j=0;j<W;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        int r,c;
        r =0;
        c=0;
        while(c<W &&r<H){
            if(dp[r][c]==0){
                r++;
            }
            else{
                c++;
            }
        }
        System.out.println((r+1)+" "+(c+1));
    }
}
