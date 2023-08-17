import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _6549 {
    public static int N,treeSize;
    public static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N==0) break;
            treeSize =1;
            while(treeSize<N){
                treeSize*=2;
            }
            tree = new long[treeSize*2];
            for(int i=treeSize;i<treeSize+N;i++) tree[i] = Long.parseLong(st.nextToken());
            for(int i=treeSize-1;i>=1;i--){
                tree[i] = Math.min(tree[i*2],tree[i*2+1]);
            }
        }



    }
//    public static long finaMaximum(int left,int right,)
}
