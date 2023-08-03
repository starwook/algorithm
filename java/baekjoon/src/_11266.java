import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _11266 {
    public static List<Integer>[] graph;
    public static int V,E;
    public static int[] depth;
    public static int depthNumber;
    public static Set<Integer> answer = new HashSet<>();
    public static int totalChildNumber;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V =Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new List[V+1];
        depth = new int[V+1];
        for(int i=1;i<=V;i++) graph[i] = new ArrayList<>();
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }
        for(int i=1;i<=V;i++){
            if(depth[i]==0) {
                depthNumber=1; //초기화
                dfs(i,true);
            }
        }
        System.out.println(answer.size());
        List<Integer> sorted = answer.stream().sorted().collect(Collectors.toList());
        for(int i=0;i<sorted.size();i++) System.out.print(sorted.get(i)+" ");
    }
    public static int dfs(int nodeNumber,boolean isRoot){
        depth[nodeNumber] = depthNumber;
        depthNumber++;
        int ret = depth[nodeNumber];
        int childCount =0;
        for(Integer nextNode : graph[nodeNumber]){
            if(depth[nextNode] !=0){ //이미 방문한 곳(자신의 조상일 수도, 자신보다 늦게 방문한 곳일 수도 있음)
                ret = Math.min(ret,depth[nextNode]);
                continue;
            }
            childCount++;
            int nextRet = dfs(nextNode,false);
            if(nextRet>=depth[nodeNumber]&& !isRoot) answer.add(nodeNumber); //루트면 첫번째 조건은 언제나 true
            //자식들이 갈 수 있는 곳중에 나보다 먼저 방문한 곳이 없음
            ret =Math.min(nextRet,ret); //(자식이 갈 수 있는 곳이 나보다 먼저 간 곳일 수도 있음-> 단절점이아님)
        }
        if(childCount>=2&&isRoot){
            answer.add(nodeNumber);
        }
        return ret;
    }

}
