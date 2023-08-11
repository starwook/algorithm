
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
public class _2357 {
    public static int treeSize;
    public static int N,M;
    public static int[] maxTree;
    public static int[] minTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        treeSize =1;
        while(treeSize<N) {
            treeSize*=2;
        }
        maxTree = new int[treeSize*2];
        minTree = new int[treeSize*2];
        for(int i=0;i<N;i++) {
            maxTree[i+treeSize] = Integer.parseInt(br.readLine());
            minTree[i+treeSize] =  maxTree[i+treeSize];
        }
        for(int i=treeSize-1;i>0;i--) {
            maxTree[i] = Math.max(maxTree[i*2], maxTree[i*2+1]);
            if(minTree[i*2] ==0) {
                minTree[i] = minTree[i*2+1];
            }
            else if(minTree[i*2+1]==0) minTree[i] = minTree[i*2];
            else {
                minTree[i] = Math.min(minTree[i*2], minTree[i*2+1]);
            }

        }

//		for(int i=1;i<treeSize*2;i++) {
//			System.out.print(minTree[i]+" ");
//		}
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            System.out.println(findMinimum(1,1,treeSize,left,right)+" "+findMaximum(1,1,treeSize,left,right));

        }


    }
    public static int findMaximum(int index,int left,int right,int targetLeft,int targetRight) {


        if(targetLeft>right || targetRight<left) {
            return 0;
        }
        if(left>=targetLeft&&right<=targetRight) {
            return maxTree[index];
        }
        int mid = (left+right)/2;

        return Math.max(findMaximum(index*2,left,mid,targetLeft,targetRight)
                ,findMaximum(index*2+1,mid+1,right,targetLeft,targetRight));

    }
    public static int findMinimum(int index,int left,int right,int targetLeft,int targetRight) {

        if(targetLeft>right || targetRight<left) { //얘가 0을 전해줄 수 있음
            return Integer.MAX_VALUE;
        }
        if(left>=targetLeft&&right<=targetRight) {
            return minTree[index];
        }
        int mid = (left+right)/2;
        int leftMin = findMinimum(index*2,left,mid,targetLeft,targetRight);
        int rightMin =  findMinimum(index*2+1,mid+1,right,targetLeft,targetRight);
        return Math.min(leftMin, rightMin);

    }

}
