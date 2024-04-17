import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _코드트리오마카세 {
    public static int L,Q;
    public static Map<String, Map<Integer,Integer>> table = new HashMap<>();
    public static Map<String, Customer> customers = new HashMap<>();
    public static int customerCount,sushiCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if(type==100){
                sushiCount++;
                int time = Integer.parseInt(st.nextToken());
                int position = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                time = time%L;
                int realPosition = position-time;
                if(realPosition<0) realPosition = L+realPosition;
                if(table.containsKey(name)){
                    Map<Integer,Integer> sushiCount = table.get(name);
                    if(sushiCount.containsKey(realPosition)){
                        sushiCount.put(realPosition,sushiCount.get(realPosition)+1);
                    }
                    else{
                        sushiCount.put(realPosition,1);
                    }
                }
                else{
                    Map<Integer,Integer> sushiCount = new HashMap<>();
                    sushiCount.put(realPosition,1);
                    table.put(name,sushiCount);
                }
            }
            if(type==200){
                customerCount++;
                int time = Integer.parseInt(st.nextToken());
                int position = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                int eatCount = Integer.parseInt(st.nextToken());
                customers.put(name,new Customer(time,position,eatCount));


                Map<Integer,Integer> sushiForCustomer = table.get(name);

            }
            if(type==300){
                int time = Integer.parseInt(st.nextToken());
                for(String customer :  customers.keySet()){
                    Customer nowCustomer = customers.get(customer);
                    Map<Integer,Integer> sushiForCustomer = table.get(customer);
                    int passedTime = time- nowCustomer.time;
                    for(Integer visiblePosition : sushiForCustomer.keySet()){
                        if(passedTime>=L){ //한 바퀴를 돈 상태라면
                            int nowSushiCount = sushiForCustomer.get(visiblePosition);
                            nowCustomer.toEat -= nowSushiCount;
                            sushiForCustomer.put(visiblePosition,0);
                            sushiCount -= nowSushiCount;
                            if(nowCustomer.toEat<=0) {
                                customers.remove(nowCustomer);
                                customerCount--;
                            }
                        }
                        else{
                            System.out.println(visiblePosition +": visiblePosition");
                           int realPosition = (visiblePosition + time)%L;
                           int leftDistance =0;
                            System.out.println(customer+":"+realPosition +" "+ nowCustomer.position);
                           if(nowCustomer.position!=0){
                               leftDistance = L- nowCustomer.position;
                           }
                           int rightDistance = realPosition;
                           if(realPosition> nowCustomer.position){
                               rightDistance = L- realPosition;
                           }
                           int distance = leftDistance+ rightDistance;
                           if(distance>passedTime) continue;

                            int nowSushiCount = sushiForCustomer.get(visiblePosition);
                            nowCustomer.toEat -= nowSushiCount;
                            sushiForCustomer.put(visiblePosition,0);
                            sushiCount -= nowSushiCount;
                            if(nowCustomer.toEat<=0) {
                                customers.remove(nowCustomer);
                                customerCount--;
                            }
                        }


                    }




                }
                System.out.println(customerCount+" "+sushiCount);
            }
        }
    }
    public static class Customer{
        int time;
        int position;
        int toEat;

        public Customer(int time, int position, int toEat) {
            this.time = time;
            this.position = position;
            this.toEat = toEat;
        }
    }


}
