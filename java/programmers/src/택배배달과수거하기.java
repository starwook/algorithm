import java.util.List;

public class 택배배달과수거하기 {
    class Solution {

        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = -1;
            List<Integer> abc;
            int totalDeliveries =0;
            int totalPickUps=0;
            for(int i=0;i<n;i++){
                totalDeliveries+=deliveries[i];
                totalPickUps+=pickups[i];
            }
            int remainPlace =cap;
            int remainPost =cap;
            int toDeliver=0;
            for(int i=n-1;i>=0;i--){
                if(deliveries[i] ==0 && pickups[i]==0)continue;
                //갈떄 //최대한 0으로 맞춰야함
                int cnt=0;
                if(deliveries[i]>cap){ //배달할 것보다 크면
                    deliveries[i]-=cap;
                }
                else{
                    if(toDeliver+deliveries[i]>cap){
                        toDeliver = cap;

                    }
                    toDeliver+=deliveries[i];
                    deliveries[i]=0;
                }
                //올때

            }
            return answer;
        }
    }
}
