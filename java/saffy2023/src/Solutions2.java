import java.util.*;
class Solution2
{
    public static int n;
    public static int answer =0;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);


        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            List<Car> cars = new ArrayList<>();
            List<CarSell> carSells = new ArrayList<>();
            for(int i=1;i<=n;i++){
                int sell = sc.nextInt();
                int price = sc.nextInt();
                if(sell==1){
                    cars.add(new Car(i,price));
                }
                if(sell ==-1){
                    for(int j=0;j<cars.size();j++){
                        if(cars.get(j).price ==price){
                            carSells.add(new CarSell(cars.get(j).date,i,cars.get(j).price));
                        }
                    }
                }
            }

            find(0,1,null,carSells);
            System.out.println("#" + test_case+" "+answer);
        }

        sc.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
    }
    public static void find(int price,int day,CarSell carSell,List<CarSell> carSells){

        for(int i=0;i<carSells.size();i++){
            if(carSell ==null || carSells.get(i).inDate>carSell.outDate){
                find(price+carSells.get(i).price,carSells.get(i).outDate,carSells.get(i),carSells); //샀을때
                find(price,carSell.outDate,carSell,carSells);
            }
            else{
                if(i==carSells.size()-1){
                    return;
                }
            }
        }

    }
}
class Car{
    public int date;
    public int price;
    Car(int date,int price){
        this.date = date;
        this.price = price;
    }
}
class CarSell{
    public int inDate;
    public int outDate;
    public int price;
    CarSell(int inDate,int outDate,int price){
        this.inDate = inDate;
        this.outDate = outDate;
        this.price = price;
    }
}
