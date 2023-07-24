import java.util.*;
public class _3055 {
    public static int R, C;
    public static char WATER = '*';
    public static char STONE = 'X';
    public static char EMPTY = '.';
    public static char[][] arr;
    public static int[][] visited;
    public static int[][] waters;
    public static int[] xi = {-1, 1, 0, 0};
    public static int[] yi = {0, 0, -1, 1};
    public static int endR,endC;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();
        scanner.nextLine();
        arr = new char[R][C];
        visited = new int[R][C];
        waters = new int[R][C];
        int startR=0;
        int startC=0;
        Queue<Position> waterQueue = new LinkedList<>();
        Queue<Position> positions = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < C; j++){
                arr[i][j] = line.charAt(j);
                if(arr[i][j] =='S') {
                    startR=i;startC =j;
                    arr[i][j] =EMPTY;
                }
                if(arr[i][j] =='D'){
                    endR=i;
                    endC=j;
                }
                if(arr[i][j] =='*'){
                    waters[i][j]=1;
                    positions.add(new Position(i,j,'*'));
                }
            }
        }

        positions.add(new Position(startR,startC,'.'));
        visited[startR][startC] =0;
        while(!positions.isEmpty()){
            Position position = positions.poll(); //1.가져온다
            if(position.what=='D'){ //2.목적지라면
                System.out.println(visited[position.r][position.c]);
                return;
            }
            char positionChar = position.what;
            for(int i=0;i<4;i++){//3.연결된 곳을 순회
                int newR = position.r+xi[i];
                int newC = position.c+yi[i];
                if(newR>=0&&newR<R&&newC>=0&&newC<C){ //4.갈 수 있는가?
                    if(positionChar==WATER){
                        if(arr[newR][newC]==EMPTY){
                            arr[newR][newC] =WATER;
                            positions.add(new Position(newR,newC, arr[newR][newC]));
                        }
                    }
                    if(positionChar ==EMPTY){
                        if(visited[newR][newC]==0&& (arr[newR][newC] ==EMPTY ||arr[newR][newC]=='D')){
                            visited[newR][newC] =visited[position.r][position.c]+1;
                            positions.add(new Position(newR,newC, arr[newR][newC]));
                            //6.큐에 넣음
                        }
                    }
                }
            }
        }
        System.out.println("KAKTUS");

    }

}
class Position{
    public int r;
    public int c;
    public char what;


    public Position(int r, int c,char what) {
        this.r = r;
        this.c = c;
        this.what = what;
    }
}
