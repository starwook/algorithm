import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2644 {
    public static int N;
    public static int first,second;
    public static int relationCount;
    public static int[][] relation;
    public static int[] counts;
    public static int defaultValue =-1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        first = Integer.parseInt(st.nextToken());
        second = Integer.parseInt(st.nextToken());

        counts = new int[N+1];
        relation = new int[N+1][N+1];

        relationCount = Integer.parseInt(br.readLine());
        Arrays.fill(counts,defaultValue);


        for(int i=0;i<relationCount;i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            relation[parent][child] = 1;
            relation[child][parent] = 1;
        }
        getIndex(first,0);
        System.out.println(counts[second]);
    }
    public static void getIndex(int index,int count){
        if(counts[index] == defaultValue){
            counts[index] =count;
        }
        else{
            return;
        }
        for(int i=1;i<=N;i++){
            if(i==index) continue;
            if(relation[index][i]==1){
                getIndex(i,count+1);
            }
        }
    }


}
