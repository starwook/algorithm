import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class 개인정보_수집_유효기간 {
     class Solution {
         List<Integer> answer = new ArrayList<>();
         HashMap<String,Integer> termMap = new LinkedHashMap<>();
         public int[] solution(String today, String[] terms, String[] privacies) {
             int todayTotal = getDate(today);
             for(int i=0;i<terms.length;i++){
                 String[] tmpTerms = terms[i].split(" ");
                 termMap.put(tmpTerms[0],Integer.parseInt(tmpTerms[1]));
             }
             for(int i=0;i<privacies.length;i++){
                 String[] tmpDate = privacies[i].split(" ");
                 if(getDate(tmpDate[0])+termMap.get(tmpDate[1])*28<=todayTotal){
                     answer.add(i+1);
                 }
             }

             return answer.stream().mapToInt(integer->integer).toArray();
         }

         private int getDate(String today) {
             String[] todayArr = today.split("\\.");
             int thisYear = Integer.parseInt(todayArr[0]);
             int thisMonth = Integer.parseInt(todayArr[1]);
             int thisDay = Integer.parseInt(todayArr[2]);
             return thisYear*12*28+ thisMonth*28+thisDay;
         }

     }
}
