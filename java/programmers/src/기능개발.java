import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 기능개발 {
    class Solution {
        Stack<Progress> progressStack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        public Integer[] solution(int[] progresses, int[] speeds) {

            for(int i=progresses.length-1;i>=0;i--){
                Progress progress = new Progress();
                progress.setNow(progresses[i]);
                progress.setSpeed(speeds[i]);
                progressStack.add(progress);
            }
            int day =0;
            while(!progressStack.isEmpty()){

                day++;
                int tmpNumber =0;
                while(!progressStack.isEmpty()&&progressStack.peek().now+(progressStack.peek().speed*day)>=100){
                    tmpNumber++;
                    progressStack.pop();
                }
                if(tmpNumber!=0) answer.add(tmpNumber);
            }
            return answer.stream().toArray(Integer[]::new);
        }
    }
    class Progress{
        int now;
        int speed;

        public void setNow(int now) {
            this.now = now;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public int getNow() {
            return now;
        }

        public int getSpeed() {
            return speed;
        }
    }
}
