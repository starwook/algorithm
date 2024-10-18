import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2812 {
    public static int n,k;
    public static int[] arr;
    public static boolean[] deleted;
    public static PriorityQueue<Node> nodes = new PriorityQueue<>((o1, o2) ->{
        if(o1.number==o2.number) return o1.index-o2.index;
        return o1.number-o2.number;
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        deleted = new boolean[n];
        String numberStr = br.readLine();
        for(int i=0;i<n;i++){
            arr[i] = numberStr.charAt(i);
        }
        int maxIndex =0;
        int maxNumber=-1;
        int deleteCount =0;
        for(int i=0;i<n;i++){
            if(arr[i]>maxNumber){
                for(;deleteCount<k;deleteCount++){
                    if(nodes.isEmpty()) break;
                    Node node = nodes.poll();
                    System.out.println(node.index+"/deleted");
                    deleted[node.index] = true;
                }
                maxNumber = arr[i];
            }
            nodes.add(new Node(i,arr[i]));
            if(deleteCount==k){
                break;
            }
        }
        for(;deleteCount<k;deleteCount++){
            Node node = nodes.poll();
            System.out.println(node.index+"/deleted");
            deleted[node.index] = true;
        }

        for(int i=0;i<n;i++){
            System.out.print(deleted[i]+" ");
        }
    }
    public static class Node{
        int index;
        int number;

        public Node(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
}
//4177252841
//
//477252841
//
//77252841
//
//7752841
//
//775841



