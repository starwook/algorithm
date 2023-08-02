import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _11438 {
    public static List<Integer>[] linked;
    public static int[] depth;
    public static int[][] parent;
    public static int N,M,K_MAX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K_MAX =18; //2_K승만큼 볼 수 있음
        linked = new List[N+1];
        parent = new int[N+1][K_MAX];
        depth = new int[N+1];
        Arrays.fill(depth,-1);
        for(int i=1;i<=N;i++) Arrays.fill(parent[i],-1);
        for(int i=1;i<=N;i++) linked[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            linked[from].add(to);
            linked[to].add(from);
        }
        depth[1] =0;
        setDepth(1);

        for(int k=0;k<K_MAX-1;k++){
            for(int node =1;node<=N;node++){
                if(parent[node][k] ==-1) continue; //루트 위라면 바꿈
                parent[node][k+1] = parent[parent[node][k]][k];
            }
        }


        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int uDepth = depth[u];
            int vDepth = depth[v];
            if(uDepth>vDepth){ //u가 더 밑에 있다면
                int tmp = v;
                v = u;
                u = tmp; //v를 더 밑에 오게한다
            }
            int k=0;
            int diff = depth[v]-depth[u];


            //2진수로 제곱 빠륵 하기 2^1*2^2
            while(diff>0){
                if(diff%2!=0){ //diff 가 2의 배수가 아니라면
                    v = parent[v][k];
                }
                k++;
                diff /=2;
            }

            if(v!=u){ //depth는 같아졌지만 노드는 다를떄
                for(k=K_MAX-1;k>=0;k--){
                    if(parent[u][k]==parent[v][k]) continue;
                    u =parent[u][k];
                    v =parent[v][k];
                }
                System.out.println(parent[u][0]);
            }
            else{
                System.out.println(u);
            }

        }
    }
    public static void setDepth(int nodeNumber){
        for(int i=0;i<linked[nodeNumber].size();i++){
            int nextNode = linked[nodeNumber].get(i);
            if(depth[nextNode]!=-1)continue;
            parent[nextNode][0] = nodeNumber;
            depth[nextNode] = depth[nodeNumber]+1;
            setDepth(nextNode);
        }
    }
}
