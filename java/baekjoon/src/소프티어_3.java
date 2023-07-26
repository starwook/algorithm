import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
class Car{
    String name;
    boolean out;
    String type;
    int Cnt;
    Date start;
    Date end;
    public Car(String name, boolean out, String type, int cnt, Date start, Date end) {
        this.name = name;
        this.out = out;
        this.type = type;
        Cnt = cnt;
        this.start = start;
        this.end = end;
    }

}

class 소프티어_3 {
    public static List<Car> cars = new ArrayList<>();
    public static SimpleDateFormat formatter =  new SimpleDateFormat("yyyyMM");

    public static void solution(String param0, int param1) throws ParseException {
        String answer ="";
        cars.add(new Car("Tuscani",true,"Coupe",2,formatter.parse("200109"),formatter.parse("200810")));
        cars.add(new Car("Pony",true,"Sedan",5,formatter.parse("197512"),formatter.parse("198201")));
        cars.add(new Car("Elantra",true,"Sedan",5,formatter.parse("199010"),formatter.parse("199512")));
        cars.add(new Car("Grandeur",false,"Sedan",5,formatter.parse("198607"),formatter.parse("202305")));
        cars.add(new Car("Porter",true,"Truck",3,formatter.parse("197702"),formatter.parse("200405")));
        cars.add(new Car("Cortina",true,"Sedan",5,formatter.parse("196801"),formatter.parse("198004")));
        cars.add(new Car("Equus",true,"Sedan",5,formatter.parse("199904"),formatter.parse("200912")));
        cars.add(new Car("Universe",false,"Bus",45,formatter.parse("200612"),formatter.parse("202305")));
        cars.add(new Car("Aerotown",false,"Bus",30,formatter.parse("199406"),formatter.parse("202305")));
        cars.add(new Car("Santafe",false,"RV",7,formatter.parse("200006"),formatter.parse("200305")));
        Collections.sort(cars, (o1, o2) -> o1.name.compareTo(o2.name));
        Date findDate = formatter.parse(param0);
        for(int i=0;i<cars.size();i++){
            if(cars.get(i).Cnt>= param1 && cars.get(i).start.compareTo(findDate)<=0 && cars.get(i).end.compareTo(findDate)>=0){
                if(answer!="") answer+=",";
                answer +=cars.get(i).name;
                if(cars.get(i).out) answer+= "*";
                answer +="(";
                answer +=cars.get(i).type;
                answer +=")";
            }
        }
        if(answer.equals("")){
            return;
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] tmpString = input.split(",");
        if(tmpString[1].charAt(0) ==' '){
            tmpString[1] = tmpString[1].substring(1);
        }
        solution(tmpString[0],Integer.parseInt(tmpString[1]));
    }
}
