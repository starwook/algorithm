import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1493 {
    public static int length,width,height;
    public static int n;
    public static int[] cubes;
    public static boolean[][][] visited;
    public static int answer;
    public static boolean can =true;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        cubes = new int[20];
        visited = new boolean[20][20][20];
        n = Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bufferedReader.readLine());
            int type = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            cubes[type] =count;
        }
        found(19,0,0,0);
        if(!can) System.out.println(-1);
        else System.out.println(answer);

    }
    public static void found(int index,int nowLength,int nowWidth,int nowHeight){
        if(nowHeight==height ||nowWidth==width||nowLength==length) return;
        if(!can) return;
        for(int i=index;i>=0;i--) {
            if (cubes[i] > 0) {
                int tmpLong = 1;
                for (int c = 0; c < i; c++) {
                    tmpLong *= 2;
                }
                int nextLength = tmpLong+nowLength;
                int nextWidth = tmpLong+nowWidth;
                int nextHeight = tmpLong+nowHeight;

                if (nextLength <= length && nextWidth <= width && nextHeight <= height) {
                    cubes[i]--;
                    answer++;

                    for(int one =0;one<2;one++){
                        for(int two =0;two<2;two++){
                            for(int three=0;three<2;three++){
                                if(one ==0&&two==0&three==0) continue;
                                int nextOne;
                                int nextTwo;
                                int nextThree;
                                if(one ==0) nextOne = nowLength;
                                else nextOne = nextLength;
                                if(two==0)nextTwo = nowWidth;
                                else nextTwo = nextWidth;
                                if(three==0)nextThree = nowHeight;
                                else nextThree= nextHeight;
//                                if(!visited[nextOne][nextTwo][nextThree]){
//                                    visited[nextOne][nextTwo][nextThree]=true;
//
//                                }
                                found(i,nextOne,nextTwo,nextThree);
                            }
                        }
                    }
                    return;
                }
            }
        }
        can = false;
    }

}
