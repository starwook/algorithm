import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1092 {
    public static int crainCount,boxCount;
    public static int[] crains,boxes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        crainCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<crainCount;i++)crains[i] = Integer.parseInt(st.nextToken());
        boxCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<boxCount;i++)boxes[i] = Integer.parseInt(st.nextToken());


    }
}
