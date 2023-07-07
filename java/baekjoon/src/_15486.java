import java.util.*;
public class _15486 {

    public static Reserve[] reserves;
    public static int[][] dayContinue;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        reserves = new Reserve[n+1];
        dayContinue = new int[n+1][2];
        for(int i=1;i<=n;i++){
            String information = scanner.nextLine();
            String[] informations = information.split(" ");
            reserves[i] = new Reserve(Integer.parseInt(informations[0]),Integer.parseInt(informations[1]));
        }
        dayContinue[1][1] = reserves[1].cost;
        for(int today=2;today<=n;today++){

        }
        System.out.print(Math.max(dayContinue[n][0],dayContinue[n][1]));
    }
}
class Reserve{
    public int dayToConsume;
    public int cost;

    public Reserve(int dayToConsume, int cost) {
        this.dayToConsume = dayToConsume;
        this.cost = cost;
    }
}
