import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class _1167 {
    static int V,longestNode,longestDistance;
    static int[] longestDeep;
    static boolean[] visited;
    static List<Node>[] ways;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        longestDeep = new int[V+1];
        ways = new List[V+1];
        visited = new boolean[V+1];
        for(int i=1;i<=V;i++) ways[i] = new ArrayList<>();
        for (int i=1;i<=V;i++) longestDeep[i] =-1;
        for(int i=1;i<=V;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int to = Integer.parseInt(st.nextToken());
                if(to==-1) break;
                int cost = Integer.parseInt(st.nextToken());
                ways[v].add(new Node(to,cost));
            }
        }
        findDeepestPath(2,0);
        visited = new boolean[V+1];
        findDeepestPath(longestNode,0);
        System.out.println(longestDistance);
    }
    static void findDeepestPath(int number,int distance){
        visited[number] =true;
        if(distance>longestDistance){
            longestNode = number;
            longestDistance = distance;
        }
        for(int i=0;i<ways[number].size();i++){
            int nextNumber = ways[number].get(i).number;
            if(!visited[nextNumber]){
                findDeepestPath(nextNumber,distance+ways[number].get(i).cost);
            }
        }
    }
    static class Node{
        int number;
        int cost;

        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }

        public Node(int number) {
            this.number = number;
        }
    }
}
