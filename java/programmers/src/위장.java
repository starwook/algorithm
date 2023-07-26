import java.util.*;
public class 위장 {
    class Solution {
        int answer = 1;
        public int solution(String[][] clothes) {
            Map<String,List<String> > map = new LinkedHashMap<>();
            for(int i=0;i<clothes.length;i++){
                List<String> tmpList;
                if(map.containsKey(clothes[i][1])){
                    tmpList = map.get(clothes[i][1]);
                    tmpList.add(clothes[i][0]);
                    map.put(clothes[i][1],tmpList);
                    continue;
                }
                tmpList = new ArrayList<>();
                tmpList.add(clothes[i][0]);
                map.put(clothes[i][1],tmpList);
            }
            for(String key : map.keySet()){
                answer *= (map.get(key).size()+1);
            }
            return answer-1;
        }
        public void bf(int index,List<Integer> sizeOfClothes){
            if(index ==sizeOfClothes.size()){
                answer++;
                return;
            }
            for(int i=0;i<sizeOfClothes.size();i++){
                for(int j=0;j<=sizeOfClothes.get(i);j++){
                    bf(index+1,sizeOfClothes);
                }
            }
        }

    }
}
