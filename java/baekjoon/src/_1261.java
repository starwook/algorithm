import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1261 {
    public static char[][] map;
    public static int startR,startC,r,c;
    public static boolean[][] visited;
    public static int xi[] = {-1,1,0,0};
    public static int yi[] = {0,0,-1,1};
    public static int[][] costMap;

    public static PriorityQueue<Node> Nodes = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new char[r+1][c+1];
        visited = new boolean[r+1][c+1];
        costMap = new int [r+1][c+1];
        startR =startC=1;
        for(int i=1;i<=r;i++){
           String nowRow =br.readLine();
           for(int j=0;j<c;j++){
               map[i][j+1] = nowRow.charAt(j);
           }
        }
        Nodes.add(new Node(startR,startC,0));
        while(!Nodes.isEmpty()){
            Node node = Nodes.poll();
            int nowR = node.r;
            int nowC = node.c;
            int nowCost = node.cost;
            if(visited[nowR][nowC]) continue;
            visited[nowR][nowC] = true;
            costMap[nowR][nowC] = nowCost;
//            System.out.println(nowR+" "+nowC+" "+nowCost);

            for(int i=0;i<4;i++){
                int nextR = nowR+xi[i];
                int nextC = nowC+yi[i];
                if(nextR<1 ||nextC<1||nextR>r||nextC>c) continue;
                if(visited[nextR][nextC]) continue;
                if(map[nextR][nextC] =='0' ){
                    Nodes.add(new Node(nextR,nextC,nowCost));
                }
                if(map[nextR][nextC] =='1'){
                    Nodes.add(new Node(nextR,nextC,nowCost+1));
                }
            }
        }
        System.out.println(costMap[r][c]);
//        for(int i=1;i<=r;i++){
//            for(int j=1;j<=c;j++){
//                System.out.print(costMap[i][j]+" ");
//            }
//            System.out.println();
//        }

    }
    public static class Node {
        int r;
        int c;
        int cost;

        public Node(int startR, int startC, int i) {
            this.r = startR;
            this.c = startC;
            this.cost =i;
        }
    }
}
