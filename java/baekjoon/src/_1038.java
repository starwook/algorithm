import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;

public class _1038 {
    public static int N;
    public static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        getMax("",0,0);

    }
    public static void getMax(String nowNumber,int index,int num){
        for(int i=num;i<=9;i++){
            index++;
            if(index==N){

            }
        }
        String tmp;

    }

}
