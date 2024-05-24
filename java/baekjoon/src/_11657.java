import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class _11657 {
    static int N,M;
    static int[][] distance;
    public static void main(String[] args) throws Exception{

        int maxDistance = 5000*10000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j){
                    distance[i][j] =0;
                    continue;
                }
                distance[i][j] = maxDistance;
            }

        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            distance[from][to] = Math.min(distance[from][to],cost);
        }
        boolean canBeMinus = false;
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(distance[i][j]>distance[i][k]+distance[k][j]){
                        if(distance[i][k]==maxDistance||distance[k][j]==maxDistance) continue;
                        distance[i][j] = distance[i][k]+distance[k][j];
                    }
                }
            }
        }
        for(int i=1;i<=N;i++) {
//            System.out.println(distance[1][i]+"/"+distance[i][i]);
            if(distance[1][i]!=maxDistance && distance[i][i]<0) canBeMinus = true;
        }
        if(canBeMinus) System.out.println(-1);
        else{
            for(int i=2;i<=N;i++){
                if(distance[1][i]==maxDistance) System.out.println(-1);
                else System.out.println(distance[1][i]);
            }
        }
    }
}
