import java.util.*;
public class 코딩_테스트_공부 {
    class Solution {
        int answer = Integer.MAX_VALUE;
        Set<Integer> indexes = new LinkedHashSet<>();
        public int solution(int alp, int cop, int[][] problems) {
            bfs(alp,cop,problems);
            return answer;
        }
        public void bfs(int alp,int cop,int[][] problems){
            if(indexes.size() == problems.length){


                return;
            }
            for(int i=0;i<problems.length;i++){

            }
        }
    }
}
