import java.util.*;
public class 피로도 {
    class DungeonInformation{
        int minK;
        int useK;
        DungeonInformation(int x,int y){
            this.minK =x;
            this.useK =y;
        }
    }
    class Solution {
        boolean visited[];
        int answer = -1;
        public int solution(int k, int[][] dungeons) {
            visited=new boolean[dungeons.length];
            Arrays.fill(visited,false);
            findDungeon(k,0,dungeons);
            return answer;
        }
        public void findDungeon(int remainK,int dungeonClear,int[][] dungeons){

            answer = Math.max(dungeonClear,answer);
            for(int i=0;i<dungeons.length;i++){
                if(!visited[i]){
                    if(dungeons[i][0]<=remainK){
                        visited[i] =true;
                        findDungeon(remainK-dungeons[i][1],dungeonClear+1,dungeons);
                        visited[i] = false;
                    }
                }
            }

        }
    }
}
