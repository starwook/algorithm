import java.util.*;
public class k번쨰_수 {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            List<Integer> answer = new ArrayList<>();
            for(int i=0;i<commands.length;i++){
                int[] tmpArray = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
                System.out.println(tmpArray);
                answer.add(tmpArray[commands[i][2]-1]);
                Arrays.sort(tmpArray);
            }
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
