import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1799 {
    public static int N;
    public static int[][] chessBoard;
    public static final int BISHOP_NUMBER =2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        chessBoard = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                chessBoard[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }
}


