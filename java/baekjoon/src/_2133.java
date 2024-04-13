import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _2133 {
    public static int[][] dp;
    public static int[] dpOne;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        dp = new int[31][2];
        dpOne = new int[31];
        dpOne[0] =1;
        for(int i=2;i<=n;i++){
            dpOne[i] += (dpOne[i-2]*3);
            if(i>=4) {
                for(int j=4;j<=i;j+=2){
                    dpOne[i] +=(dpOne[i-j]*2);
                }

            }
        }
        System.out.println(dpOne[n]);

    }
}
 