import java.util.PriorityQueue;

public class 더_맵게 {

    class Solution {
        public int answer = 0;
        public PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        public int solution(int[] scoville, int K) {
            for(int i=0;i<scoville.length;i++){
                priorityQueue.add(scoville[i]);
            }
            while(!priorityQueue.isEmpty()){
                if(priorityQueue.peek()>=K){
                    break;
                }
                if(priorityQueue.peek()<K){
                    if(priorityQueue.size()<=1){
                        answer =-1;
                        break;
                    }
                    int newNumber = priorityQueue.poll();
                    int mulNumber = priorityQueue.poll();
                    newNumber += (mulNumber*2);
                    priorityQueue.add(newNumber);
                    answer++;
                }
            }
            return answer;
        }
    }
}
