import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dx_2024_2 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int test_case =1;test_case<=t;test_case++){
            int n = Integer.parseInt(br.readLine());
            int answer =0;
            for(int i=0;i<n;i++){
                if(n<3){
                    answer =-1;
                    break;
                }
                StringTokenizer st = new StringTokenizer(br.readLine());
                int total= 0;
                for(int j =0;j<3;j++){

                }
            }
            System.out.println("#"+test_case+" "+answer);
        }

    }
}
