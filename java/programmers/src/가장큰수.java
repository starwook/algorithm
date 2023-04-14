import java.util.*;
public class 가장큰수 {
    class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            List<Integer> numberList= new ArrayList<>();
            List<String> strList = new ArrayList<>();
            for(int i=0;i<numbers.length;i++){
                strList.add(String.valueOf(numbers[i]));
            }
            strList.sort(new Comparator<String>(){
                @Override
                public int compare(String s1,String s2){
                    return (s2+s1).compareTo(s1+s2);
                }
            });

            for(String string : strList){
                answer +=string;
            }
            if(answer.charAt(0) =='0'){
                return "0";
            }
            return answer;
        }
    }
}
