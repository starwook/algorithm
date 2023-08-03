import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _2458 {
    public static int N,M;
    public static int[][] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(st.nextToken());
        parent = new int[N+1][N+1];
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            parent[a][b]=1;
        }
        for(int mid =1;mid<=N;mid++){
            for(int start =1;start<=N;start++){
                for(int end =1;end<=N;end++){
                    if(parent[start][mid]==1 &&parent[mid][end]==1) parent[start][end]=1;
                }
            }
        }
        int[] totalCount = new int[N+1];
        int answer =0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(parent[i][j]==1) totalCount[i]++;
                if(parent[j][i]==1) totalCount[i]++;
            }
        }
        for(int i=1;i<=N;i++){
            if(totalCount[i]==N-1) answer++;
        }
        System.out.println(answer);
    }
}
