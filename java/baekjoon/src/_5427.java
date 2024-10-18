import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5427 {
    public static int t,w,h,n,m;
    public static char[][] map;
    public static int[] ri = {-1,1,0,0};
    public static int[] ci = {0,0,-1,1};
    public static boolean[][] visited;
    public static Queue<Node> nodes = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bufferedReader.readLine());
        for(int tc =0;tc<t;tc++){
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            m=  Integer.parseInt(st.nextToken());
            n =Integer.parseInt(st.nextToken());
            map = new char[n][m];
            visited = new boolean[n][m];
            nodes = new LinkedList<>();
            for(int i=0;i<n;i++){
                String line  = bufferedReader.readLine();
//                System.out.println(line);
                for(int j=0;j<m;j++){
                    map[i][j] = line.charAt(j);
                    if(map[i][j] =='*'){
                        nodes.add(new Node(i,j,true,0));
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j] =='@'){
                        nodes.add(new Node(i,j,false,0));
                    }
                }
            }
            bfs();
        }
    }
    private static void printMap(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void bfs() {
        while(!nodes.isEmpty()){
//            printMap();
            Node node = nodes.poll();

            if(node.isFire){
                for(int i=0;i<4;i++){
                    int nextR = node.r+ri[i];
                    int nextC = node.c+ci[i];
                    if(nextR<0||nextR>=n||nextC<0||nextC>=m)continue;
                    if(map[nextR][nextC]=='.'||map[nextR][nextC]=='@'){
                        map[nextR][nextC] = '*';
                        nodes.add(new Node(nextR,nextC,true,node.count+1));
                    }
                }
            }
            else{
                if(node.r==0||node.r==n-1||node.c==0||node.c==m-1){
                    System.out.println(node.count+1);
                    return;
                }
                for(int i=0;i<4;i++){
                    int nextR = node.r+ri[i];
                    int nextC = node.c+ci[i];
                    if(nextR<0||nextR>=n||nextC<0||nextC>=m)continue;
                    if(map[nextR][nextC]=='.'){
                        map[nextR][nextC] = '@';
                        nodes.add(new Node(nextR,nextC,false,node.count+1));
                    }
                }
            }

        }
        System.out.println("IMPOSSIBLE");
    }

    public static class Node{
        int r, c;
        boolean isFire;
        int count;

        public Node(int r, int c, boolean isFire, int count) {
            this.r = r;
            this.c = c;
            this.isFire = isFire;
            this.count = count;
        }


        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public boolean isFire() {
            return isFire;
        }
    }
}
