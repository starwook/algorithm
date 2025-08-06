import java.util.*;

public class EXAM_01_30 {
    static class Solution {
        public int solution(int N, int number) {
            if (N == number) return 1;

            List<Set<Integer>> dp= new ArrayList<>(9);
            for(int i=0;i<=8;i++) dp.add(new HashSet<>());

            int num =0;
            for(int i=1;i<=8;i++){
                num = num*10+number;
                dp.get(i).add(num);



            }




            return -1; // 8번을 넘어가면 -1
        }

        // 간단 테스트
        public static void main(String[] args) {
            Solution s = new Solution();
            System.out.println(s.solution(5, 12)); // 4
            System.out.println(s.solution(2, 11)); // 3
        }
    }
}
