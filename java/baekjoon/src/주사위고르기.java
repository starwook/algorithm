import java.util.*;

public class 주사위고르기 {
    class Solution {
        public boolean selected[];
        public int count;
        public int[] answer;
        public int winCount =0;
        public int[][] newDice;
        public Map<Integer,Integer> aScore = new HashMap<>();
        public Map<Integer,Integer> bScore = new HashMap<>();
        public List<Integer> ADice = new ArrayList<>();
        public List<Integer> BDice = new ArrayList<>();
        public int[] solution(int[][] dice) {
            selected = new boolean[dice.length];
            answer = new int[dice.length/2];
            count = dice.length/2;
            newDice = new int[dice.length][];
            for(int i=0;i<dice.length;i++){
                newDice[i] = new int[dice[i].length];
                for (int j = 0; j < dice[i].length; j++) {
                    newDice[i][j] = dice[i][j];
                }
            }
            chooseDice(0,0);
            return answer;
        }
        public void chooseDice(int index,int nowCount){
            if(nowCount==count){
                chooseNumber();
                return;
            }
            for(int i=index;i<count*2;i++){
                selected[i] = true;
                chooseDice(i+1,nowCount+1);
                selected[i] = false;
            }
        }
        public void chooseNumber(){
            ADice = new ArrayList<>();
            BDice = new ArrayList<>();
            aScore = new HashMap<>();
            bScore = new HashMap<>();

            for(int i=0;i<selected.length;i++){
                if(selected[i]) ADice.add(i);
                else BDice.add(i);
            }
            countScore(aScore,ADice,0,0);
            countScore(bScore,BDice,0,0);

            int tmpWinCount = 0;
            for(Integer aKey : aScore.keySet()){
                for(Integer bKey : bScore.keySet()){
                    if(aKey>bKey){
                        tmpWinCount+= (aScore.get(aKey)*bScore.get(bKey));
                    }
                }
            }
            // System.out.println(tmpWinCount);
            if(tmpWinCount >winCount){
                //System.out.println(ADice);
                winCount = tmpWinCount;
                for(int i=0;i<ADice.size();i++){
                    answer[i] = ADice.get(i)+1;
                }
            }
            Arrays.sort(answer);
        }
        public void countScore(Map<Integer,Integer> scores,List<Integer> dice,int index,int score){
            if(index ==dice.size()){

                if(scores.containsKey(score)){
                    scores.put(score,scores.get(score)+1);
                }else{
                    scores.put(score,1);
                }
                return;
            }
            int[] nowDice = newDice[dice.get(index)];
            for(int i=0;i<6;i++){
                countScore(scores,dice,index+1,score+nowDice[i]);
            }
        }

    }
}
