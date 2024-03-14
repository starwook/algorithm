import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class _1719 {
    public static int n,m;
    public static int[][] distance;
    public static int[][] answer;
    public static int[] mother;
    public static int MAX_NUM =3000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        distance = new int[n+1][n+1];
        answer = new int[n+1][n+1];
        mother = new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++) {
                distance[i][j]=MAX_NUM;
                if(i==j) {
                    distance[i][j] = 0;
                    mother[i]=i;
                }
            }
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            distance[from][to] =cost;
            distance[to][from] =cost;
            answer[from][to] = to;
            answer[to][from] = from;
        }
        for(int mid =1;mid<=n;mid++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(distance[i][j]>distance[i][mid]+distance[mid][j]){
                        distance[i][j] = distance[i][mid]+distance[mid][j];
                        answer[i][j] = findMother(i,mid);
                    }
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) System.out.print("-");
                else System.out.print(answer[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static int findMother(int start,int to){
        if(answer[start][to] ==to)return to;
        return findMother(start,answer[start][to]);
    }
}
