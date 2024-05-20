import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _코드트리메신저 {
//    public static int[] parent;
//    public static boolean[] alarm;
//    public static int[] authority;
    public static int N,Q;
    public static int maxDepth =20;
    public static class Node{
        boolean alarmOff =false;
        int authority;
        int leftNodeNumber =-1;
        int rightNodeNumber =-1;
//        int index;
        int parentNumber;
        int number;

        public Node() {

        }
    }
    public static Node[]  nodes;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        nodes = new Node[N+1];
        for(int i=0;i<=N;i++){
            nodes[i] =  new Node();
        }
        int indexTreeCount =1;
        for(int i=1;i<=maxDepth;i++){
            indexTreeCount*=2;
        }
//        indexTree = new int[indexTreeCount];
//        for(int i=0;i<indexTreeCount;i++) indexTree[i] =-1;
//        indexTree[1] =0;
//        nodes[0].index = 1;
        nodes[0].authority =100;

        for(int turn =0;turn<Q;turn++){
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
//            parent = new int[N+1];
//            authority = new int[N+1];
//            alarm = new boolean[N+1];
            if(operation==100){
                makeTree(st);
            }
            if(operation==200){
                int number = Integer.parseInt(st.nextToken());
                nodes[number].alarmOff = !nodes[number].alarmOff;
            }
            if(operation==300){
                int number = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());
                nodes[number].authority = power;
            }
            if(operation==400){

                int leftNodeNumber = Integer.parseInt(st.nextToken());
                int rightNodeNumber = Integer.parseInt(st.nextToken());
                //부모 같다면 스킵
//                changeByIndexTree(leftNodeNumber, rightNodeNumber);

                changeByTree(leftNodeNumber, rightNodeNumber);
            }
            if(operation==500){
//                showIndexTreeAndIndexOfNode();
                int number = Integer.parseInt(st.nextToken());
                /*System.out.println(getCount(number,0)-1);*/
                System.out.println(getCountByTree(number,0)-1);
            }
        }

    }
    public static int getCountByTree(int number,int depth){
        int count =0;
        if(nodes[number].authority>=depth){
            count++;
        }
        Node node = nodes[number];
        if(node.leftNodeNumber!=-1){
            if(!nodes[node.leftNodeNumber].alarmOff){
                count+= getCountByTree(node.leftNodeNumber, depth+1);
            }
        }
        if(node.rightNodeNumber !=-1){
            if(!nodes[node.rightNodeNumber].alarmOff){
                count+= getCountByTree(node.rightNodeNumber,depth+1);
            }
        }
        return count;

    }

    private static void changeByTree(int leftNodeNumber, int rightNodeNumber) {
        if(nodes[leftNodeNumber].parentNumber==nodes[rightNodeNumber].parentNumber) return;

        Node leftNode = nodes[leftNodeNumber];
        Node rightNode =  nodes[rightNodeNumber];
        Node leftNodeParent = nodes[leftNode.parentNumber];
        Node rightNodeParent = nodes[rightNode.parentNumber];

        //부모의 자식 바꾸기
        if(leftNodeParent.leftNodeNumber== leftNode.number ){
            leftNodeParent.leftNodeNumber = rightNode.number;
        }
        if(leftNodeParent.rightNodeNumber == leftNode.number){
            leftNodeParent.rightNodeNumber = rightNode.number;
        }
        if(rightNodeParent.leftNodeNumber== rightNode.number){
            rightNodeParent.leftNodeNumber = leftNode.number;
        }
        if(rightNodeParent.rightNodeNumber==rightNode.number){
            rightNodeParent.rightNodeNumber = leftNode.number;
        }
        //자식의 부모 바꾸기
        int tmpNumber = leftNodeParent.number;
        leftNode.parentNumber = rightNode.parentNumber;
        rightNode.parentNumber = tmpNumber;

    }


    private static void makeTree(StringTokenizer st) {
        for(int i=1;i<=N;i++){
            int nowParent = Integer.parseInt(st.nextToken());
//            parent[i] = nowParent;
            nodes[i].parentNumber = nowParent;
            nodes[i].number =i;
            if(nodes[nowParent].leftNodeNumber == -1){
                nodes[nowParent].leftNodeNumber = i;
            }
            else{
                nodes[nowParent].rightNodeNumber = i;
            }
        }
        for(int i=1;i<=N;i++){
            int nowAuthority= Integer.parseInt(st.nextToken());
//            authority[i] = nowAuthority;
            nodes[i].authority =nowAuthority;
        }
//        makeIndex(1,0);

    }

}