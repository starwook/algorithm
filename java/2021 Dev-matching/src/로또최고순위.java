

public class 로또최고순위 {
    public static void main(String[] args) {

    }
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = {0,0};
            int zeroCount=0;
            int correctCount =0;
            for(int i=0;i<lottos.length;i++){
                if(lottos[i] ==0){
                    zeroCount++;
                }
                for(int j=0;j<win_nums.length;j++){
                    if(lottos[i] ==win_nums[j]){
                        correctCount++;
                    }
                }
            }

            int maxNum =correctCount+zeroCount;
            int minNum = correctCount;
            answer[0] =checkRank(maxNum);
            answer[1] = checkRank(minNum);
            return answer;
        }
        public int checkRank(int num){
            if(num >=2){
                return 7-num;
            }
            return 6;
        }
    }
}