import java.io.*;
import java.util.*;
public class _2243 {
    public static int S,N;
    public static int[] tree;
    public static int treeSize;
    public static void main(String[] args) throws IOException {
        treeSize =1;
        while(treeSize<1000000) treeSize*=2;
        tree = new int[treeSize*2];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            if(st.nextToken().equals("2")){
                int target = Integer.parseInt(st.nextToken());
                int diff = Integer.parseInt(st.nextToken());
                update(1,treeSize,1,target,diff);
                continue;
            }
            else{
                int target = Integer.parseInt(st.nextToken());
                int foundCandyNode = findCandy(1,treeSize,1,target);
                update(1,treeSize,1,foundCandyNode-treeSize+1,-1);
                System.out.println(foundCandyNode-treeSize+1);
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
    public static void update(int left,int right,int node,int target,int diff){
        if(target>=left&&target<=right){
            tree[node] +=diff;
            if(left==right) {
                return;
            }
            update(left,(left+right)/2,node*2,target,diff);
            update((left+right)/2+1,right,node*2+1,target,diff);
        }
    }
    public static int findCandy(int left,int right,int node,int rank){
        if(left==right) return node;
        if(rank<=tree[node*2]){ //왼쪽 "자식"에 있는지 확인!!!
            return findCandy(left,(left+right)/2,node*2,rank);
        }
        else{
            return findCandy((left+right)/2+1,right,node*2+1,rank-tree[node*2]);
        }

    }
}
