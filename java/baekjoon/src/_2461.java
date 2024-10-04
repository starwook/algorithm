import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2461 {
    public static int studentPerClassCount;
    public static int classCount;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        classCount = Integer.parseInt(st.nextToken());
        studentPerClassCount = Integer.parseInt(st.nextToken());
        arr = new int[classCount][studentPerClassCount];
        for(int i=0;i<classCount;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<studentPerClassCount;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr[i]);
        }


    }
}
