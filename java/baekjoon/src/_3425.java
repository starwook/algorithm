import java.util.*;
public class _3425 {
    public static char[][] arr;
    public static int[][] dp;
    public static boolean[][] visited;
    public static int N,M;
    public static int answer =0;
    public static boolean loop = false;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N= scanner.nextInt();M= scanner.nextInt();scanner.nextLine();
        arr = new char[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M];
        for(int i=0;i<N;i++){
            String number = scanner.nextLine();
            for(int j=0;j<number.length();j++) arr[i][j] = number.charAt(j);
        }

        dfs(0,0,new ArrayList<>());
        if(loop) System.out.println(-1);
        else System.out.println(dp[0][0]+1);

    }

    private static void showDpTable() {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("///////");
    }

    public static int dfs(int r,int c,List<Integer> numbers){
//        showDpTable();
        int number = arr[r][c]-'0';
        visited[r][c] =true; //1.체크인
        if(r-number>=0){ // 3.순회
            checkNext(r - number, c, c, r,numbers);
        }
        if(r+number<N){
            checkNext(r + number, c, c, r,numbers);
        }
        if(c-number>=0){
            checkNext(r,c-number,c,r,numbers);
        }
        if(c+number<M){
            checkNext(r, c + number, c,r,numbers);
        }
        visited[r][c] =false; //6.체크아웃
        return dp[r][c]+1;
    }

    private static void checkNext(int newR, int newC, int c, int r,List<Integer> numbers) {
        if(arr[newR][newC] =='H') return; //4-1 갈 수 있는가?(구멍이 아닌곳)
        if(visited[newR][newC]){ //4-2 이미 방문한 곳(무한 사이클)
            loop = true;
            return;
        }
        if (dp[newR][newC] != 0) { //이미 한 번 간곳은
            dp[r][c] = Math.max(dp[r][c], dp[newR][newC] + 1);
            //dp[r][c] 가 0이 아닌 곳이 CheckIn
        }
        else {
            dp[r][c] = Math.max(dp[r][c], dfs(newR, newC,numbers)); //5간다
        }

    }


}
