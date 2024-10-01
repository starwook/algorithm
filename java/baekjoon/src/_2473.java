import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _2473 {
    public static int N;
    public static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int frontIndex = 0;
        int backIndex = N - 1;
        int thirdIndex = 0;

        List<Long> answer = new ArrayList<>();
        long maxDistance = 3000000000L;

        while (frontIndex + 1 < backIndex) {
            long front = arr[frontIndex];
            long back = arr[backIndex];

            for (int i = frontIndex + 1; i < backIndex; i++) {
                long tempDistance = front + back + arr[i];
                tempDistance = Math.abs(tempDistance);
                if (tempDistance < maxDistance) {
                    answer = new ArrayList<>();
                    answer.add(front);
                    answer.add(arr[i]);
                    answer.add(back);
                    maxDistance = tempDistance;
                }
            }
            if (front + back < 0) {
                frontIndex++;
            } else {
                backIndex--;
            }
        }
        answer.sort(Long::compare);
        for (Long l : answer) {
            System.out.print(l + " ");
        }
    }
}
