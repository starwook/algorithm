public class kakao_intern_3 {
    class Solution {
        public int[][] dp;
        public int divideNumber = 10007;
        public int solution(int n, int[] tops) {
            int answer = 0;
            dp = new int[tops.length*2+1][2];
            dp[0][0] = 1;
            for(int i=1;i<tops.length*2+1;i++){
                dp[i][0] = dp[i-1][0]+dp[i-1][1];
                dp[i][0] %= divideNumber;
                dp[i][1] = dp[i-1][0];
                dp[i][1] %= divideNumber;
                if(i%2==0) continue;
                if(tops[(i/2)]==1){
                    dp[i][1] +=(dp[i-1][0]+dp[i-1][1]);
                }
                dp[i][1] %= divideNumber;
            }
            System.out.println(dp[tops.length*2][0]+dp[tops.length*2][1]);
            return answer;
        }
    }
}
