import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dx_2024_2 {


    public static int[][] arr;
    public static int n,answer,total;
    public static boolean checked[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int test_case =1;test_case<=t;test_case++){
            n = Integer.parseInt(br.readLine());

            answer =0;
            arr = new int[n][3];
            checked = new boolean[3];
            total= 0;
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j =0;j<3;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    total+=arr[i][j];
                }
            }
            if(n<3) {
                System.out.println("#"+test_case+" -1");
                continue;
            }
            bruteForce(0,0);
            System.out.println("#"+ test_case+" "+(total-answer));
        }

    }
    public static void bruteForce(int row,int sum){
        if(row==n){
            if(checked[0]&&checked[1]&&checked[2]) {
                answer = Math.max(answer,sum);
            }
             return;
        }
        for(int i=0;i<3;i++) {
            if(checked[i]){
                bruteForce(row + 1, sum + arr[row][i]);
            }
            else{
                checked[i] = true;
                bruteForce(row + 1, sum + arr[row][i]);
                checked[i] = false;
            }

        }
    }
}
