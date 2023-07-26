import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _7453 {
    public static int N;
    public static int[] A,B,C,D;
    public static int[] aAndB;
    public static long answer;
    public static int[] cAndD ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A= new int[N];B=new int[N];C = new int[N]; D = new int[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        aAndB = new int[N*N];
        cAndD = new int[N*N];
        int idx =0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                aAndB[idx]= A[i]+B[j];
                cAndD[idx] = C[i]+D[j];
                idx++;
            }
        }
        Arrays.sort(aAndB);
        Arrays.sort(cAndD);
        int upIndex = 0;
        int downIndex =N*N-1;
        while(true){
            int currentA = aAndB[upIndex];
            int currentB = cAndD[downIndex];
            long sum = currentA+currentB;
            if(sum>0){
                downIndex--;
            }
            if(sum<0){
                upIndex++;
            }
            if(sum==0){
                long cntUp =0;
                long cntDown=0;
                while(upIndex<N*N&&currentA==aAndB[upIndex]){
                    upIndex++;
                    cntUp++;
                }
                while(downIndex>=0&&currentB==cAndD[downIndex]){
                    downIndex--;
                    cntDown++;
                }
                answer+=(cntUp*cntDown);
            }
            if(upIndex==N*N||downIndex==-1) break;
        }
        System.out.println(answer);
    }
}