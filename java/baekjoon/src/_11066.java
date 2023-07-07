import java.util.*;
public class _11066 {
    public static int[] arr = new int[500];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        while(t>0){
            Arrays.fill(arr,0);
            t--;
            int answer = 0;
            int k = scanner.nextInt();
            scanner.nextLine();
            String number = scanner.nextLine();
            String numbers[] = number.split(" ");
            for(int i=0;i<numbers.length;i++){
                arr[i] = Integer.parseInt(numbers[i]);
            }



        }
    }
}
