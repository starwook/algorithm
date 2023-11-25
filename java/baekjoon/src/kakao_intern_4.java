import java.util.Arrays;

public class kakao_intern_4 {
    class Solution {
        public int solution(int coin, int[] cards) {
            int startNum = cards.length/3;
            int[] startArr = new int[startNum];
            for(int i=0;i<startNum;i++) startArr[i] = cards[i];
            Arrays.sort(startArr);
            int startSum = startArr[startArr.length-1]+startArr[startArr.length-2];
            System.out.println(startSum);
            int answer = 0;
            return answer;
        }
    }
}
