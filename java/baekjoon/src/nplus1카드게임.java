import java.util.ArrayList;
import java.util.List;

public class nplus1카드게임 {
    class Solution {
        int leftCoin,big,small,toPay;
        List<Integer> hand = new ArrayList<>();
        public int solution(int coin, int[] cards) {
            int answer = 0;
            toPay = cards.length+1;
            leftCoin = coin;
            for(int i=0;i<cards.length/3;i++) hand.add(cards[i]);
            for(int i=cards.length/3;i< cards.length;i+=2){
                answer++;
                if(cards[i]>cards[i+1]){
                    big = cards[i];
                    small= cards[i+1];
                }
                else{
                    big = cards[i+1];
                    small= cards[small];
                }




            }
            return answer;
        }
    }
}
