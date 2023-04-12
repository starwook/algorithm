
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t =in.nextInt();
        for(int i=0;i<t;i++){
            int x1= in.nextInt();
            int y1 = in.nextInt();
            int r1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int r2 = in.nextInt();
            System.out.println(getDisTance(x1, y1, x2, y2,r1,r2));
        }


    }

    private static int getDisTance(int x1, int y1, int x2, int y2,int r1,int r2) {
        int distance = (int) Math.pow(x2 - x1,2) +(int) Math.pow(y2 - y1,2);
        if(x1==x2 && y1==y2){ //중점이 같을떄
            if(r1==r2){ //하지만 거리가 다를때
                return -1;
            }
        }
        if(distance<Math.pow(r2-r1,2)){
            return 0;
        }
        if(distance >Math.pow(r1+r2,2)){ //서로 너무 멀떄
            return 0;
        }
        if(distance==Math.pow(r2-r1,2)){ //내점할 때
            return 1;
        }
        if(distance==Math.pow(r2+r1,2)){
            return 1;
        }
        return 2;

    }
}
