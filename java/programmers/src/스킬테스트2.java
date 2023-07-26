import java.util.Collections;
import java.util.PriorityQueue;

public class 스킬테스트2 {
    public String solution(String number, int k) {
        String answer = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<number.length();i++){
            if(pq.size()<k){
                pq.add(number.charAt(i) -'0');
            }
        }

        return answer;
    }
}
