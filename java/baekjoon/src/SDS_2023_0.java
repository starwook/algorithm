import java.util.*;
public class SDS_2023_0 {

    public static char[][] arr;
    public static boolean[][] visited;
    public static int[][] distance;
    public static int T,M,N;
    public static int rx,ry,bx,by;
    public static int tmpX,tmpY;
    public static int answer =0;
    public static int[] xi = {-1,1,0,0};
    public static int[] yi = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();scanner.nextLine();
        for(int testIndex =1;testIndex<=T;testIndex++){
            answer =0;
            String nAndM = scanner.nextLine();
            String[] nAndMs = nAndM.split(" ");
            N = Integer.parseInt(nAndMs[0]);
            M= Integer.parseInt(nAndMs[1]);
            arr = new char[N+1][M+1];
            visited = new boolean[N+1][M+1];
            distance = new int[N+1][M+1];
            for(int i=1;i<=N;i++){
                String tmp = scanner.nextLine();
                for(int j=0;j<tmp.length();j++){
                    arr[i][j+1] = tmp.charAt(j);
                    if(tmp.charAt(j)=='R'){
                        rx = i;
                        ry = j+1;
                    }
                    if(tmp.charAt(j)=='B'){
                        bx =i;
                        by = j+1;
                    }
                }
            }
            findPath(1,1);

            int moving = Integer.MAX_VALUE;
            boolean toMiddle = false;
            for(int i=1;i<=N;i++){
                for(int j=1;j<=M;j++){
                    if(i==1||j==1||i==N||j==M&&arr[i][j]!='X'){
                        if(distance[i][j]==0) continue;
                        int rToOut = Math.abs(distance[rx][ry]-distance[i][j])+1;
                        int bToOut = Math.abs(distance[i][j]-distance[bx][by])+1;
                        moving = Math.min(moving,rToOut+bToOut);
                        toMiddle = true;
                    }
                }
            }
            if(toMiddle) {
                answer+=moving;
            }
            visited = new boolean[N+1][M+1];
            System.out.print("#"+testIndex+" ");
            answer+=distance[rx][ry];
            answer+=(Math.abs(distance[N][M]-distance[bx][by]));
            if(toMiddle&&distance[rx][ry]!=0&&distance[bx][by]!=0&&distance[N][M]!=0) System.out.println(answer);
            else   System.out.println(-1);
        }

    }
    public static int findbestWay(int startX,int startY,int toX,int toY){
        Queue<ToMove> toMoves = new LinkedList<>();
        toMoves.add(new ToMove(startX,startY,0));
        visited[startX][startY] =true;
        while(!toMoves.isEmpty()){
            ToMove toMove = toMoves.poll();
            int nowX = toMove.x;
            int nowY = toMove.y;
            if(nowX==toX&&nowY==toY) return toMove.count;
            for(int i=0;i<4;i++){
                int newX = nowX+xi[i];
                int newY = nowY+yi[i];
                if(newX>=1&&newX<=N&&newY>=1&&newY<=M){
                    if(arr[newX][newY]!='X'&&!visited[newX][newY]){
                        visited[newX][newY] =true;
                        toMoves.add(new ToMove(newX,newY,toMove.count+1));
                    }
                }
            }
        }
        return -1;
    }
    public static void findPath(int startX,int startY){
        Queue<ToMove> toMoves = new LinkedList<>();
        toMoves.add(new ToMove(startX,startY,1));
        visited[startX][startY] =true;
        while(!toMoves.isEmpty()){
            ToMove toMove = toMoves.poll();
            int nowX = toMove.x;
            int nowY = toMove.y;
            distance[nowX][nowY] = toMove.count-1;
            for(int i=0;i<4;i++){
                int newX = nowX+xi[i];
                int newY = nowY+yi[i];
                if(newX>=1&&newX<=N&&newY>=1&&newY<=M){
                    if(arr[newX][newY]!='X'&&!visited[newX][newY]){
                        visited[newX][newY] =true;
                        toMoves.add(new ToMove(newX,newY,toMove.count+1));
                    }
                }
            }
        }
    }

}
class ToMove{
    public int x;
    public int y;
    public int count;

    public ToMove(int x, int y,int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
