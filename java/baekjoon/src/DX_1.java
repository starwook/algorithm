import java.util.*;
class Solution
{
    public static int[][] manitoRelation = new int[401][401];
    public static int N,M;
    public static int MAX_VALUE =-1;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String inform = sc.nextLine();
            String[] informs = inform.split(" ");
            N = Integer.parseInt(informs[0]);
            M = Integer.parseInt(informs[1]);
            reset(sc);
            floyd();
            int answer = getMinimumCost();
            System.out.print("#"+test_case+" ");
            if(answer == MAX_VALUE) System.out.println(-1);
            else System.out.println(answer);
        }
    }

    private static int getMinimumCost() {
        int answer = MAX_VALUE;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(manitoRelation[i][j]!=MAX_VALUE &&manitoRelation[j][i]!=MAX_VALUE){
                    int newNumber = manitoRelation[i][j]+manitoRelation[j][i];
                    if(i==j){
                        newNumber /=2;
                    }
                    if(answer ==MAX_VALUE){
                        answer = newNumber;
                    }
                    else answer = Math.min(answer,newNumber);
                }
            }
        }
        return answer;
    }

    private static void floyd() {
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(manitoRelation[i][k]!=MAX_VALUE &&manitoRelation[k][j]!=MAX_VALUE){
                        if(manitoRelation[i][j] !=MAX_VALUE)  manitoRelation[i][j] = Math.min(manitoRelation[i][j],manitoRelation[i][k]+manitoRelation[k][j]);
                        else manitoRelation[i][j] = manitoRelation[i][k]+manitoRelation[k][j];
                    }
                }
            }
        }
    }

    private static void reset(Scanner sc) {
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++) {
                manitoRelation[i][j] = MAX_VALUE;
            }
        }
        for(int i=0;i<M;i++){
            String tmp = sc.nextLine();
            String[] tmps = tmp.split(" ");
            int from = Integer.parseInt(tmps[0]);
            int to = Integer.parseInt(tmps[1]);
            int cost = Integer.parseInt(tmps[2]);
            manitoRelation[from][to] =cost;
        }
    }
}
class Manito{
    public int from;
    public int to;
    public int cost;
    public Manito(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}