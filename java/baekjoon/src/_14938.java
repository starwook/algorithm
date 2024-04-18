import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14938 {
    public static int[] itemCount;
    public static int[][] distances;
    public static int N,M,R;
    static int answer =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        itemCount = new int[N+1];
        distances = new int[N+1][N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            itemCount[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(i!=j) distances[i][j] = 150000;
            }
        }
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            distances[first][second] = distance;
            distances[second][first] = distance;
        }
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(distances[i][k]+distances[k][j]<distances[i][j]){
                        distances[i][j] =distances[i][k]+distances[k][j];
                    }
                }
            }
        }

        for(int i=1;i<=N;i++){
            int items = 0;
            for(int j =1;j<=N;j++){
                if(distances[i][j]<=M) {
                    items+= itemCount[j];
                }

            }

            answer = Math.max(answer,items);
        }
        System.out.println(answer);
    }
}
