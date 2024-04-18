import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _10868 {
    public static int N,M,treeSize;
    public static int[] tree;
    public static int maxValue = 1000000000;
    public static int callCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        treeSize = 1;
        while(treeSize<N) treeSize*=2;
        tree = new int[treeSize*2];
        for(int i=treeSize;i<treeSize+N;i++){
            tree[i] = Integer.parseInt(br.readLine());
        }
        for(int i= treeSize+N;i<tree.length;i++){
            tree[i] = maxValue;
        }
        for(int i=treeSize-1;i>=1;i--){
            tree[i] = Math.min(tree[i*2],tree[i*2+1]);
        }
        for(int i =0;i<M;i++){
            callCnt =0;
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            System.out.println(findMinimum(1,treeSize,left,right,1));
        }
    }
    public static int findMinimum(int left,int right,int targetLeft,int targetRight,int index){

        if(right<targetLeft||left>targetRight) return maxValue;
        if(targetLeft<=left&&right<=targetRight) return tree[index];
        int mid = (left+right)/2;
        return Math.min(findMinimum(left,mid,targetLeft,targetRight,index*2),findMinimum(mid+1,right,targetLeft,targetRight,index*2+1));
    }
}
