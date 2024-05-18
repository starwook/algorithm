import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11049 {
    public static int N;
    public static int[] arr;
    public static int[][] dp;
    public static int[] choosed;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        arr = new int[N+1];
        choosed = new int[N+1];

        dp = new int[N+1][N+1];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i+1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<=N;i++){
            dp[i][i] = arr[i];
        }


        System.out.println(findAnswer(0,N));
    }
    public static int findAnswer(int firstIndex,int secondIndex){
        if(dp[firstIndex][secondIndex] !=0 ) return dp[firstIndex][secondIndex];
        if(secondIndex-firstIndex<=2){
            int tmp =1;
            for(int i=firstIndex;i<=secondIndex;i++){
                tmp *= arr[i];
            }
            dp[firstIndex][secondIndex] = tmp;
            return dp[firstIndex][secondIndex];
        }
        int minNumber = Integer.MAX_VALUE;
        for(int i=firstIndex+1;i<=secondIndex-1;i++){
            int left = findAnswer(firstIndex,i);
            int right = findAnswer(i,secondIndex);
            if(i-firstIndex==1) left =0;
            if(secondIndex- i==1) right =0;
            minNumber = Math.min(minNumber,left+ right+ arr[firstIndex]*arr[i]*arr[secondIndex]);
        }
        dp[firstIndex][secondIndex] = minNumber;
        return minNumber;
    }
}
  