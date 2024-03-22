import java.util.*;
public class 신고결과받기 {

    class Solution {
        public Map<String,List<String>> reported = new HashMap<>();
        public Map<String,Integer> reportedCount = new HashMap<>();
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            for(int i=0;i<id_list.length;i++){
                reported.put(id_list[i],new ArrayList<>());
                reportedCount.put(id_list[i],0);
            }
            for(int i=0;i<report.length;i++){
                String[] inform = report[i].split(" ");
                String user = inform[0];
                String reportedUser = inform[1];
                List<String> whoReportMe = reported.get(reportedUser);
                if(whoReportMe.contains(user)) continue;
                whoReportMe.add(user);
                reported.put(reportedUser,whoReportMe);
            }
            for(int i=0;i<id_list.length;i++){
                List<String> whoReportMe = reported.get(id_list[i]);
                if(whoReportMe.size()>=k){
                    for(int j=0;j<whoReportMe.size();j++){
                        reportedCount.put(whoReportMe.get(j),
                                reportedCount.get(whoReportMe.get(j))+1);
                    }
                }
            }
            for(int i=0;i<id_list.length;i++){
                answer[i] =  reportedCount.get(id_list[i]);
            }
            return answer;
        }
    }
}
