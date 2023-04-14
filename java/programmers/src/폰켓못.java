import java.util.*;
public class 폰켓못 {
    class Solution {
        public int solution(int[] nums) {
            Set<Integer> pokemons = new LinkedHashSet<>();
            List<Integer> a =new ArrayList<>();
            int manNum = nums.length/2;
            Map<String,String> map = new LinkedHashMap<>();
            for(int i=0;i<nums.length;i++){
                if(pokemons.size()==manNum){
                    break;
                }
                pokemons.add(nums[i]);

            }
            int answer = pokemons.size();
            return answer;
        }
    }

}
