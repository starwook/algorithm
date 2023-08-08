import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _9252 {
    public static int answer;
    public static int[][] dp;
    public static String answerString ="";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        dp = new int[a.length()+1][b.length()+1];
        for(int i=1;i<=a.length();i++){
            for(int j=1;j<=b.length();j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                answer = Math.max(dp[i][j],answer);
            }
        }
        int aLength=a.length();
        int bLength=b.length();
        while(aLength>0&&bLength>0){
            if(a.charAt(aLength-1)==b.charAt(bLength-1)){
                answerString = a.charAt(aLength-1)+ answerString;
                aLength--;
                bLength--;
                continue;
            }
            if(dp[aLength][bLength]==dp[aLength-1][bLength]){
                aLength--;
                continue;
            }
            if(dp[aLength][bLength]==dp[aLength][bLength-1]){
                bLength--;
            }
        }
        System.out.println(answer);
        System.out.println(answerString);


    }
}
