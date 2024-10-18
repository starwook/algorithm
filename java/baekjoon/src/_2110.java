import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2110 {
    public static int[] arr;
    public static int N,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int minDistance =1;
        int maxDistance = arr[N-1]-arr[0];

        int answer =0;
        while(minDistance<=maxDistance){
            int midDistance = (minDistance+maxDistance)/2;

            int index =0;
            int cnt =1;
            for(int i=1;i<N;i++){
                if(arr[i]-arr[index]>=midDistance){
                    cnt++;
                    index =i;
                }
            }
            if(cnt<C){
                maxDistance = midDistance-1;
            }
            if(cnt>=C){//같을 경우도 플러스하여준다.
                minDistance = midDistance+1;
                answer = midDistance;
            }
        }
        System.out.println(answer);
    }
}

