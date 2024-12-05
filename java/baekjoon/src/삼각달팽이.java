import java.util.ArrayList;
import java.util.List;

public class 삼각달팽이 {
    class Solution {
        public int[][] arr;
        public int[] solution(int n) {
            int[] answer = {};
            arr = new int[n][n];
            roll(1,0,0,n);
            List<Integer> numbers = new ArrayList<>();
            for(int r=0;r<n;r++){
                for(int c=0;c<=r;c++){
                    numbers.add(arr[r][c]);
                }
            }
            return numbers.stream().mapToInt(i->i).toArray();
        }
        public void printMap(int[][] map)
        {
            for(int i=0;i<map.length;i++){
                for(int j=0;j<map[0].length;j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("------------");
        }
        public void roll(int number, int r, int c, int length){
            if(length<=0){
                return;
            }
            arr[r][c] = number;
//            System.out.println(arr[r][c]);
            for(int i=0;i<length-1;i++){
                r++;
                number++;
                arr[r][c] = number;
            }
            for(int i=0;i<length-1;i++){
                c++;
                number++;
                arr[r][c] = number;
            }
            for(int i=0;i<length-2;i++){
                r--;
                c--;
                number++;
                arr[r][c] = number;
            }
//            printMap(arr);
            roll(number+1,r+1,c,length-3);
        }
    }
}
