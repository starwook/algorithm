import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 루돌프_반란 {
    public static int N,turnCount,santaPower,rudolphPower,santaCount;
    public static int[] rudolphRArr = {-1,1,0,0,-1,1,-1,1};
    public static int[] rudolphCArr = {0,0,-1,1,-1,-1,1,1};
    public static int rudolphR,rudolphC;
    public static int liveSanta;
    public static int[][] santaIndexArr;
    public static Santa[] santaArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        turnCount = Integer.parseInt(st.nextToken());
        santaCount = Integer.parseInt(st.nextToken());
        rudolphPower = Integer.parseInt(st.nextToken());
        santaPower = Integer.parseInt(st.nextToken());
        santaIndexArr = new int[N+1][N+1];
        santaArr = new Santa[santaCount+1];
        st = new StringTokenizer(br.readLine());
        rudolphR = Integer.parseInt(st.nextToken());
        rudolphC = Integer.parseInt(st.nextToken());
        for(int i=0;i<santaCount;i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            santaArr[number] = new Santa(r,c,number);
            santaIndexArr[r][c] = number;
        }
        liveSanta = santaCount;
        for(int i=0;i<turnCount;i++){
            int santaIndex =0;
            int santaDistance =100000;
            for(int p = 1;p<=santaCount;p++){
                Santa nowSanta = santaArr[p];
                if(nowSanta.out) continue;
                int distance = (int) (Math.pow(rudolphR-nowSanta.r,2) + Math.pow(rudolphC-nowSanta.c,2));
                if(distance<santaDistance){
                    santaIndex = p;
                    santaDistance = distance;
                }
                else if (distance==santaDistance){
                    if(santaArr[santaIndex].r< nowSanta.r){
                        santaIndex = p;
                    }
                    else if(santaArr[santaIndex].r==nowSanta.r &&santaArr[santaIndex].c<nowSanta.c) santaIndex=p;
                }
            }
            Santa selectedSanta = santaArr[santaIndex];




            if(liveSanta==0) break;
        }


        // 여기에 코드를 작성해주세요.
    }
    public static class Santa{
        int r,c;
        boolean out;
        boolean faint;
        int score,number;

        public Santa(int r, int c, int number) {
            this.r = r;
            this.c = c;
            this.score = 0;
            this.number = number;
        }
    }
}
