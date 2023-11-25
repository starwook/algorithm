import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _13549 {
    public static int[] arr;
    public static int maxDistance =100001;
    public static PriorityQueue<Node> nodes = new PriorityQueue<>((o1, o2) -> o1.time-o2.time);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        for(int i=0;i<100001;i++) arr[i] = 100001;
        arr[N] =0;
        nodes.add(new Node(N,0));

        while(true){
            Node nowNode = nodes.poll();
            if(nowNode.position==K){
                System.out.println(nowNode.time);
                break;
            }
            if(nowNode.position-1>=0){
                if(arr[nowNode.position-1]> nowNode.time+1){
                    arr[nowNode.position-1] = nowNode.time+1;
                    nodes.add(new Node(nowNode.position-1,nowNode.time+1));
                }
            }
            if(nowNode.position+1<=100000){
                if(arr[nowNode.position+1]>nowNode.time+1){
                    arr[nowNode.position+1]= nowNode.time+1;
                    nodes.add(new Node(nowNode.position+1, nowNode.time+1));
                }
            }
            if(nowNode.position*2<=100000){
                if(arr[nowNode.position*2]>nowNode.time){
                    arr[nowNode.position*2] = nowNode.time;
                    nodes.add(new Node(nowNode.position*2,nowNode.time));
                }
            }

        }
    }
    public static class Node{
        int position;
        int time;

        public Node(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }
}
