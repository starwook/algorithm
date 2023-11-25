import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _2217 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N];

        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope); // 로프의 무게를 오름차순 정렬

        int max = Integer.MIN_VALUE;


        // 특정 로프를 사용할 경우,
        // 그 로프보다 무게가 큰 로프를 모두 사용하는 것이 이득이다.
        // 따라서, 최대 무게 w는 rope[i] * (N - i)와 같다.
        for (int i = 0; i < N; i++) {
            max = Math.max(max, rope[i] * (N - i));
        }

        bw.write(max + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

}