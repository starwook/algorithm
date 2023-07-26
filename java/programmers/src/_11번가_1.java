import java.util.ArrayDeque;
import java.util.Deque;

public class _11번가_1 {
    class Solution {
        public int answer;
        public int solution(String S) {
            solveWithDeque(S);
            return answer;
            // Implement your solution here
        }
        public void solveWithDeque(String s){
            Deque<Character> alphabets = new ArrayDeque<>();
            for(int i=0;i<s.length();i++) alphabets.add(s.charAt(i));
            for(int i=0;i<s.length();i++){
                char frontAlphabet = alphabets.pollFirst();
                if(frontAlphabet==alphabets.peekLast()) answer++;
                alphabets.add(frontAlphabet);
            }
        }
    }
}
