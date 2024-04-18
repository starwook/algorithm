import java.util.List;

public class 택배배달과수거하기 {
    class Solution {

        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;
            int deliveryIndex=n-1;
            int pickupIndex = n-1;
            while(deliveryIndex>=0||pickupIndex>=0){
                int tmpDeliveryCap =0;
                int tmpPickupCap =0;
                int maxDeliveryIndex =-1;
                int maxPickUpIndex =-1;
                while(true){
                    if(deliveryIndex<0){
                        break;
                    }
                    if(deliveries[deliveryIndex]==0){
                        deliveryIndex--;
                        continue;
                    }
                    if(tmpDeliveryCap ==cap) break;
                    if(deliveries[deliveryIndex]>0){
                        maxDeliveryIndex = Math.max(maxDeliveryIndex,deliveryIndex);
                        if(tmpDeliveryCap+deliveries[deliveryIndex]>cap){ //다 못 가져간다면
                            deliveries[deliveryIndex] -=(cap-tmpDeliveryCap);
                            break;
                        }
                        else{ //초과하지 않는다면
                            tmpDeliveryCap +=deliveries[deliveryIndex];
                            deliveries[deliveryIndex] =0;
                            deliveryIndex--;
                        }
                    }
                }
                while(true){
                    if(pickupIndex<0){
                        break;
                    }
                    if(pickups[pickupIndex]==0){
                        pickupIndex--;
                        continue;
                    }
                    if(tmpPickupCap ==cap) break;
                    if(pickups[pickupIndex]>0){
                        maxPickUpIndex = Math.max(maxPickUpIndex,pickupIndex);
                        if(tmpPickupCap+ pickups[pickupIndex]>cap){ //다 못 가져간다면
                            pickups[pickupIndex] -=(cap-tmpPickupCap);
                            break;
                        }
                        else{ //초과하지 않는다면
                            tmpPickupCap +=pickups[pickupIndex];
                            pickups[pickupIndex] =0;
                            pickupIndex--;
                        }
                    }
                }
                answer +=(Math.max(maxPickUpIndex+1,maxDeliveryIndex+1)*2);
            }

            return answer;
        }
    }
}
