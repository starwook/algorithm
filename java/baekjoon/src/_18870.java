import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _18870 {
    public static int N;
    public static int[] arr;
    public static List<Node> nodes = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            nodes.add(new Node(arr[i],i));
        }

        nodes.sort((n1, n2) -> n1.val - n2.val);
        makeCount(0,0);
        nodes.sort((n1, n2) -> n1.index - n2.index);
        for(Node node : nodes){
            bw.write(node.count + " ");
        }
        bw.flush();
        bw.close();
    }
    public static void makeCount(int index,int beforeCount){
        nodes.get(index).count = beforeCount;
        if(index==N-1) return;
        if(nodes.get(index).val<nodes.get(index+1).val){
            makeCount(index+1,beforeCount+1);
        }
        else{
            makeCount(index+1,beforeCount);
        }
    }
    static class Node{
        int val;
        int index;
        int count;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
            this.count =0;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public int getVal() {
            return val;
        }

        public int getIndex() {
            return index;
        }
    }
}
