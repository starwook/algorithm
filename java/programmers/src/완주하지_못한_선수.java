import java.util.*;
public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> allRunner = new ArrayList<>();
        Map<String,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<participant.length;i++){
            if(map.containsKey(participant[i])){
                map.put(participant[i],map.get(participant[i])+1);
                continue;
            }
            map.put(participant[i],1);
        }
        for(int i=0;i<completion.length;i++){
            map.put(completion[i],map.get(completion[i])-1);
        }
        for(String str : map.keySet()){
            if(map.get(str) !=0){
                return str;
            }
        }

        return answer;
    }
}
