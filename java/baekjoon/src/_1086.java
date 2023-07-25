import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class _1086 {
    public static int N,S,start,end,sum;
    public static int[] arr;
    public static int answer =100001;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        sum = arr[0];
        while(end<N&&start<N){
            if(sum>=S){
                answer = Math.min(answer,end-start+1);
                sum-=arr[start];
                start++;
            }
            if(sum<S){
                end++;
                sum+=arr[end];
            }
        }
        if(answer==100001){
            System.out.println(0);
            return;
        }
        System.out.println(answer);


    }
}
