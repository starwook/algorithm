import java.util.*;
public class _11번가_3 {
    class Solution {
        public int answer;
        public int solution(String S, int[] C) {
            for(int stringIndex=0;stringIndex<S.length()-1;stringIndex++){
                int originalNumber = C[stringIndex];
                while(stringIndex<S.length()-1&&S.charAt(stringIndex)==S.charAt(stringIndex+1)){
                    int newNumber = C[stringIndex+1];
                    if(originalNumber<=newNumber){
                        answer+=originalNumber;
                        originalNumber =newNumber;
                    }
                    if(newNumber<originalNumber){
                        answer+=newNumber;
                    }
                    stringIndex++;
                }
            }
            return answer;
            // Implement your solution here
        }
    }

}
