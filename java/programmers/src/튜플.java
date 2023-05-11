import java.util.*;
public class 튜플 {
    class Solution {
        public int[] solution(String s) {
            Set<Integer> numbers = new LinkedHashSet<>();
            Set<List<Integer> > originalNumbers = new LinkedHashSet<>();
            List<String[]> numbersSplit = new ArrayList<>();
            String tmpStr = s.substring(1,s.length()-1);
            for(int i=0;i<tmpStr.length();i++){
                if(tmpStr.charAt(i) =='{') {
                    int firstOpenIndex = i+1;
                    while(tmpStr.charAt(i) != '}'){
                        i++;
                    }
                    String[] tmpStrings = tmpStr.substring(firstOpenIndex,i).split(",");
                    numbersSplit.add(tmpStrings);
                }
            }
            Collections.sort(numbersSplit, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return o1.length-o2.length;
                }
            });
            for(int i=0;i<numbersSplit.size();i++){
                for(int j=0;j<numbersSplit.get(i).length;j++){
                    numbers.add(Integer.parseInt(numbersSplit.get(i)[j]));
                }
            }



            return numbers.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
