import java.util.*;
public class 네트워크 {
    class Solution {
        boolean[][] visited;

        public int solution(int n, int[][] computers) {
            visited = new boolean[n][n];
            int answer = 0;
            for(int i=0;i<n;i++){
                Arrays.fill(visited[i],false);
            }
            for(int i=0;i<n;i++){
                if(!visited[i][i]){
                    dfs(i,computers);
                    answer++;
                }
            }
            return answer;
        }
        public void dfs(int index,int[][] computers){
            visited[index][index] =true;
            for(int i=0;i<computers[index].length;i++){
                if(i==index){
                    continue;
                }
                if(!visited[index][i] && computers[index][i]==1){
                    visited[index][i] =true;
                    dfs(i,computers);
                }
            }
        }
    }
}
