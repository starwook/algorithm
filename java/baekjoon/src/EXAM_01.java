import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EXAM_01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] p ={103,101,103,103,101,102,100,100,101,104};
        solution.solution(p);
    }
    public static  class Solution {
        public int[] dp;
        public int N;
        public List<Integer> remainNumbers = new ArrayList<>();
        public int solution(int[] p) {
            int time =0;
            Arrays.sort(p);
            N = p.length;
            for(int val : p){
                remainNumbers.add(val);
            }
            while(remainNumbers.size()>0){
                time++;
                int LIS = 0;
                dp = new int[remainNumbers.size()];
                int tempSize = remainNumbers.size();
                for(int i=0;i<tempSize;i++){
                    int number = remainNumbers.get(i);
                    int idx = binarySearch(number,0,LIS,LIS+1);
                    if(idx==-1){
                        dp[LIS] = number;
                        LIS++;
                    }
                    else{
                        dp[idx] = number;
                    }
                }
                for(int i=0;i<dp.length;i++){
                    remainNumbers.remove(Integer.valueOf(dp[i]));
                }
            }
            return p.length-time;
        }
        private int binarySearch(int num,int start,int end,int size){
            int res = 0;
            while (start <= end) {
                // 중앙 값을 찾는다.
                int mid = (start + end) / 2;

                // 만일 현재 선택된 원소가 해당 원소보다 작거나 같다면, 앞 부분을 탐색한다.
                if (num <= dp[mid]) {
                    // 해당 원소의 위치를 기억해둔다.
                    res = mid;
                    end = mid - 1;
                }
                // 만일 현재 선택된 원소가 해당 원소보다 크다면, 뒷 부분을 탐색한다.
                else {
                    start = mid + 1;
                }
            }
            // dp테이블에서 삽입될 위치를 찾지 못한 경우(즉, 모든 수들보다 큰 경우).
            if (start == size) {
                return -1;
            }
            // dp테이블에서 삽입될 위치를 찾은 경우.
            else {
                return res;
            }
        }
    }


}
