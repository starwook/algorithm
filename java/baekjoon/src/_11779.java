import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class _11779 {
    static int n,m;
    static int maxDistance =100000;
    static int start,end;
    static List<Node>[] ways;
    static int[] before,distance;
    static List<Integer> counts = new ArrayList<>();
    static class Node{
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    static PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) ->o1.cost-o2.cost);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        ways = new List[n+1];
        before = new int[n+1];
//        for(int i=0;i<=n;i++) before[i] = i;
        distance = new int[n+1];
        for(int i=1;i<=n;i++) distance[i] = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++) ways[i] = new ArrayList<>();
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            ways[from].add(new Node(to,cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        for(int i=0;i<ways[start].size();i++){
            int to = ways[start].get(i).to;
//            before[to] = start;
        }
        distance[start] = 0;
        queue.add(new Node(start,0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
//            if(visited[node.to]) continue;
//            visited[node.to] = true;
            if(distance[node.to]<node.cost) continue;
            for(int i=0;i<ways[node.to].size();i++){
                Node nextNode = ways[node.to].get(i);
//                if(visited[nextNode.to]) continue;

//                System.out.println(node.to+"/"+nextNode.to);
//                System.out.println("before"+distance[nextNode.to]+"/"+ distance[node.to]+"+"+ nextNode.cost);
                if(distance[nextNode.to]>distance[node.to]+ nextNode.cost){
//                    System.out.println("short");
                    distance[nextNode.to] = distance[node.to]+ nextNode.cost;
                    before[nextNode.to] = node.to;
                    queue.add(new Node(nextNode.to,distance[nextNode.to]));
                }
            }
        }
//        for(int i=1;i<=n;i++){
//            System.out.println(before[i]);
//        }
        System.out.println(distance[end]);
        findFirst(end);
        System.out.println(counts.size());
        for(int number : counts){
            System.out.print(number+" ");
        }

    }
    static void findFirst(int number){
        if(before[number]==0){
            counts.add(number);
            return;
        }
        findFirst(before[number]);
        counts.add(number);
    }
}
