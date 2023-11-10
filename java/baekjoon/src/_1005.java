import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1005 {
    public static int answer,t;
    public static int[] sequenceCount;
    public static int[] timeToBuild;
    public static int[] maxNumberBefore;
    public static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int tc =0;tc<t;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            answer =0;
            timeToBuild = new int[N+1];
            maxNumberBefore = new int[N+1];
            sequenceCount = new int[N+1];
            graph = new List[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                graph[i] = new ArrayList<>();
                timeToBuild[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                sequenceCount[to]++;
                graph[from].add(to);
            }
            int W = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            for(int i=1;i<=N;i++){
                maxNumberBefore[i] = timeToBuild[i];
                if(sequenceCount[i]==0) queue.add(i);
            }

            while(!queue.isEmpty()){
                int nowNumber = queue.poll();
                for(Integer nextNumber : graph[nowNumber]){
                    sequenceCount[nextNumber]--;
                    maxNumberBefore[nextNumber] = Math.max(maxNumberBefore[nextNumber],maxNumberBefore[nowNumber]+ timeToBuild[nextNumber]);
                    if(sequenceCount[nextNumber]==0) queue.add(nextNumber);
                }
            }
            System.out.println(maxNumberBefore[W]);
        }
    }
}
