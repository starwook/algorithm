import java.util.Arrays;

public class PCCP_02 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] diff1 ={1,5,3};
        int[] times1={2,4,7};
        solution.solution(diff1,times1,30);
    }
    static class Solution {
        public int solution(int[] diffs, int[] times, long limit) {
            int currentLevel =0;
            int minLevel =1;
            int maxLevel =100000;
            while(minLevel<maxLevel){
                currentLevel = (minLevel+maxLevel)/2;
                System.out.println(currentLevel);
                if(canFinish(currentLevel,limit,diffs,times)){
                    maxLevel = currentLevel;
                }
                else{
                    minLevel = currentLevel+1;
                }
            }
            return minLevel;
        }

        public boolean canFinish(int level, long limit,int[] diffs,int[] times){
            long time =0L;

            for(int i=0;i<times.length;i++){
                int currentDiff = diffs[i];
                int currentTime = times[i];
                time += currentTime;
                if(currentDiff>level){
                    int interval = currentDiff-level;
                    int prevTime;
                    if(i==0) prevTime=0;
                    else prevTime=times[i-1];
                    time += ((long) interval *(currentTime+prevTime));
                }
                if(time>limit){
                    return false;
                }
            }
            return true;
        }
    }

}
