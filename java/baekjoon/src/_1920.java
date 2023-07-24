import java.util.*;
public class _1920 {
    public static int N,M;
    public static Integer[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); scanner.nextLine();
        String numbers = scanner.nextLine();
        String[] number = numbers.split(" ");
        M= scanner.nextInt();scanner.nextLine();
        String toFindNumbers = scanner.nextLine();
        String[] toFindNumber = toFindNumbers.split(" ");
        arr = Arrays.stream(number)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        Arrays.sort(arr);
        for(int i=0;i<M;i++){
            Integer toFind = Integer.parseInt(toFindNumber[i]);
            if(findNumberBinary(toFind)) System.out.println(1);
            else System.out.println(0);
        }
    }
    public static boolean findNumberBinary(Integer number){
        int start =0;
        int end = arr.length-1;

        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]<number){
                start= mid+1;
            }
            else if(arr[mid]>number){
                end = mid-1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
