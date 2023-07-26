import java.io.*;
import java.util.*;
public class _1927 {
    public static int N;
    public static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=1;i<=N;i++) {
            String str =br.readLine();
            if(str.equals("0")){
                if(priorityQueue.isEmpty()) bw.write("0\n");
                else bw.write(priorityQueue.poll()+"\n");
            }
            else{
                priorityQueue.add(Integer.parseInt(str));
            }
        }

        bw.flush();
        bw.close();
    }
}
