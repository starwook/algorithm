import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1766 {
    static int N,M;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o1-o2 );
    static int[] count;
    static List<Integer>[] canGo;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = new int[N+1];
        canGo = new List[N+1];
        for(int i=1;i<=N;i++){
            canGo[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            count[after]++;
            canGo[first].add(after);
        }
        for(int i=1;i<=N;i++){
            if(count[i]==0) pq.add(i);
        }
        while (!pq.isEmpty()) {
            int number = pq.poll();
            System.out.print( number+" ");
            for(int i=0;i<canGo[number].size();i++){
                int nextNumber = canGo[number].get(i);
                count[nextNumber]--;
                if(count[nextNumber]==0) pq.add(nextNumber);
            }
        }

    }
}
