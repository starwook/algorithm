import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _1922 {
    public static int edge,vertex;
    public static int totalCost;
    public static int[] parent;
    public static PriorityQueue<Line> pq = new PriorityQueue<>(((o1, o2) -> o1.cost-o2.cost));
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vertex = Integer.parseInt(br.readLine());
        parent = new int[vertex+1];
        edge = Integer.parseInt(br.readLine());
        for(int i=0;i<edge;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Line(from,to,cost));
        }

        for(int i=1;i<=vertex;i++) parent[i] = -1;
        while(!pq.isEmpty()){
            Line line =pq.poll();
            if(findParent(line.from)==findParent(line.to)) continue;
            union(line.from,line.to);
            totalCost+=line.cost;
            if(parent[line.from] ==-vertex) break; //이걸 해줘야 최신화됨
        }
        System.out.println(totalCost);
    }
    public static int findParent(int num){
        if(parent[num]<0) return num; //값은 - 트리 맴버 수
        parent[num] = findParent(parent[num]);
        return parent[num];
    }
    public static void union(int a,int b){
        int parentA = findParent(a);
        int parentB = findParent(b);
        if(parentA ==parentB) return;
        parent[parentA] +=parent[parentB]; //-1(각 부위의 부모를 더해줌)
        parent[parentB] =parentA;
    }
    public static class Line {
        public int from;
        public int to;
        public int cost;

        public Line(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
