import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _9345 {
    public static int N,T,K;
    public static int treeSize;
    public static int[] maxTree,minTree,tree;
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int tc =0;tc<T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            treeSize =1;
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            while(treeSize<N) treeSize*=2;
            maxTree = new int[treeSize*2];
            minTree = new int[treeSize*2];
            tree = new int[treeSize];
            for(int i=treeSize;i<treeSize+N;i++){
                maxTree[i] = i-treeSize+1;
                minTree[i] = i-treeSize+1;
            }
            for(int i=treeSize+N;i<treeSize*2;i++){
                minTree[i] = 1000000;
            }
            for(int i=treeSize-1;i>=1;i--){
                maxTree[i] = Math.max(maxTree[i*2],maxTree[i*2+1]);
                minTree[i] = Math.min(minTree[i*2],minTree[i*2+1]);
            }
            for(int k=0;k<K;k++){
                st = new StringTokenizer(br.readLine());
                int choice = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken())+1;
                int r = Integer.parseInt(st.nextToken())+1;
                if(choice==1){
                    System.out.println(l+"!!"+r);
                    int min = findMinimum(1,treeSize,l,r,1);
                    int max = findMaximum(1,treeSize,l,r,1);
                    System.out.println(min+"/"+max);
                    if(min==l&& max==r){
                        System.out.println("YES");
                    }
                    else{
                        System.out.println("NO");
                    }
                }
                if(choice==0){
                    int left = minTree[treeSize+l-1];
                    int right = minTree[treeSize+r-1];
                    minTree[treeSize+r-1] = left;
                    maxTree[treeSize+r-1] = left;
                    minTree[treeSize+l-1] =right;
                    minTree[treeSize+l-1] =right;
                    update(1,treeSize,1,l,right);
                    for(int i=1;i<treeSize*2;i++){
                        System.out.print(maxTree[i]+" ");
                    }
                    System.out.println();
                    update(1,treeSize, 1,r,left);
                    for(int i=1;i<treeSize*2;i++){
                        System.out.print(maxTree[i]+" ");
                    }
                }
            }
        }
    }
    public static int findMinimum(int left,int right,int targetLeft,int targetRight,int index){
        if(right<targetLeft||left>targetRight) return 1000000;
        if(targetLeft<=left&&right<=targetRight){
            return minTree[index];
        }
        int mid = (left+right)/2;
        return Math.min(findMinimum(left,mid,targetLeft,targetRight,index*2),findMinimum(mid+1,right,targetLeft,targetRight,index*2+1));
    }
    public static int findMaximum(int left,int right,int targetLeft,int targetRight,int index){
        if(right<targetLeft||left>targetRight) return 0;
        if(targetLeft<=left&&right<=targetRight){
            return maxTree[index];
        }
        int mid = (left+right)/2;
        return Math.min(findMaximum(left,mid,targetLeft,targetRight,index*2),findMaximum(mid+1,right,targetLeft,targetRight,index*2+1));
    }
    public static void update(int left,int right,int index,int target,int afterTarget){
        if(target>right||target<left) return;
        if(left<=target&&target<=right){
            if(left==right){
                minTree[index] =afterTarget;
                maxTree[index] =afterTarget;
                return;
            }
            minTree[index] = Math.min(minTree[index],afterTarget);
            maxTree[index] = Math.max(maxTree[index],afterTarget);
            int mid =(left+right)/2;
            update(left,mid,index*2,target,afterTarget);
            update(mid+1,right,index*2+1,target,afterTarget);
        }

    }
}
