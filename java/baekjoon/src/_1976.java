import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1976 {
    static int N,M;
    static boolean[] connected,visited;
    static List<Integer>[] canGo;
    static List<Integer> ways = new ArrayList<>();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        connected = new boolean[N+1];
        visited = new boolean[N+1];
        canGo = new ArrayList[N+1];
        for(int i=1;i<=N;i++) canGo[i] = new ArrayList<>();
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int city = Integer.parseInt(st.nextToken());
                if(city==1){
                    canGo[i].add(j);
                    canGo[j].add(i);
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            ways.add(Integer.parseInt(st.nextToken()));
        }
        dfs(ways.get(0));
        boolean possible = true;
        for(int i=0;i<ways.size();i++){
            if(!visited[ways.get(i)]) possible =false;
        }
        if(possible) System.out.println("YES");
        else System.out.println("NO");
    }
    static void dfs(int index){
        visited[index] = true;
        for(int i=0;i<canGo[index].size();i++){
            int to = canGo[index].get(i);
            if(visited[to]) continue;
            dfs(to);
        }
    }
}
