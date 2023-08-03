import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _13251 {
    public static int N,M,K;
    public static int[] color;
    public static double answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        color = new int[M+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalStone =0;
        for(int i=1;i<=M;i++){
            color[i] = Integer.parseInt(st.nextToken());
            totalStone +=color[i];
        }
        K = Integer.parseInt(br.readLine());
        double totalCount = calculateAll(totalStone,K);
        double others =0;
        for(int i=1;i<=M;i++){
            others += calculateAll(color[i],K);
        }
        System.out.println(others/totalCount);
    }
    public static double calculateAll(int n,int c){
        double tmp =1;
        for(int i=0;i<c;i++){
            tmp *=n;
            n--;
        }
        return tmp;
    }
}
