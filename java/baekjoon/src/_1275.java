import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _1275 {
    public static int N,Q,treeSize;
    public static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        treeSize =1;
        while(treeSize<N) treeSize*=2;
        tree = new long[treeSize*2];
        st = new StringTokenizer(br.readLine());
        for(int i=treeSize;i<treeSize+N;i++) tree[i] = Long.parseLong(st.nextToken());
        for(int i=treeSize-1;i>=1;i--) tree[i] =  tree[i*2]+tree[i*2+1];

        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            int x =Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x>y){
                int tmp = x;
                x =y;
                y = tmp;
            }
            int numberIndex = Integer.parseInt(st.nextToken());
            long afterNumber = Integer.parseInt(st.nextToken());
            System.out.println(findSum(1,treeSize,x,y,1));
            update(1,treeSize,afterNumber,1,numberIndex);

        }
    }
    public static long findSum(int left,int right,int targetLeft,int targetRight,int index){
        if(right<targetLeft|| left>targetRight) return 0;
        if(targetLeft<=left && targetRight>=right) return tree[index];
        int mid =(left+right)/2;
        return findSum(left,mid,targetLeft,targetRight,index*2)+ findSum(mid+1,right,targetLeft,targetRight,index*2+1);
    }
    public static void update(int left,int right,long to,int startIndex,int targetIndex){
        if(left==right&&left == targetIndex){
            tree[startIndex] = to;
            return;
        }
        if(left<=targetIndex && targetIndex<=right){
            tree[startIndex] -= (tree[targetIndex+treeSize-1]-to);
            int mid = (left+right)/2;
            update(left,mid,to,startIndex*2,targetIndex);
            update(mid+1,right,to,startIndex*2+1,targetIndex);
        }
    }

}
