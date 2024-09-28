import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _14002 {
    public static int N;
    public static int[] numbers;
    public static Stack<Integer> stack;
    public static int[] dp,arr;
    public static int[] before;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        before = new int[N];
        Arrays.fill(dp,-1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            before[i] =i;
        }
        for(int i=0;i<N;i++){
            getMaxDepth(i);
        }
        int maxIndex = 0;
        for(int i=0;i<N;i++){
            if(dp[maxIndex]<dp[i]) maxIndex = i;
        }
        System.out.println(dp[maxIndex]);
        getNumber(maxIndex);

    }
    public static int getMaxDepth(int index){
        if(dp[index]!=-1) return dp[index];
        dp[index] = 1;
        for(int i=index+1;i<N;i++){
            if(arr[index]<arr[i]){
                if(dp[index]<getMaxDepth(i)+1){
                    dp[index] = getMaxDepth(i)+1;
                    before[index] = i;
                }
            }
        }
        return dp[index];
    }
    public static void getNumber(int index){
        System.out.print(arr[index]+" ");
        if(before[index]==index) return;
        getNumber(before[index]);
    }
}
