import java.io.*;
import java.util.*;

class softeer_1 {
    public static int boxCount;
    public static int[][] arr;
    public static boolean[][] visited;
    public static List<Integer> sizes = new ArrayList<>();
    public static int N;
    public static int[] ri = {-1,1,0,0};
    public static int[] ci = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j]= line.charAt(j)-'0';
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]==1 && !visited[i][j]){
                    findRange(i,j);
                }
            }
        }
        Collections.sort(sizes);
        System.out.println(sizes.size());
        for(int i=0;i< sizes.size();i++) System.out.print(sizes.get(i)+" ");
    }
    public static void findRange(int r,int c){
        int tmpSize =1;
        Queue<Node> nodes = new LinkedList<>();
        visited[r][c] = true;
        nodes.add(new Node(r,c));
        while(!nodes.isEmpty()){
            Node nowNode = nodes.poll();
            int nowR = nowNode.r;
            int nowC = nowNode.c;
            for(int i=0;i<4;i++){
                int nextR = nowR+ri[i];
                int nextC = nowC+ ci[i];
                if(nextR>=0&&nextR<N&&nextC>=0&&nextC<N){
                    if(arr[nextR][nextC]==1 &&!visited[nextR][nextC]){
                        visited[nextR][nextC] = true;
                        tmpSize++;
                        nodes.add(new Node(nextR,nextC));
                    }
                }
            }
        }
        sizes.add(tmpSize);
    }
    public static class Node{
        int r,c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}