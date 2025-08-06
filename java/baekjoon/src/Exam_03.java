
public class Exam_03 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {1, 1},
                {1, 2},
                {1, 4},
                {2, 1},
                {2, 2},
                {2, 3},
                {3, 4},
                {3, 1},
                {3, 2},
                {3, 3},
                {3, 4},
                {4, 4},
                {4, 3},
                {4, 4},
                {5, 4},
                {2 , 4}

        };
        solution.solution(arr);
    }
    static class Solution {
        public int[][] macaronMap;
        public int[][] duplicateCountMap;
        public boolean[][] visited;
        public boolean[][] eraseMap;
        public int[] currentHeight;
        public int[] ri ={-1,1,0,0};
        public int[] ci = {0,0,-1,1};
        public int mapSize =6;
        public String[] solution(int[][] macaron) {
            initate(mapSize);
            String[] answer = new String[mapSize];
            for(int i = 1; i<= mapSize; i++){
                currentHeight[i] = 1;
            }
            for(int i=0;i<macaron.length;i++){
                int[] curMacaron = macaron[i];
                int position = curMacaron[0];
                int macaronFlavor = curMacaron[1];

                fallMacaron(macaronFlavor,position);
                searchMacaron();
            }
            int index = 0;

            for(int r=mapSize;r>=1;r--){
                int[] row = macaronMap[r];
                StringBuilder builder = new StringBuilder();
                for(int c=1;c<=mapSize;c++){
                    builder.append(row[c]);
                }
                answer[index] = builder.toString();
                index++;
            }


            return answer;
        }
        public void initate(int mapSize){
            macaronMap = new int[mapSize+2][mapSize+2];
            duplicateCountMap = new int[mapSize+2][mapSize+2];
            visited = new boolean[mapSize+2][mapSize+2];
            eraseMap = new boolean[mapSize+2][mapSize+2];
            currentHeight = new int[mapSize+2];
        }

        public void fallMacaron(int flavor,int position){
            if (currentHeight[position] <= mapSize) {
                macaronMap[currentHeight[position]][position] = flavor;
                currentHeight[position]++;
            }
        }
        public void searchMacaron(){
            beforeSearch();
            boolean boom = false;
            for(int i=1;i<=mapSize;i++) {
                for (int j = 1; j <= mapSize; j++) {
                    if (visited[i][j] || macaronMap[i][j] == 0) continue;
                    checkCount(i, j, macaronMap[i][j], 1);
                }
            }

            for(int i=1;i<=mapSize;i++){
                for(int j=1;j<=mapSize;j++){
                    if(macaronMap[i][j]==0) continue;
                    if(duplicateCountMap[i][j]>=3){
                        boom = true;
                        eraseCheck(i,j,macaronMap[i][j]);
                    }
                }
            }


            for(int r = mapSize;r>=1;r--){
                for(int c=1;c<=mapSize;c++){
                    if(eraseMap[r][c]){
                        erase(r,c);
                    }
                }
            }
            if(boom) searchMacaron();
        }
        public void erase(int r,int c){
            for(int i= r; i<=mapSize;i++){
                if(i == mapSize){
                    macaronMap[i][c] = 0;
                    continue;
                }
                macaronMap[i][c] = macaronMap[i+1][c];
            }
            currentHeight[c]--;
        }
        public void eraseCheck(int r, int c, int color){
            eraseMap[r][c]=true;
            for(int i=0;i<4;i++){
                int nextR = r+ri[i];
                int nextC = c+ci[i];
                if(isInRange(nextR, nextC)){
                    if(macaronMap[nextR][nextC] == color && !eraseMap[nextR][nextC]){
                        eraseCheck(nextR,nextC,color);
                    }
                }
            }
        }
        public void checkCount(int r,int c,int color,int count){
            duplicateCountMap[r][c] = count;
            visited[r][c] = true;
            for(int i=0;i<4;i++){
                int nextR = r+ri[i];
                int nextC = c+ci[i];
                if(isInRange(nextR, nextC)){
                    if(visited[nextR][nextC]) continue;
                    if(macaronMap[nextR][nextC] == color){
                        checkCount(nextR,nextC,color,count+1);
                    }
                }
            }
        }
        private boolean isInRange(int nextR, int nextC) {
            return nextR >= 1 && nextC >= 1 && nextR <= mapSize && nextC <= mapSize;
        }
        private void beforeSearch() {
            for(int i=1;i<=mapSize;i++){
                for(int j=1;j<=mapSize;j++){
                    duplicateCountMap[i][j]=0;
                    eraseMap[i][j] =false;
                    visited[i][j] =false;
                }
            }
        }
        public void printMap(int[][] map){
            for(int i=0;i<map.length;i++){
                for(int j=0;j<map.length;j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        public void printMap(boolean[][] map){
            for(int i=0;i<map.length;i++){
                for(int j=0;j<map.length;j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
