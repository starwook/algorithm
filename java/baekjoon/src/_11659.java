import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11659 {
    public static int N,M;
    public static int[] arr,sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        sum = new int[N+1];


        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1]+arr[i];
        }
        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            System.out.println(sum[second]-sum[first-1]);
        }
    }
}
