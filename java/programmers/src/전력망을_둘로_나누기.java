import java.util.*;
public class 전력망을_둘로_나누기 {
    class Solution {
        boolean[][] map;
        boolean[] visited;
        int answer = Integer.MAX_VALUE;
        public int solution(int n, int[][] wires) {
            visited = new boolean[n+1];
            map = new boolean[n+1][n+1];
            for(int i=0;i<wires.length;i++){
                int start = wires[i][0];
                int end = wires[i][1];
                map[start][end] = true;
                map[end][start] = true;
            }
            for(int i=0;i<wires.length;i++){
                int start = wires[i][0];
                int end = wires[i][1];
                map[start][end] = false;
                map[end][start] = false;
                Arrays.fill(visited,false);
                bfs(n,i+1);
                map[start][end] = true;
                map[end][start] = true;
            }
            return answer;
        }
        public void bfs(int n,int start){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            int cnt=1;
            visited[start] = true;
            while(!queue.isEmpty()){
                int point =queue.poll();
                for(int i=1;i<=n;i++){
                    if(visited[i]) continue;
                    if(map[point][i]){
                        cnt++;
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
            answer = Math.min(answer,Math.abs(n-2*cnt));


        }
    }
}
