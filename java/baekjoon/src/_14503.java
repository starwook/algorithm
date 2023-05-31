import java.util.Arrays;
import java.util.Scanner;

public class _14503 {
    public static int[][] arr;
    public static int[][] VISITED;
    public static int[] xi = {-1,0,1,0};  //북서남동
    public static int[] yi = {0,-1,0,1};
    public static int nowR;
    public static int nowC;
    public static boolean canMove;
    public static int n,m;
    public static String UP = "0";
    public static int answer;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        int r,c,firstPosition;
        r = scanner.nextInt();
        c = scanner.nextInt();
        firstPosition =scanner.nextInt();
        scanner.nextLine();
        arr = new int[n][m];
        VISITED = new int[n][m];
        for(int i=0;i<n;i++){
            String tmp = scanner.nextLine();
            String[] numbers = tmp.split(" ");
            for(int j=0;j<numbers.length;j++){
                arr[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        countMove(r,c,firstPosition);
        System.out.println(answer);

    }
    public static void countMove(int r,int c,int position){
        nowR = r;
        nowC = c;
        int nextPosition =position;
        while(true){
            if(VISITED[nowR][nowC]==0){ //지금 있는 곳을 청소
                answer++;
                VISITED[nowR][nowC] = 1;
                printVisite();
            }
            canMove = false;
            nextPosition = findNextPostion(nextPosition);
            if(!canMove){
                int backPosition= nextPosition;
                if(nextPosition==0){
                    backPosition=2;
                }
                else if(nextPosition==1){
                    backPosition=3;
                }
                else if(nextPosition==2){
                    backPosition=0;
                }
                else if(nextPosition==3){
                    backPosition = 1;
                }
                else if(arr[nowR+xi[backPosition]][nowC+yi[backPosition]]==1){//후진도 못 한다면
                    break;
                }
            }
            nowR +=xi[nextPosition];
            nowC +=yi[nextPosition];


        }
    }

    private static void printVisite() {
        System.out.println("//////////////////////////");
        for(int i=0;i< VISITED.length;i++){
            for(int j=0;j<VISITED[i].length;j++){
                System.out.print(VISITED[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static int findNextPostion(int position) {
        for(int i = position; i<4; i++) {
            int newR = nowR+xi[i];
            int newC = nowC+yi[i];
            if(nowR<=0||nowR>=n-1||nowC<=0||nowC>=m-1)continue;
            if(VISITED[newR][newC]==0 && arr[newR][newC]==0){
                System.out.println("nextPostion="+ i);
                canMove = true;
                return i;
            }
        }
        for(int i=0;i<position;i++){
            int newR = nowR+xi[i];
            int newC = nowC+yi[i];
            if(nowR<=0||nowR>=n-1||nowC<=0||nowC>=m-1)continue;
            if(VISITED[newR][newC]==0 && arr[newR][newC]==0){
                System.out.println("nextPostion="+ i);
                canMove = true;
                return i;
            }
        }
        System.out.println("cnatMove");
        return position;
    }
}
