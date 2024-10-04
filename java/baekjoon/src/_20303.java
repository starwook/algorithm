import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20303 {
    public static int N,M,K;
    public static int[] candyCount;
    public static boolean[][] friend;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candyCount = new int[N+1];
        friend = new boolean[N+1][N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            candyCount[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a][b] = true;
            friend[b][a] = true;
        }

    }
}
