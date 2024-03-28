import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class 주차요금계산 {
    class Solution {
        public Map<String,Car> recordMaps = new HashMap<>();
        public List<Car> answers = new ArrayList<>();
        public int[] globalFee;
        public int[] solution(int[] fees, String[] records) throws ParseException {

            globalFee = fees.clone();
            for(int i=0;i<records.length;i++){
                String[] information = records[i].split(" ");
                if(information[2].equals("IN")){
                    if(recordMaps.containsKey(information[1])){
                        Car car = recordMaps.get(information[1]);
                        car.intTime = changeIntoDate(information[0]);
                        car.isOut = false;
                    }
                    else {
                        recordMaps.put(information[1],new Car(changeIntoDate(information[0]),0,0L));
                    }
                }
                else{
                    Date outTime = changeIntoDate(information[0]);
                    Car car  = recordMaps.get(information[1]);
                    addTime(outTime,car);
                }
            }
            for(String key : recordMaps.keySet()){
                Car car = recordMaps.get(key);
                if(!car.isOut){
                    addTime(changeIntoDate("23:59"),car);
                    car.isOut = true;
                }
                calculateFee(car);
            }
            
            List<String> keySet = new ArrayList<>(recordMaps.keySet());
            Collections.sort(keySet);
            int[] answer = new int[keySet.size()];
            for(int i=0;i<answer.length;i++) answer[i] =  recordMaps.get(keySet.get(i)).fee.intValue();
            return answer;
        }
        public void addTime(Date outTime,Car car){
            car.times += (outTime.getTime()-car.intTime.getTime());
            car.isOut = true;
        }

        public void calculateFee(Car car) throws ParseException {
            Long diff = car.times;

            diff/=60000;
            System.out.println(diff);
            if(diff<=globalFee[0]) car.fee = Long.valueOf(globalFee[1]);
            else {
                diff-=globalFee[0];

                long fee = globalFee[1]+(diff/globalFee[2]) * globalFee[3];
                if(diff%globalFee[2]!= 0) fee+= globalFee[3];
                car.fee=  fee;
            }
        }
        public Date changeIntoDate(String time) throws ParseException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Date date = dateFormat.parse(time);
            return date;
        }
    }
    class Car{
        Date intTime;
        Long times;
        Long fee;
        boolean isOut = false;
        Car(Date intTime, long fee,Long times) {
            this.intTime = intTime;
            this.fee = fee;
            this.times = times;
        }
    }
}
