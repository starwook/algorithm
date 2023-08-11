import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _5719 {
    public static int N,M,start,end;
    public static int dist[];
    public static int maxNum = 987654321;
    public static PriorityQueue<Node>  nodes = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
    public static List<Integer>[] shortestPath;
    public static List<Node>[] graph;
    public static boolean[][] cantGo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 || M == 0) break;
            graph = new List[N];
            shortestPath = new List[N];
            dist = new int[N];
            cantGo = new boolean[N][N];
            for (int i = 0; i < N; i++) dist[i] = maxNum;
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
                shortestPath[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph[from].add(new Node(to, cost));
            }

            dist[start] = 0;
            nodes.add(new Node(start, 0));
            dijkstra();
            removePath(start,end);
            for (int i = 0; i < N; i++) dist[i] = maxNum;
            dist[start] = 0;
            dijkstra();
            if(dist[end]==maxNum){
                System.out.println(-1);
            }
            else System.out.println(dist[end]);

        }
    }
    public static void removePath(int start,int end){
        if(start==end) return;
        for(int nextNode : shortestPath[end]){
            if(!cantGo[nextNode][end]){
                cantGo[nextNode][end] = true;
                removePath(start,nextNode);
            }
        }
    }
    public static void dijkstra(){
            nodes.add(new Node(start,0));
            while(!nodes.isEmpty()) {
                Node node = nodes.poll();
                if (dist[node.number] < node.cost) continue;
                for (int nextIndex = 0; nextIndex < graph[node.number].size(); nextIndex++) {

                    Node nextNode = graph[node.number].get(nextIndex);
                    if (cantGo[node.number][nextNode.number]) continue;
                    if (dist[nextNode.number] > dist[node.number] + nextNode.cost) {
                        dist[nextNode.number] = dist[node.number] + nextNode.cost;
                        nodes.add(new Node(nextNode.number, dist[nextNode.number]));
                        shortestPath[nextNode.number] = new ArrayList<>();
                        shortestPath[nextNode.number].add(node.number);
                    }
                    if (dist[nextNode.number] == dist[node.number] + nextNode.cost) {
                        shortestPath[nextNode.number].add(node.number);
                    }
                }
            }

    }
    public static class Node{
        int number;
        int cost;

        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }
    }
}
