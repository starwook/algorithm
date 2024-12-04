import java.util.*;

public class mirimiridi0i_0 {
    public static void main(String[] args) {
        mirimiridi0i_0 outer = new mirimiridi0i_0(); // 외부 클래스의 인스턴스 생성
        Solution solution = outer.new Solution(); // 내부 클래스 Solution의 인스턴스 생성

        // 예시 입력 데이터 (시작 시간, 걸리는 시간, 분류 번호, 중요도)
        int[][] jobs = {
                {1, 5, 2, 3},
                {2, 2, 3, 2},
                {3, 1, 3, 3},
                {5, 2, 1, 5},
                {7,1,1,1},
                {9,1,1,1},
                {10,2,2,9}
        };

        // solution 메서드 호출
        int[] result = solution.solution(jobs);

        // 결과 출력
        System.out.println(Arrays.toString(result));
    }

    class Solution {
        PriorityQueue<Job> jobQueue = new PriorityQueue<>();
        final int START_TIME_INDEX =0;
        final int TAKE_TIME_INDEX =1;
        final int NUMBER_INDEX =2;
        final int IMPORTANCE_INDEX =3;
        int[] importance;
        int[] number;
        int[] remainTime;
        final int MAX_NUMBER = 1000000;
        List<Integer> answer = new ArrayList<>();
        boolean finished = false;
        public int[] solution(int[][] jobs) {
            int startTime =0;
            int lastTime = jobs[jobs.length-1][0];
            int jobIndex =0;
            int currentJobIndex =0;
            int currentJobFinishTime =0;
            initiateArr();
            for(int t = startTime;t<=lastTime;t++){
                /*
                 새로운 작업이 들어왔을 때
                 */
                if(jobIndex<jobs.length&&jobs[jobIndex][START_TIME_INDEX]==t){
                    int[] newJob = jobs[jobIndex];
                    remainTime[newJob[NUMBER_INDEX]] += newJob[TAKE_TIME_INDEX];
                    importance[newJob[NUMBER_INDEX]] += newJob[IMPORTANCE_INDEX];
                    /*
                    현재 진행되고 있는 작업이 없을 때
                     */
                    if(currentJobIndex==0){
                        currentJobIndex = newJob[NUMBER_INDEX];
                        currentJobFinishTime = t+newJob[TAKE_TIME_INDEX];
                        reset(currentJobIndex);
                        checkDuplicateAndAdd(currentJobIndex);
                        finished = false;
                    }
                    /*
                    진행되고 있던 작업과 같은 번호일 때
                     */
                    else if(currentJobIndex==newJob[NUMBER_INDEX]){
                        reset(currentJobIndex);
                        currentJobFinishTime+=newJob[TAKE_TIME_INDEX];
                    }
                    jobIndex++;
                }
                /*
                작업이 끝났을 때
                 */
                if(currentJobIndex !=0 && t==currentJobFinishTime){
                    finished = true;
                }
                if(finished){
                    reset(currentJobIndex);
                    currentJobIndex = getNewJobIndex();
                    if(currentJobIndex==0){
                        continue;
                    }
                    currentJobFinishTime = t+remainTime[currentJobIndex];
                    finished = false;
                    answer.add(currentJobIndex);
                }
            }

            processRemainingJobs();
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
        private void reset(int currentJobIndex) {
            importance[currentJobIndex] =0;
            remainTime[currentJobIndex] =0;
        }

        private void makeNewJobQueue() {
            jobQueue = new PriorityQueue<>(
                    (o1, o2) -> {
                        if(o1.importance==o2.importance){
                            return o1.index -o2.index;
                        }
                        return o2.importance-o1.importance;
                    }
            );
            for(int i=1;i<=MAX_NUMBER;i++){
                if(importance[i]==0) continue;
                jobQueue.add(new Job(importance[i],i));
            }
        }

        private void checkDuplicateAndAdd(int currentJobIndex) {
            if(answer.isEmpty()){
                answer.add(currentJobIndex);
            }
            else{
                if(answer.get(answer.size()-1)!= currentJobIndex){
                    answer.add(currentJobIndex);
                }
            }
        }
        private void initiateArr() {
            importance = new int[MAX_NUMBER+1];
            number = new int[MAX_NUMBER+1];
            remainTime = new int[MAX_NUMBER+1];
        }
        /*
            추가 진입될 작업은 없지만 남아있는 작업들이 있을때
          */
        private void processRemainingJobs() {
            makeNewJobQueue();
            while(!jobQueue.isEmpty()){
                Job job = jobQueue.poll();
                checkDuplicateAndAdd(job.index);
            }
        }
        private int getNewJobIndex() {
            int currentJobIndex =0;
            makeNewJobQueue();
            if(!jobQueue.isEmpty()){
                currentJobIndex = jobQueue.poll().index;
            }
            return currentJobIndex;
        }

        class Job{
            int importance;
            int index;

            public Job(int importance, int index) {
                this.importance = importance;
                this.index = index;
            }
        }
    }
}
