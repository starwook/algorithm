import java.io.*;
import java.util.*;

class softeer_3 {
    public static boolean[][] visited;
    public static int globalR, globalC;
    public static int[] ri ={-1,1,0,0};
    public static int[] ci ={0,0,1,1};
    public static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        globalC = Integer.parseInt(br.readLine());
        globalR = Integer.parseInt(br.readLine());
        arr = new int[globalR][globalC];
        visited = new boolean[globalR][globalC];
        for(int i = 0; i< globalR; i++){
            String line = br.readLine();
            for(int j = 0; j< globalC; j++) arr[i][j] = line.charAt(j)-'0';
        }

        InsideBox insideBox = makeBox(0,0,0,0);
        showInside(insideBox);

    }
    public static void showInside(InsideBox insideBox){
        if(insideBox.grade!=0){
            for(int i=0;i<insideBox.grade-1;i++) System.out.print(".");
            System.out.println(insideBox.size);
        }
        for(int i=0;i<insideBox.insideBoxes.size();i++){
            showInside(insideBox.insideBoxes.get(i));
        }
    }
    public static InsideBox makeBox(int r, int c, int standard,int grade){
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(new Node(r,c));
        InsideBox insideBox = new InsideBox(0,grade);
        visited[r][c] =true;
        insideBox.size++;
        List<Node> nextNodes = new ArrayList<>();
        while(!nodes.isEmpty()){
            Node nowNode = nodes.poll();
            for(int i=0;i<4;i++){
                int newR = nowNode.r+ri[i];
                int newC = nowNode.c+ci[i];
                if(newR>=0&&newR<globalR&&newC>=0&&newC<globalC){
                    if(arr[newR][newC]==standard){
                        if(!visited[newR][newC]){
                            visited[newR][newC] =true;
                            insideBox.size++;
                            nodes.add(new Node(newR,newC));
                        }
                    }
                    else{
                        if(!visited[newR][newC]){
                            nextNodes.add(new Node(newR,newC));
                        }
                    }
                }
            }
        }
        for(int i=0;i<nextNodes.size();i++){
            if(visited[nextNodes.get(i).r][nextNodes.get(i).c]) continue;
            InsideBox nextInsideBox = makeBox(nextNodes.get(i).r,nextNodes.get(i).c,arr[nextNodes.get(i).r][nextNodes.get(i).c],grade+1);
            insideBox.size+=nextInsideBox.size;
            insideBox.insideBoxes.add(nextInsideBox);
        }
        Collections.sort(insideBox.insideBoxes,(o1, o2) -> o2.size-o1.size);
        return insideBox;
    }
    public static class InsideBox{
        int size;
        int grade;
        List<InsideBox> insideBoxes = new ArrayList<>();

        public InsideBox(int size, int grade) {
            this.size = size;
            this.grade = grade;
        }
    }
    public static class Node{
        int r,c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}