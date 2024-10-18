import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17142 {
    public static int N,M;
    public static int[] xi ={-1,1,0,0};
    public static int[] yi = {0,0,-1,1};
    public static int[][] map;
    public static int[][] virusMap;
    public static final int NOT_VISITED = -1;
    public static final int VIRUS_CODE =2;
    public static Queue<Virus> viruses = new LinkedList<>();
    public static int blankCount,contaminateCount,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        virusMap = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            Arrays.fill(virusMap[i],NOT_VISITED);
        }
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] ==VIRUS_CODE){
                    viruses.add(new Virus(i,j,0));
                    virusMap[i][j] = 0;
                }
                if(map[i][j] ==0) blankCount++;
            }
        }
        while(!viruses.isEmpty()){
            Virus virus = viruses.poll();
            answer = Math.max(answer,virus.time);
            for(int i=0;i<4;i++){
                int nextR = virus.r+xi[i];
                int nextC = virus.c+yi[i];
                if(nextR<1||nextR>N||nextC<1||nextC>N) continue;
                if(map[nextR][nextC]!=0) continue;
                if(virusMap[nextR][nextC]!=NOT_VISITED) continue;
                virusMap[nextR][nextC] = virus.time+1;
                contaminateCount++;
                viruses.add(new Virus(nextR,nextC,virus.time+1));
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.printf("%2d ", virusMap[i][j]); // %2d는 2자리로 출력
            }
            System.out.println();
        }

        if(contaminateCount!=blankCount){
            answer =-1;
        }
        System.out.println(answer);

    }
}
class Virus{
    int r,c;
    int time;

    public Virus(int r, int c, int time) {
        this.r = r;
        this.c = c;
        this.time = time;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public int getTime() {
        return time;
    }
}