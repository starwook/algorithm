import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Programmers_N으로표현 {
    static class Solution {
        public int solution(int N, int number) {
            if (N == number) return 1;

            List<Set<Integer>> dp= new ArrayList<>(9);
            for(int i=0;i<=8;i++) dp.add(new HashSet<>());

            int num =0;
            for(int i=1;i<=8;i++){
                num = num*10+N;
                dp.get(i).add(num);

                for(int j=1;j<i;j++){
                    Set<Integer> one = dp.get(j);
                    Set<Integer> two = dp.get(i-j);
                    for(int o:one){
                        for(int t:two){
                            dp.get(i).add(o+t);
                            dp.get(i).add(o-t);
                            dp.get(i).add(o*t);
                            if(t!=0) dp.get(i).add(o/t);
                        }
                    }
                }
                if(dp.get(i).contains(number)) return i;
            }

            return -1; // 8번을 넘어가면 -1
        }

        // 간단 테스트
        public static void main(String[] args) {
            EXAM_01_30.Solution s = new EXAM_01_30.Solution();
            System.out.println(s.solution(5, 12)); // 4
            System.out.println(s.solution(2, 11)); // 3
        }
    }
}
