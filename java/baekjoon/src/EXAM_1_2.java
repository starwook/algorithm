import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EXAM_1_2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] p = {103, 101, 103, 103, 101, 102, 100, 100, 101, 104};
        int answer = solution.solution(p);
        System.out.println("최소 증가열 개수: " + answer);
    }

    public static class Solution {
        public int[] dp;
        public int N;
        public List<Integer> remainNumbers = new ArrayList<>();

        public int solution(int[] p) {
            int answer = 0;

            // Step 1: 입력 배열 정렬
            Arrays.sort(p);
            N = p.length;
            for (int val : p) {
                remainNumbers.add(val);
            }

            // Step 2: remainNumbers가 비워질 때까지 반복
            while (!remainNumbers.isEmpty()) {
                int LIS = 0;
                dp = new int[remainNumbers.size()];
                List<Integer> currentLIS = new ArrayList<>(); // 현재 LIS 추적용

                int tempSize = remainNumbers.size();
                for (int i = 0; i < tempSize; i++) {
                    int num = remainNumbers.get(i); // remainNumbers에서 값 가져오기
                    int idx = binarySearch(num, 0, LIS, LIS + 1);

                    if (idx == -1) {
                        dp[LIS] = num;
                        LIS++;
                    } else {
                        dp[idx] = num;
                    }

                    // 추적 리스트 업데이트
                    if (idx == currentLIS.size()) {
                        currentLIS.add(num); // 새로운 위치에 추가
                    } else {
                        currentLIS.set(idx, num); // 기존 위치 업데이트
                    }
                }

                // Step 3: 현재 LIS에 포함된 숫자를 remainNumbers에서 삭제
                remainNumbers.removeAll(currentLIS);

                // Step 4: 증가열 하나 처리했으므로 answer 증가
                answer++;
            }

            return answer;
        }

        private int binarySearch(int num, int start, int end, int size) {
            int res = 0;
            while (start <= end) {
                int mid = (start + end) / 2;

                if (num <= dp[mid]) {
                    res = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (start == size) {
                return -1;
            } else {
                return res;
            }
        }
    }
}