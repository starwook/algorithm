import java.util.*;
public class 모음사전 {
    class Solution {
        Set<String> set = new LinkedHashSet<>();
        char[] chars = {'A','E','I','O','U'};
        public int solution(String word) {
            Queue<Integer> queue = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();

            bf(0,"");
            List<String> newList = new ArrayList<>();
            for(String str : set){
                newList.add(str);
            }
            newList.sort(new Comparator<String>(){
                @Override
                public int compare(String s1,String s2){
                    return s1.compareTo(s2);
                }
            });
            System.out.println(set);
            int i=1;
            int answer = 0;
            for(String str : set){
                if(str.equals(word)){
                    answer = i;
                    break;
                }
                i++;
            }
            return answer;
        }
        public void bf(int index,String tmpString){
            if(!tmpString.equals(""))set.add(tmpString);
            if(index==5){
                return;
            }
            for(int i=0;i<5;i++){
                bf(index+1,tmpString+chars[i]);
            }

        }
    }
}
