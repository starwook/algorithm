import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16987 {
    public static int N;
    public static int[][] arr;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            //0은 내구도, 1은 무게
        }
        findMaxBroken(0,0);
        System.out.println(answer);

    }
    public static void findMaxBroken(int brokenNumber,int index){
        if(index==N){ //마지막까지 왔음
            answer = Math.max(brokenNumber,answer);
            return;
        }
        if(arr[index][0]<=0){ //손에 든 계란이 깨졌음
            findMaxBroken(brokenNumber,index+1);
            return;
        }
        boolean unBroken = false;
        for(int i=0;i<N;i++){
            if(i==index) continue;
            if(arr[i][0]>0){ // 안 꺠진 계란이 있다면
                unBroken =true;
                arr[i][0] -= arr[index][1];
                if(arr[i][0]<=0) brokenNumber++;
                arr[index][0] -= arr[i][1];
                if(arr[index][0]<=0) brokenNumber++;
                findMaxBroken(brokenNumber,index+1);
                if(arr[i][0]<=0) brokenNumber--;
                arr[i][0] +=arr[index][1];
                if(arr[index][0]<=0) brokenNumber--;
                arr[index][0] +=arr[i][1];
            }
        }
        if(!unBroken){
            findMaxBroken(brokenNumber,index+1);
        }
    }
}
