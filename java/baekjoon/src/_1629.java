import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1629 {
    public static int A,B,C;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(getByRepeat(A,B,C));

    }
    public static long divAndConquer(long base, long multipleCount,long mod){
        long answer = 1;
        long tempBase = base;
        while(multipleCount > 0){
            if(multipleCount%2==1){
                answer = (answer* tempBase)%mod;
            }
            tempBase = tempBase*tempBase%mod;
            multipleCount /= 2;
        }
        return answer;
    }

    public static long getByRepeat(long base,int multipleCount,long mod){
        if(multipleCount==1) return A%mod;
        base = getByRepeat(base,multipleCount/2,mod)%mod;
        base = base*base%mod;
        if(multipleCount%2==1) {
            base *= A;
        }
        return base%mod;
    }

    public static int divAndConquer2(int base, int multipleCount, int mod) {
        long answer = 1;
        long longBase = base;
        while (multipleCount > 0) {
            if (multipleCount % 2 == 1) {
                answer = (answer * longBase) % mod;
            }
            longBase = (longBase * longBase) % mod;
            multipleCount /= 2;
        }
        return (int) answer;
    }


}
