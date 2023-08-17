import java.io.*;
import java.util.*;
public class _2517 {
    public static int N,treeSize;
    public static int[] tree;
    public static Node[] rankArr;
    public static int[] answer;
    public static Map<Integer,Integer> numbers = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        treeSize = 1;
        while(treeSize<N) treeSize*=2;
        tree = new int[treeSize*2];
        rankArr = new Node[treeSize+1];
        answer = new int[treeSize+1];

        Arrays.fill(rankArr,new Node(1000000001,0));
        for(int i=0;i<N;i++) {
            int tmpNumber =  Integer.parseInt(br.readLine());
            rankArr[i] = new Node(tmpNumber,i+1);
        }
        Arrays.sort(rankArr,(o1, o2) -> o1.speed -o2.speed);

        for(int i=0;i<N;i++){
            Node node = rankArr[i];
            update(1,treeSize,1,node.rank);
//            updateBottom(node.rank+treeSize-1);
            int sum = getSum(1,treeSize,1,node.rank-1,1);
            answer[node.rank-1] = node.rank-sum;
        }
        for(int i=0;i<N;i++) bw.write(Integer.toString(answer[i])+"\n");
        bw.flush();
        bw.close();
    }
    public static void update(int left,int right,int index,int target){
        if(right<target||target<left) return;
        if(left<=target&&target<=right){
            tree[index]++;
            if(left==right) return;
            int mid = (left+right)/2;
            update(left,mid,index*2,target);
            update(mid+1,right,index*2+1,target);
        }
    }
    public static int getSum(int left,int right,int targetLeft,int targetRight,int index){
        if(right<targetLeft||targetRight<left) return 0;
        if(targetLeft<=left&&right<=targetRight) return tree[index];
        int mid =(left+right)/2;
        return getSum(left,mid,targetLeft,targetRight,index*2)+ getSum(mid+1,right,targetLeft,targetRight,index*2+1);
    }
    public static class Node{
        int speed;
        int rank;
        public Node(int speed, int rank) {
            this.speed = speed;
            this.rank = rank;
        }
    }
}
