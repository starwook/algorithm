import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PCCP_03 {
    class Solution {
        public int answer;
        public int[][] map;
        public int solution(int[][] points, int[][] routes) {
            Node[] nodes = new Node[routes.length];
            map = new int[101][101];
            for(int i=0;i<nodes.length;i++){
                int[] route = routes[i];
                nodes[i] = new Node(Arrays.stream(route)
                        .boxed()
                        .collect(Collectors.toList())
                        , points
                ,i+1);
                map[nodes[i].r][nodes[i].c]++;
            }
            boolean allArrived = false;
            checkDuplicate();
            while(!allArrived){
                allArrived = true;
                for(int i=0;i<nodes.length;i++){
                    if(nodes[i].arrived && !nodes[i].out){
                        map[nodes[i].r][nodes[i].c]--;
                        nodes[i].out =true;
                    }
                }
                for(int i=0;i<nodes.length;i++){
                    if(nodes[i].arrived) continue;
                    allArrived = false;
                    map[nodes[i].r][nodes[i].c]--;
                    nodes[i].move();
                    map[nodes[i].r][nodes[i].c]++;
                }
                checkDuplicate();
            }
            return answer;
        }
        private void checkDuplicate() {
            for(int i=1;i<=100;i++){
                for(int j=1;j<=100;j++){
                    if(map[i][j]>=2){
                        answer++;
                    }
                }
            }
//            System.out.println(answer);
        }
    }
    class Node{
        int index;
        int r,c;
        int[][] point;
        List<Integer> route;
        boolean arrived,out;
        int currentIndex;
        public Node(List<Integer> route,int[][] point,int index) {
            this.route = route;
            this.point = point;
            currentIndex = 0;
            arrived = false;
            int[] currentPoint = point[route.get(currentIndex)-1];
            this.r = currentPoint[0];
            this.c = currentPoint[1];
            currentIndex++;
            this.index = index;
        }
        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }
        public void move(){
            int[] nextPoint = point[route.get(currentIndex)-1];
            int endR = nextPoint[0];
            int endC = nextPoint[1];
            if(r>endR){
                r--;
            }
            else if(r<endR){
                r++;
            }
            else if(c>endC){
                c--;
            }
            else if(c<endC){
                c++;
            }
//            System.out.println(index+":"+r+"/"+c);
            if(endR == r && endC==c){
                currentIndex++;
            }
            if(currentIndex==route.size()){
                arrived = true;
            }
        }
    }
}
