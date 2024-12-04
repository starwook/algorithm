//import java.util.*;
//
//public class miridi_00 {
//    public static void main(String[] args) {
//        miridi_0 outer = new miridi_0(); // 외부 클래스의 인스턴스 생성
//        Solution solution = new Solution(); // 내부 클래스 Solution의 인스턴스 생성
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
//        final int MAX_NUMBER = 100;
//        List<Integer> answer = new ArrayList<>();
//        boolean finished = false;
//        public int[] solution(int[][] jobs) {
//            int startTime =0;
//            int lastTime = 1000000;
//            int jobIndex =0;
//            int currentJobIndex =0;
//            int currentJobFinishTime =0;
//            initiateArr();
//            for(int t = startTime;t<=lastTime;t++){
//                if(jobIndex==jobs.length) break;
//                System.out.println("time="+t+",currentIndex="+currentJobIndex);
//                if(jobs[jobIndex][START_TIME_INDEX]==t){ // 요청 시각에 새로운 작업이 들어왔을 때
//                    int[] newJob = jobs[jobIndex];
//                    remainTime[newJob[NUMBER_INDEX]] += newJob[TAKE_TIME_INDEX];
//                    importance[newJob[NUMBER_INDEX]] += newJob[IMPORTANCE_INDEX];
//                    System.out.println(Arrays.toString(newJob));
//                    if(currentJobIndex==0){ //현재 진행되고 있는 작업이 없을 때
//                        currentJobIndex = newJob[NUMBER_INDEX];
//                        currentJobFinishTime = t+newJob[TAKE_TIME_INDEX];
//                        answer.add(currentJobIndex);
//                        finished = false;
//                        System.out.println("new Index:"+currentJobIndex+"/finishTime:"+currentJobFinishTime);
//                    }
//                    else if(currentJobIndex==newJob[NUMBER_INDEX]){
//                        currentJobFinishTime+=newJob[TAKE_TIME_INDEX];
//                    }
//                    jobIndex++;
//                }
//                if(currentJobIndex !=0 && t==currentJobFinishTime){
//                    finished = true;
//                }
//                if(finished){ //방금 작업이 끝났다면
//                    importance[currentJobIndex] =0;
//                    remainTime[currentJobIndex] =0;
//                    currentJobIndex = getNewJobIndex();
//                    currentJobFinishTime = t+remainTime[currentJobIndex];
//                    finished = false;
//                }
//            }
//            return answer.stream().mapToInt(Integer::intValue).toArray();
//        }
//
//        private void initiateArr() {
//            importance = new int[MAX_NUMBER+1];
//            number = new int[MAX_NUMBER+1];
//            remainTime = new int[MAX_NUMBER+1];
//        }
//
//        private int getNewJobIndex() {
//            int currentJobIndex;
//            jobQueue = new PriorityQueue<>(
//                    (o1, o2) -> {
//                        if(o1.importance==o2.importance){
//                            return o1.number-o2.number;
//                        }
//                        return o2.importance-o1.importance;
//                    }
//            );
//            for(int i=1;i<=MAX_NUMBER;i++){
//                jobQueue.add(new Job(importance[i],i));
//            }
//
//            currentJobIndex = jobQueue.poll().number;
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
