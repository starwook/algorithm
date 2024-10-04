import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _10282 {
    public static int[] distanceFromFirst;
    public static boolean[] visited;
    public static List<Node>[] cango;
    public static PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.distance-o2.distance);
    public static int testCase,n,d,c;
    public static int answerCount,answerTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        for(int t=0;t<testCase;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            distanceFromFirst = new int[n + 1];
            cango = new List[n + 1];
            visited = new boolean[n + 1];
            answerCount = answerTime = 0;
            for (int i = 1; i <= n; i++) cango[i] = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                distanceFromFirst[i] = Integer.MAX_VALUE;
            }
            distanceFromFirst[c] = 0;

            for (int i = 0; i < d; i++) {
                int a, b, s;
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                cango[b].add(new Node(a, s));
            }
            queue.add(new Node(c, 0));

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                visited[node.index] = true;
//                System.out.println(node.index+":nowIndex");
                for (Node nextNode : cango[node.index]) {
//                    if (visited[nextNode.index]) continue;
                    if (distanceFromFirst[nextNode.index] > distanceFromFirst[node.index] + nextNode.distance) {
                        queue.add(new Node(nextNode.index, distanceFromFirst[node.index] + nextNode.distance));
                        distanceFromFirst[nextNode.index] = distanceFromFirst[node.index] + nextNode.distance;
//                        System.out.println(distanceFromFirst[nextNode.index]);
                        visited[nextNode.index] = true;
                    }
                }
            }

            for (int i = 1; i <= n; i++){
                if(distanceFromFirst[i] !=Integer.MAX_VALUE){
                    answerCount++;
                    answerTime = Math.max(answerTime,distanceFromFirst[i]);
                }

            }
            System.out.println(answerCount+" "+ answerTime);
        }
    }
    static class Node{
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }
    }
}
