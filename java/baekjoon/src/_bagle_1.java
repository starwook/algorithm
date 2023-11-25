import java.util.*;

public class _bagle_1 {
    public static void main(String[] args) {
        int[] times = {8,7,6,3,4};
        System.out.println(solution(times,4));

    }
    public  static Wheel[] wheels;
    public static boolean[] full;
    public static int solution(int[] times, int n){
        int answer =0;
        int time =0,index=0;
        wheels = new Wheel[n];
        full = new boolean[n];
        for(index=0;index<times.length &&index<n;index++){
            wheels[index] = new Wheel(time,times[index]);
            full[index] =true;
            time++;
        }
        int finishCount =0;
        while(true){
            time++;
            int tmpIndex = time%n;
            System.out.println(tmpIndex);
            if(!full[tmpIndex]) continue;
            Wheel nowWheel = wheels[tmpIndex];
            nowWheel.remainTime -= n;
            if(nowWheel.remainTime<=0) {
                finishCount++;
                if(index<times.length){
                    wheels[tmpIndex] = new Wheel(time%n,times[index]);
                    index++;
                }
                else{
                    full[tmpIndex] = false;
                }
            }
            if(finishCount== times.length) break;
        }
        return time--;
    }
    public static class Wheel{
        int index;
        int remainTime;

        public Wheel(int index, int remainTime) {
            this.index = index;
            this.remainTime = remainTime;
        }
    }
}
class bagle_2{
    public int answer;
    public int[][] remainBattery;
    public int solution(int[] weather,int capacity){
        remainBattery = new int[weather.length][2];
        if(weather[0] ==1) return 0;
        else remainBattery[0][0] =1;
        //발전기 동작 = 0, 비동작 =1
        for(int i=1;i<weather.length;i++){
            if(weather[i]==1){
                if(remainBattery[i-1][0]<=0 &&remainBattery[i-1][1]<=0){
                    break;
                }
                remainBattery[i][1] = Math.max(remainBattery[i-1][0],remainBattery[i-1][1])-1;
            }
            else{
                if(weather[i-1]==1) remainBattery[i][0] =0; //전날 흐린날
                else{
                    remainBattery[i][0] =  Math.max(0,remainBattery[i-1][0]);
                }
                remainBattery[i][0]++;
                if(remainBattery[i][0]>capacity) remainBattery[i][0] = capacity;
                remainBattery[i][1]--;
            }
            answer++;
        }
        return answer;
    }
}
class bagle_3{

    public String realPhoneNumber;
    public Set<String> numbers = new HashSet<>();
    public int answer;
    public int solution(String phone_number,String birthday){
        realPhoneNumber = phone_number.substring(5);
        makeAllStr(0,"",realPhoneNumber,0);
        makeAllStr(0,"",birthday,0);
        makeAllNumber(0,"");


        return answer;
    }
    public void makeAllNumber(int index,String str){
        if(index==4){
            if(!checkDuplicate(str)) return;
            if(numbers.contains(str)) return;
            answer++;
            return;
        }
        for(int i=0;i<=9;i++){
            makeAllNumber(index+1,str+i);
        }
    }
    public boolean checkDuplicate(String str){
        int[] count = new int[10];
        for(int i=0;i<str.length();i++){
            count[str.charAt(i)-'0']++;
            if(count[str.charAt(i)-'0']>=3) return false;
        }
        return true;
    }
    public void makeAllStr(int index, String str,String originalStr,int strLength){
        if(strLength==4){
            numbers.add(str);
            return;
        }
        for(int i=index;i<originalStr.length();i++){
            makeAllStr(i+1,str+originalStr.charAt(i),originalStr,strLength+1);
        }
    }
}