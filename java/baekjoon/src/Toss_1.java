import java.util.*;
public class Toss_1 {

    class Solution1 {
        public int[] exist = new int[10];
        public int solution(String s, int N) {
            int answer = -1;
            if(s.equals("1")&& N==1) return 1;
            for(int i=0;i<s.length()-N;i++){
                exist = new int[10];
                String tmp = s.substring(i,i+N);
                for(int j=0;j<tmp.length();j++) exist[tmp.charAt(j)-'0'] = 1;
                for(int j=1;j<=N;j++){
                    if(exist[j]==0) break;
                    if(j==N)answer = Math.max(answer,Integer.parseInt(tmp));
                }
            }
            return answer;
        }
    }
    class Solution2{
        public int solution(int[][] relationships, int target, int limit) {
            int answer = 0;
            return answer;
        }

    }
    class Solution3 {
        public String[] solution(String[] merchantNames) {
            String[] answer = {};
            return answer;
        }
    }
}
