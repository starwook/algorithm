import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1647 {
    public static int[] parent;
    public static PriorityQueue<Vertex> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
    public static int n,m;
    public static int count=1;
    public static int answer;
    public static class Vertex{
        int from;
        int to;
        int cost;

        public Vertex(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Vertex(from,to,cost));
        }
        while(!pq.isEmpty()){
            Vertex nowVertex = pq.poll();
            if(count ==n-1) break;
            if(union(nowVertex.from,nowVertex.to)){
                answer +=nowVertex.cost;

            }
        }
        System.out.println(answer);

    }
    public static boolean union(int a,int b){
        int parentA = findParent(a);
        int parentB = findParent(b);
        if(parentA ==parentB) return false;
        parent[parentA] = parentB;
        count++;
        return true;
    }
    public static int findParent(int x){
        if(parent[x] ==0) return x;
        return parent[x] = findParent(parent[x]);
    }
}
