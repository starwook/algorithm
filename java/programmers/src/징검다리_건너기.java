import java.util.*;
public class 징검다리_건너기 {
    class Solution {
        Deque<Integer> deque = new ArrayDeque<>();
        public int solution(int[] stones, int k) {
            int answer = Integer.MAX_VALUE;
            int tmp = 0;
            for(int i=0;i<stones.length-(k+1);i++){
                deque.add(stones[i]);
                if(deque.size()>k){

                }


            }
            return answer;
        }
    }
}
