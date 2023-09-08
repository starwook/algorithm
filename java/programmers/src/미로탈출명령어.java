import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출명령어 {
    class Solution {
        public char[][] arr;
        public boolean[][] visited;
        public boolean arrived;
        public int destR,destC;
        public Queue<Node> queue = new LinkedList<>();
        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            String answer = "";
            arr = new char[n+1][m+1];
            visited = new boolean[n+1][m+1];
            arr[x][y] ='S';
            arr[c][k] ='E';
            queue.add(new Node(x,y));
            while(!queue.isEmpty()){
                Node nowNode = queue.poll();
                int nowR = nowNode.r;
                int nowC = nowNode.c;
            }
            return answer;
        }
    }
    class Node{
        int r,c;

        Node(int x,int y){
            this.r = x;
            this.c =y;
        }
    }
}
