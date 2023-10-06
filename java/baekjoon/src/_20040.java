import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20040 {
    public static int N,M;
    public static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = i;
        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if(union(first,second)){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
    public static int findParent(int a){
        if(arr[a]==a) return a;
        return arr[a] = findParent(arr[a]);
    }
    public static boolean union(int a,int b){
        int parentA = findParent(a);
        int parentB = findParent(b);
        if(parentA==parentB){
            return true;
        }
        arr[parentA] = parentB;
        return false;

    }
}
