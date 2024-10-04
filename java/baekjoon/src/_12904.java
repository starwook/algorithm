import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _12904 {
    public static String S,T;
    public static Set<String> set = new HashSet<>();
    public static Queue<String> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        queue.add(S);
        boolean answer =false;
        while(S.length()<T.length()){
            char lastChar = T.charAt(T.length()-1);
            if(lastChar=='A'){
                T = T.substring(0,T.length()-1);
                if(T.equals(S)) answer =true;
            }
            if(lastChar=='B'){
                T = T.substring(0,T.length()-1);
                T = new StringBuffer(T).reverse().toString();
                if(T.equals(S)) answer =true;
            }
        }
        if(answer) System.out.println(1);
        else System.out.println(0);
    }
}
