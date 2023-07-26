import  java.util.*;
public class _1107 {
    public static int START_NUMBER =100;
    public static int m;
    public static String n;
    public static int lengthOfNumber;
    public static int[] number = new int[10];
    public static int maxValue = 6;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLine();
        m = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<m;i++){
            number[scanner.nextInt()] =1;
        }
        findAllNumber(true,0,100,0);
        System.out.println(answer);
    }
    public static void findAllNumber(boolean first,int index,int nowNumber,int count){
        int diff = Math.abs(nowNumber-Integer.parseInt(n));
        answer = Math.min(answer,count+ diff);
        if(index > maxValue){
            return;
        }
        if(first){
            first =false;
            nowNumber=0;
        }
        for(int i=0;i<10;i++){
            if(number[i] ==0){
                if(nowNumber==0&&i==0&&count>0)continue;
                findAllNumber(first,index+1,nowNumber*10+i,count+1);
            }
        }
    }
}
