import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1027 {
    public static int[] arr,count,max;
    public static int N,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        count = new int[N+1];
        max = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N;i++){
            for(int j=i+1;j<=N;j++){
                if(arr[j]<max[i]){
                    count[i]++;
                    count[j]++;
                    max[i] = arr[j];
                }
                answer = Math.max(answer,count[i]);
                answer = Math.max(answer,count[j]);
            }
        }
        for(int i=1;i<=N;i++){
            System.out.println(count[i]);
        }

    }
}
