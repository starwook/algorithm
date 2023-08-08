import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class _1753 {
    public static int V,E,START;
    public static List<Vertex>[] graph;
    public static boolean[] visited;
    public static int[] distance;
    public static PriorityQueue<Vertex> vertices = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        visited = new boolean[V+1];
        START = Integer.parseInt(br.readLine());
        graph = new List[V+1];
        distance = new int[V+1];
        for(int i=1;i<=V;i++){
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int from,to,cost;
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Vertex(to,cost));
        }
        vertices.add(new Vertex(START,0));
        distance[START]=0;
        while(!vertices.isEmpty()){
            Vertex vertex = vertices.poll();
            int dest = vertex.destination;
            int cost = vertex.cost;
            if(visited[dest])continue;
            visited[dest] = true;
            for(int i=0;i<graph[dest].size();i++){
                Vertex nextVertex = graph[dest].get(i);
                if(distance[nextVertex.destination]>cost+ nextVertex.cost){
                    distance[nextVertex.destination] = cost+ nextVertex.cost;
                    vertices.add(new Vertex(nextVertex.destination,distance[nextVertex.destination]));
                }
            }
        }
        for(int i=1;i<=V;i++){
            if(distance[i]==Integer.MAX_VALUE){
                System.out.println("INF");
                continue;
            }
            System.out.println(distance[i]);
        }

    }
    public static class Vertex {
        public int destination;
        public int cost;

        public Vertex(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }
}
