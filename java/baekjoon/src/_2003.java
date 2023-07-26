import java.util.*;
public class _2003 {
    public static int N,M;
    public static int start,end,sum,answer;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M= scanner.nextInt();scanner.nextLine();
        String number = scanner.nextLine();
        Integer[] numberArr = Arrays.stream(number.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        sum+=numberArr[0];
        while(end<N&&start<N){
            if(sum<M){
                end++;
                if(end>=N) break;
                sum+=numberArr[end];
            }
            if(sum==M){
                answer++;
                sum-=numberArr[start];
                start++;
            }
            if (sum > M) {
                sum-=numberArr[start];
                start++;
            }
        }
        System.out.println(answer);

    }
}
