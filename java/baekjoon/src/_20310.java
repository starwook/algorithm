import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        int[] count = new int[2];
        for(int i =0;i<st.length();i++){
            count[st.charAt(i)-'0']++;
        }

        int zeroCountToDelete = count[0]/2;
        int oneCountToDelete = count[1]/2;

        int zeroCount =0;
        int oneCount =count[1]/2;

        List<Character> answer = new ArrayList<>();

        for(int i=0;i<st.length();i++){
            if(st.charAt(i)=='0'){
                if(zeroCountToDelete>zeroCount){
                    answer.add('0');
                }
                zeroCount++;
            }
            else{
                if(oneCount>oneCountToDelete) answer.add('1');
                oneCount++;
            }
        }

        for(char c : answer){
            System.out.print(c);
        }


    }
}
