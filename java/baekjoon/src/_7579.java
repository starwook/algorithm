import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _7579 {
    public static int[] memory,cost;
    public static int[][] maximumMemory;
    public static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cost = new int[N];
        memory = new int[N];
        int maginoCost = N*100+1;
        maximumMemory = new int[N][maginoCost];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            memory[i] =Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MAX_VALUE;
        for(int app =0;app<N;app++){
            for(int costIndex=0;costIndex<maginoCost;costIndex++) {

                if (app == 0) { //첫번쨰 앱이라면
                    if (cost[app] > costIndex) continue;  //현재 앱의 가격이 실제 쓸 수 있는 가격보다 크다면 넘겨라
                    maximumMemory[app][costIndex] = memory[app];
                } else {
                    if (cost[app] > costIndex) {
                        maximumMemory[app][costIndex] = maximumMemory[app - 1][costIndex];
                    } else {
                        maximumMemory[app][costIndex] = Math.max(maximumMemory[app - 1][costIndex], maximumMemory[app - 1][costIndex - cost[app]] + memory[app]);
                    }
                }
                if(maximumMemory[app][costIndex]>=M) answer = Math.min(answer,costIndex);


            }
        }

        System.out.println(answer);
    }
}
