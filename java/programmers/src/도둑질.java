import java.util.*;
public class 도둑질 {
    int[] dp;
    public int solution(int[] money) {
        dp = new int[money.length];
        getMaxCount(money, money.length - 1);//첫번째 털었을때
        int includeFirst = dp[money.length-2];
        Arrays.fill(dp,0);
        money[0] =0; //첫번째 안 털 때
        getMaxCount(money, money.length);
        int noIncludeFirst = dp[money.length-1];
        return Math.max(noIncludeFirst,includeFirst);
    }
    private void getMaxCount(int[] money, int i2) {
        dp[0] = money[0];
        dp[1] = money[1];
        dp[2] = Math.max(dp[0] + money[2], dp[1]);
        for (int i = 3; i < i2; i++) {
            dp[i] = Math.max(dp[i - 3] + money[i], dp[i - 2] + money[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
    }
}
