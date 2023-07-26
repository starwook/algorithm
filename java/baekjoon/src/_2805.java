import java.util.*;
public class _2805 {
    public static int N,M;
    public static Integer[] numbers;
    public static int result;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();scanner.nextLine();
        String number = scanner.nextLine();

        numbers = Arrays.stream(number.split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
        int maxHeight =0;
        for(int i=0;i<numbers.length;i++) maxHeight = Math.max(maxHeight,numbers[i]);

        int start =0;
        int end = maxHeight;

        while(start<=end){
            int mid = (start+end)/2;
            long totalTree= getAllTree(mid);
            if(totalTree==M){
                System.out.println(mid);
                return;
            }
            if(totalTree<M){ //아직 덜 잘랐을떄 -> 더 밑을 잘라야함
                end = mid-1;
            }
            if(totalTree>M){ //더 잘랐을 때 -> 더 위를 잘라야함
                result = Math.max(result,mid);
                start = mid+1;
            }
        }
        System.out.println(result);
    }
    public static long getAllTree(int height){
        long count =0;
        for(int i=0;i<N;i++){
            if(numbers[i]-height>0) count+=(numbers[i]-height);
        }
        return count;
    }
}
