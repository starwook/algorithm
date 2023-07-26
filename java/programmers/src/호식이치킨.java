import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 호식이치킨 {

    static int n,m;
    static int maxCount =1000000;
    static boolean[] visited;
    static int AnswerI,AnswerJ;
    static int maxDistance = 10000000;
    static List<Integer> selected = new ArrayList<>();
    static int [][] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        Arrays.fill(visited,false);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                arr[i][j] = 10000000;
                if(i==j){
                    arr[i][j] =0;
                }
            }
        }
        for(int i=1;i<=m;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            arr[a][b] =1;
            arr[b][a] =1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    if(arr[j][k]>arr[j][i]+arr[i][k]){
                        arr[j][k] = arr[j][i]+arr[i][k];
                        arr[k][j] = arr[j][k];
                    }
                }
            }
        }
        printMap(arr);
        bfs(1,0);
        System.out.println(AnswerI+" "+AnswerJ+" "+maxDistance);
    }

    private static void printMap(int[][] arr) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void bfs(int index, int cnt){
        if(cnt ==2){
            int sum =0;
            for(int i=1;i<=n;i++){
                for(int j=0;j<2;j++){
                    sum+=Math.min(arr[i][selected.get(0)],arr[i][selected.get(1)]);
                }
            }
            if(sum<maxDistance){
              AnswerI = selected.get(0);
              AnswerJ = selected.get(1);
              maxDistance = sum;
            }
            return;
        }
        for(int i=index;i<=n;i++){

            if(!visited[i]){
                visited[i] =true;
                selected.add(i);

                bfs(i+1,cnt+1);
                selected.remove(selected.size()-1);

                visited[i] =false;
            }
        }
    }
}
