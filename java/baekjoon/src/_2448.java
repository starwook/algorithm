import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _2448 {
    static char[][] arr;
    static int depth,height;
    static Set<Integer>[] set  = new Set[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int tmp = N/3;
        height = tmp*3;
        depth = tmp*5 +(tmp-1);
        arr = new char[height][depth];
        for(int i=0;i<height;i++){
            Arrays.fill(arr[i],' ');
        }

        check(0,depth/2);


        for(int i=0;i<height;i++){
            for(int j=0;j<depth;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    static void check(int r,int c){
        set[0] = new HashSet<>();
        if(r==height) return;
        arr[r][c] ='*';
        if(r%3==0){
           check(r+1,c+1);
           check(r+1,c-1);
        }
        if((r%3)==1){
            check(r+1,c-1);
            check(r+1,c);
            check(r+1,c+1);
        }
        if((r%3)==2){
            int diff = depth/2-c;
            if(diff<0){ //오른쪽으로 갈때
                diff = -diff;
                if(2+3*((r+1)/3-1)==diff){
                    check(r+1,c+1);
                }

            }
            else{
                if(2+3*((r+1)/3-1)==diff){
                    check(r+1,c-1);
                }
            }
        }
    }
}