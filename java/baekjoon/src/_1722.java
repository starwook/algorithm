import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _1722 {
    public static int N;
    public static long[] factorialNumber;
    public static boolean[] visited;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        factorialNumber = new long[N+1];
        visited = new boolean[N+1];
        arr = new int[N+1];
        factorialNumber[0] =1;
        for(int i=1;i<=N;i++) {
            factorialNumber[i] =factorialNumber[i-1]*i;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int type = Integer.parseInt(st.nextToken());
        if(type==1){
            long number = Long.parseLong(st.nextToken());
            for(int i=N-1;i>=0;i--){ //몇번쨰 자리수?
                for(int j=1;j<=N;j++){
                    if(visited[j]) continue;
                    if(number<=factorialNumber[i]){
                        System.out.print(j+" ");
                        visited[j] =true;
                        break;
                    }
                    else{
                        number-=factorialNumber[i];
                    }
                }
            }
        }
        if(type ==2){
            for(int i=1;i<=N;i++){
                arr[i] =Integer.parseInt(st.nextToken());
            }
            long index =1;
            for(int i=N-1;i>=0;i--){ //i는 자리수
                for(int j=1;j<arr[N-i];j++){ // j는 자릿수의 숫자
                    if(visited[j])continue;
                    index+= factorialNumber[i];
                }
                visited[arr[N-i]] =true;
            }
            System.out.println(index);
        }
    }

}
