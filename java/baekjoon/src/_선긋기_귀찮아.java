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



class Result {

    /*
     * Complete the 'getMergedLineSegments' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY lineSegments as parameter.
     */

    public static PriorityQueue<Node> nodes = new PriorityQueue<>((o1, o2) -> o1.start-o2.start);
    public static List<List<Integer>> getMergedLineSegments(List<List<Integer>> lineSegments) {
        for(int i=0;i<lineSegments.size();i++){
            nodes.add(new Node(lineSegments.get(i).get(0),lineSegments.get(i).get(1)));
        }
        List<List<Integer>> answer = new ArrayList<>();
        boolean firstNode =true;
        List<Integer> newNode = new ArrayList<>();
        int tmpEnd = nodes.peek().end;
        while(!nodes.isEmpty()){
            Node node = nodes.poll();
            if(firstNode){
                newNode = new ArrayList<>();
                newNode.add(node.start);
                firstNode = false;
                continue;
            }
            if(node.start<=tmpEnd){
                if(node.end>tmpEnd) tmpEnd = node.end;
            }
            else{
                newNode.add(tmpEnd);
                answer.add(newNode);
                newNode = new ArrayList<>();
                newNode.add(node.start);
                tmpEnd = node.end;
            }
            if(nodes.isEmpty()){
                newNode.add(tmpEnd);
                answer.add(newNode);
            }
        }
        // Write your code here
        return answer;
    }
    public static class Node{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int lineSegmentsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int lineSegmentsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> lineSegments = new ArrayList<>();

        IntStream.range(0, lineSegmentsRows).forEach(i -> {
            try {
                lineSegments.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<Integer>> result = Result.getMergedLineSegments(lineSegments);

        result.stream()
                .map(
                        r -> r.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
