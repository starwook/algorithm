public class 행렬테두리회전하기 {

    class Solution {
        public int[][] arr;
        public int[] solution(int rows, int columns, int[][] queries) {
            arr =new int[101][101];
            int cnt=1;
            int[] answer = {};
            answer = new int[queries.length];
            for(int i=1;i<=rows;i++){
                for(int j=1;j<=columns;j++){
                    arr[i][j] = cnt;
                    cnt++;
                }
            }
            for(int i=0;i< queries.length;i++){
                int firstNumber = arr[queries[i][0]][queries[i][1]];
                int minNum = firstNumber;
                for(int r = queries[i][0]+1;r<=queries[i][2];r++){
                    arr[r-1][queries[i][1]] = arr[r][queries[i][1]];
                    minNum = Math.min(minNum,arr[r][queries[i][1]]);
                }
                for(int c=queries[i][1]+1;c<=queries[i][3];c++){
                    arr[queries[i][2]][c-1] =arr[queries[i][2]][c];
                    minNum = Math.min(minNum,arr[queries[i][2]][c]);
                }
                for(int r=queries[i][2]-1;r>=queries[i][0];r--){
                    arr[r+1][queries[i][3]] = arr[r][queries[i][3]];
                    minNum = Math.min(minNum,arr[r][queries[i][3]]);
                }
                for(int c=queries[i][3]-1;c>=queries[i][1];c--){
                    arr[queries[i][0]][c+1] =arr[queries[i][0]][c];
                    minNum = Math.min(minNum,arr[queries[i][0]][c]);
                }
                arr[queries[i][0]][queries[i][1]+1] = firstNumber;
                answer[i] =minNum;
            }
            return answer;
        }
    }
}
