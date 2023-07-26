public class 정수_삼각형 {
    class Solution {
        int[][] dp;
        public int solution(int[][] triangle) {
            dp = new int[triangle.length][triangle.length];
            dp[0][0] = triangle[0][0];
            int answer = 0;
            for(int i=1;i<triangle.length;i++){
                for(int j=0;j<i+1;j++){
                    if(j==0){
                        dp[i][j] = dp[i-1][j]+triangle[i][j];
                        continue;
                    }
                    if(j==i){
                        dp[i][j] = dp[i-1][j-1]+triangle[i][j];
                        continue;
                    }
                    dp[i][j] = triangle[i][j]+ Math.max(dp[i-1][j-1],dp[i-1][j]);
                    answer = Math.max(dp[i][j],answer);
                }
            }

            return answer;
        }
    }
}
