import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _11404 {
    public static int N,M;
    public static int[][] arr;
    public static int MAX_VALUE = 987654321;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j) arr[i][j] =0;
                else arr[i][j] = MAX_VALUE;
            }
        }
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from =Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[from][to] = Math.min(arr[from][to],cost);
        }
        for(int k=1;k<=N;k++){
            for(int from =1;from<=N;from++){
                for(int to =1;to<=N;to++){
                    if(arr[from][to]>arr[from][k]+arr[k][to]) arr[from][to] = arr[from][k]+arr[k][to];
                }
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j || arr[i][j]==MAX_VALUE){
                    System.out.print(0+" ");
                    continue;
                }
                System.out.print(arr[i][j]+" ");

            }
            System.out.println();
        }
    }

}
