public class 카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            for(int r=1;r<=yellow;r++){
                if(yellow%r ==0){
                    int c = yellow/r;
                    System.out.println(r+"/"+c);
                    if((brown-4)-2*r-2*c==0){
                        answer[0] =c+2;
                        answer[1] =r+2;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
