import java.util.*;
public class 문자열_압축 {
    class Solution {
        public int solution(String s) {
            int answer = s.length();
            for(int k=1;k<s.length();k++){
                int tmpAnswer = s.length();
                for(int index =0;index<s.length()-k;index+=k){
                    String tmpString = s.substring(index,index+k);
                    int cnt =1;
                    while(index+2*k<=s.length()&& s.substring(index+k,index+2*k).equals(tmpString))                 {
                        cnt++;
                        index +=k;
                    }
                    tmpAnswer -= ((cnt-1)*k);
                    if(cnt!=1){
                        tmpAnswer += Integer.toString(cnt).length();
                    }

                }
                answer = Math.min(answer,tmpAnswer);
            }
            return answer;
        }
    }
}
