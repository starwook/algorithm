import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result1 {

    /*
     * Complete the 'findMinimumTime' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. UNWEIGHTED_INTEGER_GRAPH centre
     *  2. INTEGER_ARRAY status
     */

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i].
     *
     */
    public static int[] visited;
    public static Map<Integer,List<Integer>> edgeList = new LinkedHashMap();
    public static int answer = 0;
    public static int findMinimumTime(int centreNodes, List<Integer> centreFrom, List<Integer> centreTo, List<Integer> status) {
        visited = new int[centreNodes+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<centreFrom.size();i++){
            if(edgeList.containsKey(centreFrom.get(i))){
                List<Integer> tmp = edgeList.get(centreFrom.get(i));
                tmp.add(centreTo.get(i));
            }
            else{
                List<Integer> tmp = new ArrayList<>();
                tmp.add(centreTo.get(i));
                edgeList.put(centreFrom.get(i),tmp);
            }
            if(edgeList.containsKey(centreTo.get(i))){
                List<Integer> tmp = edgeList.get(centreTo.get(i));
                tmp.add(centreFrom.get(i));
            }
            else{
                List<Integer> tmp = new ArrayList<>();
                tmp.add(centreFrom.get(i));
                edgeList.put(centreTo.get(i),tmp);
            }
        }
        for(int i=0;i<status.size();i++){
            if(status.get(i)==1) queue.add(i+1);
        }

        while(!queue.isEmpty()){
            Arrays.fill(visited,0);
            findMinimum(queue.poll(),status);
        }
        return answer;
    }
    public static void findMinimum(int start,List<Integer> status){
        Queue<Node> nodeQueue = new LinkedList<>();
        visited[start] = 1;
        nodeQueue.add(new Node(start,0));
        while(!nodeQueue.isEmpty()){
            Node node = nodeQueue.poll();
            if(status.get(node.num-1)==3){
                answer = Math.max(answer,node.cnt);
                return;
            }
            List<Integer> nextMove = edgeList.get(node.num);
            for(int i=0;i<nextMove.size();i++){
                if(visited[nextMove.get(i)]>=1) continue;
                visited[nextMove.get(i)] =visited[node.num]+1;
                nodeQueue.add(new Node(nextMove.get(i),node.cnt+1));
            }
        }
    }
}
class Node{
    public int cnt;
    public int num;
    Node(int num,int cnt){
        this.cnt =cnt;
        this.num = num;
    }
}

public class 예방접종추진 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] centreNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int centreNodes = Integer.parseInt(centreNodesEdges[0]);
        int centreEdges = Integer.parseInt(centreNodesEdges[1]);

        List<Integer> centreFrom = new ArrayList<>();
        List<Integer> centreTo = new ArrayList<>();

        IntStream.range(0, centreEdges).forEach(i -> {
            try {
                String[] centreFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                centreFrom.add(Integer.parseInt(centreFromTo[0]));
                centreTo.add(Integer.parseInt(centreFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int statusCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> status = IntStream.range(0, statusCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result1.findMinimumTime(centreNodes, centreFrom, centreTo, status);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
