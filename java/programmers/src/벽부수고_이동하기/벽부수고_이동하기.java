package 벽부수고_이동하기;



import java.util.*;
public class 벽부수고_이동하기 {

    public static void main(String[] args) {

        Solution.solve();
    }
}
class Solution{
     static String[] arr;
     static boolean[][][] visited;
     static int n,m;
     static int[] xi = {-1,1,0,0};
    static int[] yi = {0,0,-1,1};
    static int answer =-1;
    static class NextMove{
        public int r;
        public int c;
        public boolean usedBreak =false;
        int cnt;
        NextMove(int r,int c,boolean usedBreak,int cnt){
            this.r = r;
            this.c = c;
            this.usedBreak =usedBreak;
            this.cnt =cnt;
        }
    }
     static void solve(){
         Scanner scanner = new Scanner(System.in);
         n = scanner.nextInt();
         m = scanner.nextInt();
         arr = new String[n];
         visited = new boolean[n][m][2];
         scanner.nextLine();
         for(int i=0;i<n;i++){
             arr[i] = scanner.nextLine();
         }
         Queue<NextMove> queue = new LinkedList<>();
         NextMove nextMove = new NextMove(0,0,false,1);
         queue.add(nextMove);
         while(!queue.isEmpty()){
             nextMove = queue.poll();
             if(nextMove.r==n-1 &&nextMove.c ==m-1){
                 System.out.println(nextMove.cnt);
                 return;
             }
             for(int i=0;i<4;i++){
                 int nextR = nextMove.r+xi[i];
                 int nextC = nextMove.c+yi[i];
                 if(nextR<0||nextR>=n||nextC<0||nextC>=m) continue;
                 if(arr[nextR].charAt(nextC)=='0'){
                     if(nextMove.usedBreak&& !visited[nextR][nextC][1]){
                         visited[nextR][nextC][1] =true;
                         queue.add(new NextMove(nextR,nextC,true, nextMove.cnt+1));
                     }
                     if(!nextMove.usedBreak&& !visited[nextR][nextC][0]){
                         visited[nextR][nextC][0] =true;
                         queue.add(new NextMove(nextR,nextC,false, nextMove.cnt+1));
                     }
                 }
                 if(arr[nextR].charAt(nextC)=='1'){
                     if(!nextMove.usedBreak){
                         visited[nextR][nextC][1] =true;
                         queue.add(new NextMove(nextR,nextC,true, nextMove.cnt+1));
                     }
                 }
             }
         }
         System.out.println(-1);
     }
}