import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 뮤탈리스크 {
    static int n;
    static Integer[] scv = new Integer[3];
    static int[] attack = {9,3,1};
    static int[][][] dp = new int[61][61][61];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i=0;i<n;i++){
            scv[i] = scanner.nextInt();
        }
        for(int i=n;i<3;i++){
            scv[i] =0;
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }


        System.out.println(attack(scv,0));
    }
    public static int attack(Integer[] tmpScv, int count){
        for(int i=0;i<tmpScv.length;i++){
            if(tmpScv[i]>0){
                break;
            }
            if(i==tmpScv.length-1){
                return count;
            }
        }
//        printMap(tmpScv);
        Arrays.sort(tmpScv,Collections.reverseOrder());
        if(dp[tmpScv[0]][tmpScv[1]][tmpScv[2]] !=Integer.MAX_VALUE){ //-1하면 안 됨
            return dp[tmpScv[0]][tmpScv[1]][tmpScv[2]];
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    if(i!=j&&i!=k&&j!=k){
                        Integer[] newScv = new Integer[3];
//                        System.out.println(attack[i]+" "+attack[j]+" "+attack[k]);
                        newScv[0] = Math.max(tmpScv[0]-attack[i],0);
                        newScv[1] = Math.max(tmpScv[1]-attack[j],0);
                        newScv[2] = Math.max(tmpScv[2]-attack[k],0);
                        dp[tmpScv[0]][tmpScv[1]][tmpScv[2]] = Math.min(dp[tmpScv[0]][tmpScv[1]][tmpScv[2]],attack(newScv,count+1));
                    }
                }
            }
        }
        return dp[tmpScv[0]][tmpScv[1]][tmpScv[2]];
    }

    public static void printMap(Integer[] scv){
        for(int i=0;i<3;i++){
            System.out.print(scv[i]);
        }
        System.out.println();
    }
}
