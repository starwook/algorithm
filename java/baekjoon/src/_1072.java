import java.util.*;
public class _1072 {
    public static float X,Y;
    public static int originalNumber;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        X = scanner.nextInt();
        Y = scanner.nextInt();scanner.nextLine();
        if(X==Y){
            System.out.println(-1);
            return;
        }
        originalNumber = (int)((Y/X)*100);
        System.out.println(findMinimumBinarySearch());
    }
    public static int findMinimumBinarySearch(){
        float start = Y;
        float end = X;
        int mid = (int)(start+end)/2;
        int toBeNumber = originalNumber+1;
        while(start<=end){
            int number = (int)((mid/X)*100);
            if(number==toBeNumber) return (int)(mid-Y);
            if(number<toBeNumber) end = mid-1;
            if(number>toBeNumber) start = end+1;
        }
        return -1;
    }
}
