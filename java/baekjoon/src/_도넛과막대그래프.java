import java.util.ArrayList;
import java.util.List;

public class _도넛과막대그래프 {
    class Solution {
        public int[] outCount,inCount;
        public int startNode;
        public List<Integer>[] nodes;
        public int[] answer = new int[4];
        public int[] solution(int[][] edges) {

            outCount = new int[1000001];
            inCount = new int[1000001];
            nodes = new ArrayList[1000001];
            for(int i=0;i<=1000000;i++) nodes[i] = new ArrayList<>();

            for(int i=0;i<edges.length;i++){
                int from = edges[i][0];
                int to = edges[i][1];
                outCount[from]++;
                inCount[to]++;
                if(outCount[from]>=2 &&inCount[from]==0) startNode = from;
                nodes[from].add(to);
            }
            answer[0] = startNode;
            System.out.println(startNode);
            for(int i=0;i<nodes[startNode].size();i++){
                findGraph(nodes[startNode].get(i));
            }
            return answer;
        }
        public void findGraph(int start){
            int type = dfs(start,start);
            answer[type]++;
        }
        public int dfs(int node,int start){
            if(outCount[node]==0) return 2;
            if(outCount[node]==2) return 3;
            if(nodes[node].get(0)==start) return 1;
            return dfs(nodes[node].get(0),start);
        }


    }
}
