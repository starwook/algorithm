import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _1253 {
    public static int n,answer;
    public static int[] arr;
    public static Set<Integer> numbers = new HashSet<>();
    public static Set<Integer> answers = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            numbers.add(arr[i]);
        }
        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            int left =0;
            int right = n-1;
            while(true){
                if(left==i) left++;
                if(right==i) right--;
//                System.out.println(left+"/"+right);
                if(left>=right) break;
                int sum = arr[left]+arr[right];

                if(sum==arr[i]){
                    answer++;
                    break;
                }
                if(sum>arr[i]){
                    right--;
                }
                if(sum<arr[i]){
                   left++;
                }
            }
        }
        System.out.println(answer);
    }
}
