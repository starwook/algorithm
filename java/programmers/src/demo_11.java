import java.util.Arrays;

public class demo_11 {

    class Solution {
        public int answer=0;
        public int solution(int[] A) {
            // Implement your solution here

            Arrays.sort(A);
            for(int i=0;i<A.length;i++){
                if(A[i]==answer) continue;
                if(A[i]== answer+1){
                    answer = A[i];
                    continue;
                }
                if(A[i]<0) continue;
                break;
            }
            return answer+1;
        }
    }

}
