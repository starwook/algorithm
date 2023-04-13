import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x,y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int[] cDirection ={0,0,-1,1};
    int[] rDirection ={-1,1,0,0};
    int[][] visited = new int[100][100];
    public int solution(int[][] maps) {
        int answer = 0;
        for(int i=0;i<100;i++){
            Arrays.fill(visited[i],0);
        }
        bfs(0,0,maps);
        answer = visited[maps.length-1][maps[0].length-1];
        if(answer ==0){
            answer =-1;
        }

        return answer;
    }
    public void bfs(int r,int c,int[][] maps){
        Queue<Pair> pairs = new LinkedList<>();
        pairs.add(new Pair(r,c));
        visited[r][c]=1;
        while(!pairs.isEmpty()){
            int newR = pairs.peek().x;
            int newC = pairs.peek().y;
            if(newR==maps.length-1&&newC==maps[0].length-1){
                return;
            }
            pairs.poll();
            for(int i=0;i<4;i++){
                int nextR = newR+rDirection[i];
                int nextC = newC+cDirection[i];
                if(nextR>=0&&nextR<maps.length&&nextC>=0&&nextC<maps[0].length){
                    if(visited[nextR][nextC]==0&& maps[nextR][nextC]==1){
                        visited[nextR][nextC] = visited[newR][newC]+1;
                        pairs.add(new Pair(nextR,nextC));
                    }
                }
            }
        }

    }


}