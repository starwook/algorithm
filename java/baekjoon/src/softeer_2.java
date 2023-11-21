import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class softeer_2 {
    public static int money = 100;
    public static int oil, N, way;
    public static List<Node>[] graph;
    public static List<Result>[] result;
    public static boolean[] visited;
    public static int[] cost;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        oil = Integer.parseInt(st.nextToken());
        way = Integer.parseInt(br.readLine());
        graph = new List[N];
        result = new List[N];
        visited = new boolean[N];
        cost = new int[N];
        for(int i=1;i<N;i++)cost[i] = 1000000;
        for(int i = 0; i< graph.length; i++){
            graph[i] = new ArrayList();
            result[i] = new ArrayList();
        }
        for(int i=0;i<way;i++){
            st = new StringTokenizer(br.readLine());
            char from = st.nextToken().charAt(0);
            char to = st.nextToken().charAt(0);
            int cost = Integer.parseInt(st.nextToken());
            graph[from-'A'].add(new Node(cost,to));
            graph[to-'A'].add(new Node(cost,to));
        }

        PriorityQueue<Node> nodes = new PriorityQueue<>((o1,o2)->o1.distance -o2.distance);
        nodes.add(new Node(0,'A'));
        while(!nodes.isEmpty()){
            Node node = nodes.poll();
            if(!visited[node.next-'A']){
                visited[node.next-'A'] = true;
            }

        }

    }
    public static class Node{
        int distance;
        char next;
        public Node(int distance, char next) {
            this.distance = distance;
            this.next = next;

        }
    }
    public static class Result{
        int remainCost;
        int count;
        int remainOil;

        public Result(int remainCost, int count, int remainOil) {
            this.remainCost = remainCost;
            this.count = count;
            this.remainOil = remainOil;
        }
    }
}