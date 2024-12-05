import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 배달 {
    class Solution {
        public int[][] distance;
        public int[] baseDistance;
        public boolean[] visited;
        public List<Town>[] ways;
        public PriorityQueue<Town> towns = new PriorityQueue<>(
                (o1, o2) -> o1.cost-o2.cost
        );
        public int solution(int N, int[][] road, int K) {
            distance = new int[N+1][N+1];
            baseDistance = new int[N+1];
            visited = new boolean[N+1];
            ways = new List[N+1];
            for(int i=1;i<=N;i++){
                ways[i] = new ArrayList<>();
                for(int j=1;j<=N;j++){
                    distance[i][j] = 50*10000;
                }
                distance[i][i] =0;
                baseDistance[i] = 50*10000;
            }
            for (int[] curRoad : road) {
                int from = curRoad[0];
                int to = curRoad[1];
                int cost = curRoad[2];
                distance[from][to] = Math.min(distance[from][to],cost);
                distance[to][from] = Math.min(distance[to][from],cost);
            }
            baseDistance[1] =0;
            towns.add(new Town(1,0));
            while(!towns.isEmpty()){
                Town currrentTown = towns.poll();
                System.out.println(currrentTown.index);
                visited[currrentTown.index] = true;
                for(int i=1;i<=N;i++){
                    if(i==currrentTown.index) continue;
                    int nextPathDistance = distance[currrentTown.index][i];
                    if(nextPathDistance==50*10000) continue;
                    if(visited[i]) continue;
                    if(baseDistance[i] >baseDistance[currrentTown.index] + nextPathDistance){
                       baseDistance[i] = baseDistance[currrentTown.index] + nextPathDistance;
                        towns.add(new Town(i,baseDistance[i]));
                    }
                }
            }
            int answer = 0;
            for(int i=1;i<=N;i++){
                System.out.println(i+";"+baseDistance[i]);

                if(baseDistance[i]<=K) {
                    answer++;
                }
            }
            return answer;
        }
    }
    class Town{
        int index;
        int cost;

        public Town(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        public int getIndex() {
            return index;
        }

        public int getCost() {
            return cost;
        }
    }
}
