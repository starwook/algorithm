import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1600 {
    static int K,W,H;
    static int[][][] visited;
    static int[][] array;
    static int[] ri = {0,0,-1,1};
    static int[] ci = {-1,1,0,0};

    static int[] horseRi = {-1,-2,-2,-1,1,2,2,1};
    static int[] horseCi = {-2,-1,1,2,-2,-1,1,2};
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        visited = new int[H+1][W+1][K+1];
        array = new int[H+1][W+1];
        queue.add(new Node(1,1));
        visited[1][1][0] =1;
        for(int i=1;i<=H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=W;j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(!queue.isEmpty()){
            Node node = queue.poll();

//            System.out.println(node.kCount+"/"+node.count+"/"+node.r+"/"+node.c);
            if(node.r==H&&node.c==W){
                System.out.println(node.count);
                return;
            }
            for(int i=0;i<4;i++){
                int newR = node.r+ri[i];
                int newC = node.c+ ci[i];
                if(newR>=1&&newC>=1&&newR<=H&&newC<=W&&visited[newR][newC][node.kCount]!=1&&array[newR][newC]==0){
                    Node newNode = new Node(newR,newC);
                    newNode.count = node.count+1;
                    newNode.kCount = node.kCount;
                    queue.add(newNode);
                    visited[newR][newC][node.kCount] =1;
                }
            }
            if(node.kCount== K) continue;
            for(int i=0;i<8;i++){
                int newR = node.r+horseRi[i];
                int newC = node.c+ horseCi[i];
                if(newR>=1&&newC>=1&&newR<=H&&newC<=W&&visited[newR][newC][node.kCount+1]!=1&&array[newR][newC]==0){
                    Node newNode = new Node(newR,newC);
                    newNode.count = node.count+1;
                    newNode.kCount = node.kCount+1;
                    queue.add(newNode);
                    visited[newR][newC][newNode.kCount] =1;
                }
            }
        }
        System.out.println(-1);
    }
    static class Node{
        int r,c;
        int count;
        int kCount;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
