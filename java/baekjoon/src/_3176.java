
import java.io.*;
import java.util.*;
public class _3176 {
    public static int N,K;
    public static int maxK = 18;

    public static int[] depth;
    public static int[] firstCost;
    public static int[][] parent;
    public static int[][] maxDistance;
    public static int[][] minDistance;
    public static List<Node>[] graph;
    public static class Node{
        public int number;
        public int cost;

        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }
    }
    public static void setDepth(int number){
        for(int i=0;i<graph[number].size();i++){
            Node nextNode = graph[number].get(i);
            if(depth[nextNode.number] !=0) continue;
            depth[nextNode.number] = depth[number]+1;
            parent[nextNode.number][0] = number;
            setDepth(nextNode.number);
            minDistance[nextNode.number][0] = nextNode.cost;
            maxDistance[nextNode.number][0] = nextNode.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        maxDistance = new int[N+1][maxK];
        minDistance = new int[N+1][maxK];
        parent = new int[N+1][maxK];
        graph = new List[N+1];
        firstCost = new int[N+1];
        for(int i=1;i<=N;i++) graph[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to,cost));
            graph[to].add(new Node(from,cost));
        }

        depth = new int[N+1];
        depth[1] =1;
        setDepth(1); //O(N+E)
<<<<<<< HEAD
        System.out.println(maxDistance[2][0]);
=======
//        for(int i=1;i<=N;i++){
//            for(int k=0;k<3;k++){
//                System.out.print(maxDistance[i][k]+" ");
//            }
//            System.out.println();
//        }
>>>>>>> bda57d99cb944b2d066fbd10c9f076a886b4927c
        for(int k=0;k<maxK;k++){ //거리가 2^k승 차이나는 것부터 다 구함 //O(n)
            for(int nodeNum =2;nodeNum<=N;nodeNum++){ //루트는 확인 안 해도 됨
                int father = parent[nodeNum][k];
                if(father>0){
                    parent[nodeNum][k+1] = parent[father][k]; //부모 추가
                    minDistance[nodeNum][k+1] = Math.min(minDistance[nodeNum][k],minDistance[father][k]);
                    maxDistance[nodeNum][k+1] = Math.max(maxDistance[nodeNum][k],maxDistance[father][k]);
//                    System.out.println(nodeNum+":"+maxDistance[nodeNum][k+1]+"/"+k);
//                    System.out.println(maxDistance[father][k]);
                }
            }
        }
        K = Integer.parseInt(br.readLine());

        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int lower = Integer.parseInt(st.nextToken());
            int deeper =Integer.parseInt(st.nextToken());
            if(depth[lower]>depth[deeper]){
                int tmp = lower;
                lower = deeper;
                deeper =tmp;
            }
            int minValue = Integer.MAX_VALUE;
            int maxValue =0;
            int diff = depth[deeper]-depth[lower];
            int index =0;
            while(diff>0){
                maxValue = Math.max(maxDistance[deeper][index],maxValue);
                minValue = Math.min(minDistance[deeper][index],minValue);
                if(diff%2 ==1){
                  deeper = parent[deeper][index];
                }
                index++;
                diff /=2;
            }
            if(deeper !=lower){
                for(int k=maxK-1;k>=0;k--){
                    int deeperParent = parent[deeper][k];
                    int lowerParent= parent[lower][k];
                    if(deeperParent ==lowerParent) continue;
                    minValue = Math.min(minValue,minDistance[deeper][k]);
                    minValue = Math.min(minValue,minDistance[lower][k]);
                    maxValue = Math.max(maxValue,maxDistance[deeper][k]);
                    maxValue = Math.max(maxValue,maxDistance[lower][k]);
                    deeper = parent[deeper][k];
                    lower = parent[lower][k];
                }

                minValue = Math.min(minValue,minDistance[deeper][0]);
                minValue = Math.min(minValue,minDistance[lower][0]);
                maxValue = Math.max(maxValue,maxDistance[deeper][0]);
                maxValue = Math.max(maxValue,maxDistance[lower][0]);
            }
<<<<<<< HEAD
//            System.out.println(minValue+" "+maxValue);
            System.out.println(maxDistance[4][1]);
=======
            bw.write(minValue+" "+maxValue+"\n");
>>>>>>> bda57d99cb944b2d066fbd10c9f076a886b4927c
        }
        bw.flush();
        bw.close();

    }
}
