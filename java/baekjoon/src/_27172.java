import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _27172 {
    public static int N;
    public static int[] player;
    public static boolean[] card;
    public static int[] score;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        player = new int[N];
        score = new int[1000001];
        card = new boolean[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            player[i] = Integer.parseInt(st.nextToken());
            card[player[i]] = true;
        }

        for( int i : player){
            for(int j = i*2;j<=1000000;j+=i){
                if(card[j]){
                    score[i]++;
                    score[j]--;
                }
            }
        }

        for(int scoreIndex : player){
            System.out.print(score[scoreIndex]+" ");
        }

    }
}
