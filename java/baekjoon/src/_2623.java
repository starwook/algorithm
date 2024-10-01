import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2623 {
    public static List<Integer>[] arr;
    public static int N,M;
    public static int[] countForBefore;
    public static List<Integer> answer = new ArrayList<>();
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        countForBefore = new int[N+1];
        arr = new List[N+1];
        for(int i=1;i<=N;i++) arr[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            String[] num = br.readLine().split(" ");

            int count = Integer.parseInt(num[0]);
            for(int j=1;j<count;j++){
                arr[Integer.parseInt(num[j])].add(Integer.parseInt(num[j+1]));
                countForBefore[Integer.parseInt(num[j+1])]++;
            }
        }

        for(int i=1;i<=N;i++){
            if(countForBefore[i]==0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int num = queue.poll();
            answer.add(num);
            for(Integer nextNum : arr[num]){
                countForBefore[nextNum]--;
                if(countForBefore[nextNum]==0) queue.add(nextNum);
            }
        }
        if(answer.size()==N){
            for(Integer num : answer){
                System.out.println(num);
            }
        }
        else{
            System.out.println(0);
        }


    }

}
