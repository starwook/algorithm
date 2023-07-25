import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _2143 {
    public static int N,M;
    public static long T;
    public static long answer;
    public static int[] A,B;
    public static List<Long> numberA = new ArrayList<>();
    public static List<Long> numberB = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        input();
        makeSortedList();
        int aIndex =0;
        int bIndex =0;
        long sum;
        while(true){
            sum = numberA.get(aIndex)+numberB.get(bIndex);
            if(sum<T){
                aIndex++;
            }
            if(sum>T){
                bIndex++;
            }
            if(sum==T){
                long aSame =1;
                long bSame =1;
                while(aSame+aIndex<numberA.size()&&numberA.get(aIndex)==numberA.get(aIndex+(int)aSame)) aSame++;
                while(bSame+bIndex<numberB.size()&&numberB.get(bIndex)==numberB.get(bIndex+(int)bSame)) bSame++;
                answer+=(aSame*bSame);
                aIndex+=aSame;
                bIndex+=bSame;
            }
            if(aIndex==numberA.size()||bIndex==numberB.size()) break;
        }
        System.out.println(answer);
    }

    private static void makeSortedList() {
        for(int i=0;i<N;i++){
            long cnt = 0L;
            for(int j=i;j<N;j++){
                cnt+=A[j];
                numberA.add(cnt);
            }
        }
        for(int i=0;i<M;i++){
            long cnt = 0L;
            for(int j=i;j<M;j++){
                cnt+=B[j];
                numberB.add(cnt);
            }
        }
        Collections.sort(numberA);
        Collections.sort(numberB,Collections.reverseOrder());
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        T = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        A = new int[N];
        for(int i=0;i<N;i++) A[i] =  Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        B = new int[M];
        for(int i=0;i<M;i++) B[i] = Integer.parseInt(st.nextToken());
    }
}
