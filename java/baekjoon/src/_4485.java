import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _4485 {
    public static int n;
    public static int[][] arr;
    public static int[][] answer;
    public static int[] xi = {-1,1,0,0};
    public static int[] yi ={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t =1;
        while(true){
            n = Integer.parseInt(br.readLine());
            if(n==0) break;
            arr = new int[n][n];
            answer = new int[n][n];
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    arr[i][j]= Integer.parseInt(st.nextToken());
                    answer[i][j] = 1000000;
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost-o2.cost);
            pq.add(new Node(0,0,arr[0][0]));
            answer[0][0] = arr[0][0];
            while(!pq.isEmpty()){
                Node nowNode = pq.poll();
                for(int i=0;i<4;i++){
                    int nextR = nowNode.r+xi[i];
                    int nextC = nowNode.c+ yi[i];
                    if(nextR>=0&&nextR<n&&nextC>=0&&nextC<n){
                        if(answer[nextR][nextC]>nowNode.cost+arr[nextR][nextC]){
                            answer[nextR][nextC] = nowNode.cost+arr[nextR][nextC];
                            pq.add(new Node(nextR,nextC,answer[nextR][nextC]));
                        }
                    }
                }
            }
            System.out.println("Problem "+t+": "+answer[n-1][n-1]);
            t++;
        }
    }
    public static class Node{
        int r,c,cost;
        Node(int r,int c,int cost){
            this.r =r;
            this.c =c;
            this.cost =cost;
        }
    }
}
