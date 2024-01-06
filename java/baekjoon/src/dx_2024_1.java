import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class dx_2024_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] rowArr = new int[10001];
        int rowIndex =1;
        int index=1;
        while(index<=10000) {
            for (int j = 0; j < rowIndex; j++) {
                if(index==10000) break;
                rowArr[index] = rowIndex;
                index++;

            }
            if(index==10000) break;
            rowIndex++;
        }
        for(int i=1;i<=1000;i++) System.out.println(rowArr[i]);
        for(int test_case =1;test_case<=t;test_case++){

        }

    }
}
