import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2342 {
    public static int[][][] where;
    public static int[] cost;
    public static int[] arr;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] lines = line.split(" ");
        N = lines.length;
        arr = new int[N];
        where = new int[5][5][N];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++) Arrays.fill(where[i][j],-1);
        }
        for(int index =0;index<N;index++){
            arr[index] = Integer.parseInt(lines[index]);
        }
        System.out.println(findAnswer(0,0,0));

    }
    public static int findAnswer(int left,int right,int index){
        if(index ==N){
            return 0;
        }
        if(where[left][right][index]!=-1) return where[left][right][index];
        where[left][right][index] = Math.min(findAnswer(arr[index],right,index+1)+calculatePower(left,arr[index]),
                findAnswer(left,arr[index],index+1)+ calculatePower(right,arr[index]));
        return where[left][right][index];
    }
    public static int calculatePower(int original,int next){
        if(original==next) return 1;
        if(original==0 ){
            return 2;
        }
        if(next==0){
            return 0;
        }
        if(Math.abs(original-next)==2){
            return 4;
        }
        return 3;
    }
}
