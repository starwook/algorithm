import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16724 {
    public static int N,M;
    public static char[][] map;
    public static int[][] visited;
    public static int answer;
    public static int index =1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M];
        for(int i=0;i<N;i++){
            String row = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = row.charAt(j);
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(visited[i][j]==0){
                    dfs(i,j);
//                    for(int r=0;r<N;r++){
//                        for(int c=0;c<M;c++){
//                            System.out.print(visited[r][c]);
//                        }
//                        System.out.println();
//                    }
                }

            }
        }


        System.out.println(answer);
    }
    public static void dfs(int r,int c){
        visited[r][c] =index;
        int newR =r;
        int newC =c;
        if(map[r][c] =='U') newR--;
        if(map[r][c] =='D') newR++;
        if(map[r][c] =='L') newC--;
        if(map[r][c] =='R') newC++;
        if(newR>=0&&newR<N&&newC>=0&&newC<M){
            if(visited[newR][newC]==0) dfs(newR,newC);
            else{
                if(visited[newR][newC]==index) answer++;
            }
            index++;
        }
    }
}
