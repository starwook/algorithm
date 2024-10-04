import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4179 {
    public static int maxR,maxC,JR,JC,FR,FC;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] xi = {-1,1,0,0,};
    public static int[] yi = {0,0,-1,1};
    public static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        maxR = Integer.parseInt(stringTokenizer.nextToken());
        maxC = Integer.parseInt(stringTokenizer.nextToken());

        map = new char[maxR][maxC];
        visited = new boolean[maxR][maxC];

        for(int i=0;i<maxR;i++){
            String line = bufferedReader.readLine();
            for(int j=0;j<maxC;j++){
                map[i][j] =line.charAt(j);
                if(map[i][j] =='J'){
                    JR =i;
                    JC =j;
                }
                if(map[i][j] =='F'){
                    FR =i;
                    FC =j;
                    queue.add(new Node(FR,FC,'F',0));
                }
            }
        }
        queue.add(new Node(JR,JC,'J',0));
        visited[JR][JC]=true;
        visited[FR][FC] =true;
        boolean exit =false;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.type=='J'){
                if(node.r==0||node.r==maxR-1||node.c ==0||node.c==maxC-1){
                    System.out.println(node.count+1);
                    exit = true;
                    break;
                }
                for(int i=0;i<4;i++){
                    int newR = node.r+xi[i];
                    int newC = node.c+yi[i];
                    if(newR>=0&&newC>=0&&newR<maxR&&newC<maxC){
                        if(map[newR][newC] =='.'){
                            queue.add(new Node(newR,newC,node.type,node.count+1));
                            map[newR][newC] = node.type;
                        }
                    }
                }
            }
            if(node.type=='F'){
                for(int i=0;i<4;i++){
                    int newR = node.r+xi[i];
                    int newC = node.c+yi[i];
                    if(newR>=0&&newC>=0&&newR<maxR&&newC<maxC){
                        if(map[newR][newC] =='.'||map[newR][newC]=='J'){
                            queue.add(new Node(newR,newC,node.type,node.count+1));
                            map[newR][newC] = node.type;
                        }
                    }
                }
            }
//            for(int i=0;i<maxR;i++){
//                for(int j=0;j<maxC;j++){
//                    System.out.print(map[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
        if(!exit){
            System.out.println("IMPOSSIBLE");
        }

    }

    static class Node{
        int r,c;
        char type;
        int count;

        public Node(int r, int c, char type, int count) {
            this.r = r;
            this.c = c;
            this.type = type;
            this.count = count;
        }

        public Node(int count) {
            this.count = count;
        }

        public char getType() {
            return type;
        }

        public Node(int r, int c, char type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }
    }
}
