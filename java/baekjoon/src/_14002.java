import java.util.*;
public class _14002 {
    public static int n;
    public static int[] numbers;
    public static Stack<Integer> stack;
    public static int[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        String tmp = scanner.nextLine();
        String[] number = tmp.split(" ");
        numbers = new int[n];
        dp = new int[n];
        for(int i=0;i<n;i++){
            numbers[i] = Integer.parseInt(number[i]);
        }
        dp[0] = numbers[0];
        for(int i=1;i<n;i++){

        }




    }
}
