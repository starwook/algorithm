import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dx_2024_1 {
    public static int[] rowArr = new int[20001];
    public static boolean[] visited = new boolean[20001];
    public static int getDistance(int start,int end){
        if(start==end) return 0;
        if(visited[start]) return 20000;
        visited[start] = true;
        int startRow = rowArr[start];
        int endRow = rowArr[end];
        if(startRow<endRow){
            return Math.min(getDistance(start+startRow,end),getDistance(start+startRow+1,end))+1;
        }
        if(startRow==endRow){
            return Math.abs(start-end);
        }
        return 20000;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int rowIndex =1;
        int index=1;
        while(index<=20000) {
            for (int j = 0; j < rowIndex; j++) {
                if(index==20000) break;
                rowArr[index] = rowIndex;
                index++;
            }
            if(index==20000) break;
            rowIndex++;
        }
        for(int test_case =1;test_case<=t;test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=20000;i++) visited[i] = false;
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(s>e){
                int tmp =s;
                s =e;
                e =tmp;
            }
            System.out.println("#"+ test_case+" "+getDistance(s,e));
        }
    }
}
