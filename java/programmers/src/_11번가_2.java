import java.util.ArrayList;
import java.util.List;

public class _11번가_2 {
    class Solution {
        public int answer;
        public int[] alphabetCount = new int[26];
        public List<AlphabetToRemove> alphabetToRemoves = new ArrayList<>();
        public int solution(String S) {
            // Implement your solution here
            alphabetToRemoves.add(new AlphabetToRemove('B',1));
            alphabetToRemoves.add(new AlphabetToRemove('N',2));
            alphabetToRemoves.add(new AlphabetToRemove('A',3));
            for(int i=0;i<S.length();i++){
                alphabetCount[S.charAt(i)-'A']++;
            }
            while(true){
                boolean continuable =true;
                for(int i=0;i<alphabetToRemoves.size();i++){

                    AlphabetToRemove alphabetToRemove = alphabetToRemoves.get(i);
                    int alphabetIndex = alphabetToRemove.getAlphabet()-'A';
                    System.out.println(alphabetToRemove.getAlphabet()+":"+alphabetCount[alphabetIndex]);
                    alphabetCount[alphabetIndex]-= alphabetToRemove.getCount();
                    if(alphabetCount[alphabetIndex]<0){
                        continuable = false;
                        break;
                    }
                }
                if(!continuable) break;
                answer++;
            }
            return answer;
        }
    }
    class AlphabetToRemove{
        char alphabet;
        int count;

        public AlphabetToRemove(char alphabet, int count) {
            this.alphabet = alphabet;
            this.count = count;
        }

        public char getAlphabet() {
            return alphabet;
        }
        public int getCount() {
            return count;
        }
    }

}
