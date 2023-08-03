import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _2252 {
    public static int N,M;
    public static int[] indegree;
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N+1];
        List<Integer>[] edges = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            edges[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken());
            int big = Integer.parseInt(st.nextToken());
            indegree[big]++;
            edges[small].add(big);
        }
        for(int i=1;i<=N;i++){
            if(indegree[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now+" ");
            for(int i=0;i<edges[now].size();i++){
                int target = edges[now].get(i);
                indegree[target]--;
                if(indegree[target]==0) queue.add(target);
            }
        }

    }
}

