import java.util.ArrayList;
import java.util.List;

public class 하노이의탑 {
    class Solution {
        public List<Turn> turns = new ArrayList<Turn>();
        public int[][] solution(int n) {
            hanoi(1,3,n);
            return turns.stream()
                    .map(turn -> new int[]{turn.from,turn.to})
                    .toArray(int[][]::new);
        }
        public void hanoi(int from, int to, int height){
            if(height == 1){
                turns.add(new Turn(from,to));
                return;
            }
            int mid = getMid(from, to);
            hanoi(from,mid,height-1);
            turns.add(new Turn(from,to));
            hanoi(mid,to,height-1);
        }
        public int getMid(int from, int to) {
            int mid = 0;
            if(from ==1){
                if(to ==3){
                    mid =2;
                }
                if(to ==2){
                    mid =3;
                }
            }
            if(from ==2){
                if(to ==3){
                    mid =1;
                }
                if(to ==1){
                    mid =3;
                }
            }
            else if(from ==3){
                if(to ==2){
                    mid =1;
                }
                if(to ==1){
                    mid =2;
                }
            }
            return mid;
        }
    }
    class Turn{
        int from;
        int to;

        public Turn(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }
    }
}
