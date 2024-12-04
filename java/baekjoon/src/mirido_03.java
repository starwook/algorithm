//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.PriorityQueue;
//
//public class mirido_03 {
//}
//import java.util.*;
//
//public class miridi_0 {
//    public static void main(String[] args) {
//        mirimiridi0i_0 outer = new mirimiridi0i_0(); // 외부 클래스의 인스턴스 생성
//        Solution solution = outer.new Solution(); // 내부 클래스 Solution의 인스턴스 생성
//
//        // 예시 입력 데이터 (시작 시간, 걸리는 시간, 분류 번호, 중요도)
//        int[][] jobs = {
//                {1, 5, 2, 3},
//                {2, 2, 3, 2},
//                {3, 1, 3, 3},
//                {5, 2, 1, 5},
//                {7,1,1,1},
//                {9,1,1,1},
//                {10,2,2,9}
//        };
//
//        // solution 메서드 호출
//        int[] result = solution.solution(jobs);
//
//        // 결과 출력
//        System.out.println(Arrays.toString(result));
//    }
//
//    class Solution {
//        PriorityQueue<Job> jobQueue = new PriorityQueue<>();
//        final int START_TIME_INDEX =0;
//        final int TAKE_TIME_INDEX =1;
//        final int NUMBER_INDEX =2;
//        final int IMPORTANCE_INDEX =3;
//        int[] importance;
//        int[] number;
//        int[] remainTime;
//        final int MAX_NUMBER = 10000000;
//        List<Integer> answer = new ArrayList<>();
//        boolean finished = false;
//        public int[] solution(int[][] jobs) {
//            int startTime =0;
//            int lastTime = 20;
//            int jobIndex =0;
//            int currentJobIndex =0;
//            int currentJobFinishTime =0;
//            initiateArr();
//            int time =0;
//
//            for(int i=0;i<jobs.length;i++){
//                int[] newJob = jobs[jobIndex];
//                remainTime[newJob[NUMBER_INDEX]] += newJob[TAKE_TIME_INDEX];
//                importance[newJob[NUMBER_INDEX]] += newJob[IMPORTANCE_INDEX];
//                System.out.println(Arrays.toString(newJob));
//                if(currentJobIndex==0){ //현재 진행되고 있는 작업이 없을 때
//                    currentJobIndex = newJob[NUMBER_INDEX];
//                    currentJobFinishTime = time+newJob[TAKE_TIME_INDEX];
//                    addToAnswerCheckDuplicate(currentJobIndex);
//                    finished = false;
//                    System.out.println("new Index:"+currentJobIndex+"/finishTime:"+currentJobFinishTime);
//                }
//                else if(currentJobIndex==newJob[NUMBER_INDEX]) {
//                    if(newJob[START_TIME_INDEX]<=currentJobFinishTime){ //작업 번호가 같으며 끝나기전에 추가된다면
//                        currentJobFinishTime+=newJob[TAKE_TIME_INDEX];
//                    }
//                }
//                else if(currentJobIndex!=newJob[NUMBER_INDEX]) {
//                    if(newJob[START_TIME_INDEX]>=)
//                }
//            }
//            for(int t = startTime;t<=lastTime;t++){
//                System.out.println("time="+t+",currentIndex="+currentJobIndex);
//                if(jobIndex<jobs.length&&jobs[jobIndex][START_TIME_INDEX]==t){ // 요청 시각에 새로운 작업이 들어왔을 때
//                    jobIndex++;
//                }
//                if(currentJobIndex !=0 && t==currentJobFinishTime){
//                    System.out.println("finished");
//                    finished = true;
//                }
//                if(finished){ //방금 작업이 끝났다면
//                    importance[currentJobIndex] =0;
//                    remainTime[currentJobIndex] =0;
//                    currentJobIndex = getNewJobIndex();
//                    if(currentJobIndex==0){
//                        continue;
//                    }
//                    currentJobFinishTime = t+remainTime[currentJobIndex];
//                    finished = false;
//                    answer.add(currentJobIndex);
//                }
//            }
//            return answer.stream().mapToInt(Integer::intValue).toArray();
//        }
//
//        private void addToAnswerCheckDuplicate(int currentJobIndex) {
//            if(answer.isEmpty()){
//                answer.add(currentJobIndex);
//            }
//            else{
//                if(answer.get(answer.size()-1)!= currentJobIndex){
//                    answer.add(currentJobIndex);
//                }
//            }
//        }
//
//        private void initiateArr() {
//            importance = new int[MAX_NUMBER+1];
//            number = new int[MAX_NUMBER+1];
//            remainTime = new int[MAX_NUMBER+1];
//        }
//
//        private int getNewJobIndex() {
//            int currentJobIndex =0;
//            jobQueue = new PriorityQueue<>(
//                    (o1, o2) -> {
//                        if(o1.importance==o2.importance){
//                            return o1.number-o2.number;
//                        }
//                        return o2.importance-o1.importance;
//                    }
//            );
//            for(int i=1;i<=MAX_NUMBER;i++){
//                if(importance[i]==0) continue;
//                jobQueue.add(new Job(importance[i],i));
//            }
//            if(!jobQueue.isEmpty()){
//                currentJobIndex = jobQueue.poll().number;
//            }
//            return currentJobIndex;
//        }
//
//        class Job{
//            int importance;
//            int number;
//
//            public Job(int importance, int number) {
//                this.importance = importance;
//                this.number = number;
//            }
//        }
//    }
//
//
//}
