
import java.util.*;
import java.io.*;

class swea_백만장자 {
    static long answer;
    static int T;
    static int[] arr = new int[1000000];

    static class Node {
        int index;
        int number;

        Node(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
                if (o1.number == o2.number) return o2.index - o1.index;
                return o2.number - o1.number;
            });
            answer = 0L;
            int n = Integer.parseInt(br.readLine());
            arr = new int[1000000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                pq.add(new Node(i,arr[i]));
            }
            int startIndex =0;
            while(!pq.isEmpty()){
                Node node = pq.poll();
                //System.out.println(node.number+","+node.index+","+answer);
                if(node.index<startIndex) continue;
                long tmpCost =0L;
                for(int i=startIndex;i<node.index;i++){
                    tmpCost += arr[i];
                }
                answer -= tmpCost;
                answer += ((node.index-startIndex)*Long.valueOf(node.number));
                startIndex = node.index+1;
                //if(startIndex>=n) break;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}