import java.util.*;
public class _1072 {
    public static long totalGamePlayed, winPlayed;
    public static int originalNumber;
    public static int answer = -1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        totalGamePlayed = scanner.nextInt();
        winPlayed = scanner.nextInt();scanner.nextLine();
        if(totalGamePlayed == winPlayed){
            System.out.println(-1);
            return;
        }
        originalNumber = (int)(winPlayed*100/totalGamePlayed);
        findMinimumBinarySearch();
        System.out.println(answer);
    }
    public static void findMinimumBinarySearch(){
        int start = 0;
        int end = 1000000000;
        float eY = 470000000+19230770;


        while(start<=end){
            int mid = (start+end)/2;
            int number = (int)((mid+winPlayed)*100/(mid+totalGamePlayed));
            if(number!=originalNumber) {
                answer = mid;
                end = mid-1;
                continue;
            }
            start=mid+1;
        }

    }
}
