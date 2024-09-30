import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630 {
    public static int N;
    public static int[][] arr;
    public static int[] answerCount;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        answerCount = new int[2];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divideAndConquer(1,1,N,N);
        System.out.println(answerCount[0]);
        System.out.println(answerCount[1]);



    }
    public static void divideAndConquer(int startR,int startC,int endR,int endC){
        int standard = arr[startR][startC];
        if(isAllCorrect(startR, startC, endR, endC, standard)){
            answerCount[standard]++;
            return;
        }
        int midR = (startR+endR)/2;
        int midC = (startC+endC)/2;
        divideAndConquer(startR,startC,midR,midC);
        divideAndConquer(midR+1,midC+1,endR,endC);
        divideAndConquer(startR,midC+1,midR,endC);
        divideAndConquer(midR+1,startC,endR,midC);
    }

    private static boolean isAllCorrect(int startR, int startC, int endR, int endC, int standard) {
        for(int i = startR; i<= endR; i++){
            for(int j = startC; j<= endC; j++){
                if(arr[i][j]!= standard){
                    return false;
                }
            }
        }
        return true;
    }
}
