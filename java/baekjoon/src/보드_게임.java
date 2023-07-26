import java.util.*;
import java.io.*;
public class 보드_게임 {
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        arr = new int[n+1];
        arr[0] = 1;
        for(int i=0;i<n;i++){
            arr[i+1] += arr[i];
            arr[i+1] %= 1000000007;
            if(i+3 <=n){
                arr[i+3] +=arr[i];
                arr[i+3] %= 1000000007;
            }
        }
        System.out.println(arr[n]);
    }
}
