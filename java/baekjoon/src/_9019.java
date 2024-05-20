import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9019 {
    public static int N,T,A,B;
    public static int[] arr;
    static String answer;
    static class Node{
        String manual;
        int number;

        Node(String manual,int number){
            this.manual = manual;
            this.number = number;

        }
    }
    static Queue<Node> queue = new LinkedList<>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            init(br);
            while(!queue.isEmpty()){
                Node nowNode = queue.poll();
                if(visited[nowNode.number])continue;
                if(nowNode.number == B) {
                    System.out.println(nowNode.manual);
                    break;
                }
                visited[nowNode.number] = true;

                ifNotVisitedAdd(nowNode.manual+"D", (nowNode.number*2)%10000);
                int sNumber = nowNode.number-1;
                if(sNumber==-1) sNumber = 9999;
                ifNotVisitedAdd(nowNode.manual+"S",sNumber);
                ifNotVisitedAdd(nowNode.manual+"L",(nowNode.number%1000)*10 + nowNode.number/1000);
                ifNotVisitedAdd(nowNode.manual+"R",(nowNode.number%10*1000+ nowNode.number/10));

            }


        }
    }

    private static void right(char[] arr2) {
        char last = arr2[arr2.length-1];
        for(int j = arr2.length-2; j>=0; j--) arr2[j+1] = arr2[j];
        arr2[0] = last;
    }

    private static void Left(char[] arr) {
        char first = arr[0];
        for(int j = 1; j< arr.length; j++){
            arr[j-1] = arr[j];
        }
        arr[arr.length-1] = first;
    }

    static void ifNotVisitedAdd(String manual,int number){
        if(!visited[number])queue.add(new Node(manual,number));
        //visited[number] = true;

    }

    private static void init(BufferedReader br) throws IOException {
        queue = new LinkedList<>();
        answer ="";
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        arr = new int[a.length()];
        N = a.length();
        A = Integer.parseInt(a);
        B = Integer.parseInt(st.nextToken());
        queue.add(new Node("",A));
        visited = new boolean[10000];
        //visited[A] = true;

    }

    static int charArrToInt(char[] arr){
        int res =0;
        for(int i=0;i<arr.length;i++){
            res+=(Math.pow(10,i)* (arr[arr.length-1-i]-'0'));
        }
        return res;
    }
}
