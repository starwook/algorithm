public class 등굣길 {
    class Solution {
        int maxNum = 1000000007;
        int answer = 0;
        int map[][];
        int dp[][];
        public int solution(int m, int n, int[][] puddles) {
            map = new int[n+1][m+1];
            dp = new int[n+1][m+1];
            dp[1][1] =1;
            for(int i=0;i< puddles.length;i++){
                map[puddles[i][1]][puddles[i][0]] =1;
            }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(map[i][j]==1){
                        dp[i][j] =0;
                        continue;
                    }
                    if(i==1&&j==1){
                        continue;
                    }
                    if(i>1){
                        dp[i][j]+=dp[i-1][j];
                    }
                    if(j>1){
                        dp[i][j]+=(dp[i][j-1]);
                    }
                    if(dp[i][j]>1000000007){
                        dp[i][j] %=1000000007;
                    }
                }
            }
            // for(int i=1;i<=n;i++){
            //     for(int j=1;j<=m;j++){
            //         System.out.print(dp[i][j]+" ");
            //     }
            //     System.out.println();
            // }

            return dp[n][m];
        }
    }
}
