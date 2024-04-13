import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _가장많이받은선물 {
    class Solution {
        public int[][] giftArr;
        public int[] giftPoint;
        public int maxNum =0;
        public Map<String,Integer> numbers = new HashMap<>();
        public List<Integer> scores = new ArrayList<>();
        public int solution(String[] friends, String[] gifts) {
            int answer = 0;
            giftArr = new int[friends.length][friends.length];
            giftPoint = new int[friends.length];
            for(int i=0;i<friends.length;i++){
                numbers.put(friends[i],i);
            }
            for(int i=0;i<gifts.length;i++){
                String[] information = gifts[i].split(" ");
                int sender = numbers.get(information[0]);
                int receiver = numbers.get(information[1]);
                giftArr[sender][receiver]++;
                giftPoint[sender]++;
                giftPoint[receiver]--;
            }
            for(int i=0;i<friends.length;i++){
                int tmpScore =0;
                for(int j=0;j< friends.length;j++){
                    if(i==j) continue;
                    if(giftArr[i][j]>giftArr[j][i]){
                        tmpScore++;
                    }
                    else if(giftArr[i][j]==giftArr[j][i]){
                        if(giftPoint[i]>giftPoint[j]){
                            tmpScore++;
                        }
                    }
                }
                maxNum = Integer.max(maxNum,tmpScore);
                scores.add(tmpScore);
            }
            return maxNum;
        }
    }

}
