import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _2042 {
    public static int N,M,K;
    public static int treeSize;
    public static long tree[];
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        treeSize =1;
        while(treeSize<N){
            treeSize*=2;
        }
        tree = new long[treeSize*2];
        init(bufferedReader);
        for(int i=0;i<M+K;i++){
            st = new StringTokenizer(bufferedReader.readLine());
            String position = st.nextToken();
            if(position.equals("1")){
                int target = Integer.parseInt(st.nextToken());
                long diff = Long.parseLong(st.nextToken());
                update(1,treeSize,1,target,diff);
            }
            if(position.equals("2")){
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                System.out.println(findTotal(1,treeSize,1,left,right));
            }
        }

    }

    private static void init(BufferedReader bufferedReader) throws IOException {
        for(int i=treeSize;i<treeSize+N;i++){
            tree[i] = Long.parseLong(bufferedReader.readLine());
        }
        for(int i= treeSize-1;i>0;i--){
            tree[i] =tree[i*2]+tree[i*2+1];
        }
    }

    public static long update(int left,int right,int node,int target,long diff){
        if(left==right&& left==target){
            long toAdd = diff-tree[node];
            tree[node] = diff;
            return toAdd;
        }
        if(target>=left&&target<=right){
            int mid = (left+right)/2;
            long leftDiff = update(left,mid,node*2,target,diff);
            long rightDiff = update(mid+1,right,node*2+1,target,diff);
            tree[node]+=leftDiff;
            tree[node]+=rightDiff;
            return leftDiff+rightDiff;
        }
        return 0L;
    }
    public static long findTotal(int left,int right,int node,int queryLeft,int queryRight){
        if(queryRight<left ||queryLeft>right){
            return 0L;
        }
        if(queryLeft<=left&& queryRight>=right){
            return tree[node];
        }
        int mid = (left+right)/2;
        return findTotal(left,mid,node*2,queryLeft,queryRight)+findTotal(mid+1,right,node*2+1,queryLeft,queryRight);
    }
}
