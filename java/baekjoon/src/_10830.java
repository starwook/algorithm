import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10830 {
    public static int N;
    public static long B;
    static int[][] originalArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        originalArr = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) originalArr[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][] answer =separate(B);
        if(B==1){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(originalArr[i][j]%1000+" ");
                }
                System.out.println();
            }
            return;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int[][] separate(long b){
        if(b ==1){
            return originalArr;
        }
        int[][] calculated = separate(b/2);
        if(b%2 ==0){
            return calculate(calculated,calculated);
        }
        else{
            return calculate(calculated,calculate(calculated,originalArr));
        }
    }
    static int[][] calculate(int[][] first, int[][] second){
        int[][] returnArr = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int index=0;index<N;index++){
                    returnArr[i][j] += (first[i][index]*second[index][j]);
                    returnArr[i][j] %= 1000;
                }
            }
        }
        return returnArr;
    }
}
