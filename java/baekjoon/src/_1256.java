import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1256 {
    public static int aNum, zNum,k;
    public static int[][] dp = new int[101][101];
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        aNum = Integer.parseInt(st.nextToken());
        zNum = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        init(aNum,zNum);
        if(k>dp[aNum][zNum]){
            System.out.println(-1);
            return;
        }
        System.out.println(findAnswer(aNum,zNum,k));

    }
    public static String findAnswer(int a,int z,int tmpK){
        String ret ="";
        if(a==0){
            for(int i=0;i<z;i++){
                ret+='z';
            }
            return ret;
        }
        if(z==0){
            for(int i=0;i<a;i++){
                ret+='a';
            }
            return ret;
        }
        int check = init(a-1,z);
        if(tmpK<=check){
            ret ='a'+findAnswer(a-1,z,tmpK);
        }
        else{
            ret= 'z'+findAnswer(a,z-1,tmpK-check);
        }
        return ret;
    }
    public static int init(int a,int z){

        if(a==0 ||z==0){
            dp[a][z] =1;
            return dp[a][z];
        }
        if(dp[a][z]!=0){
            return dp[a][z];
        }
        dp[a][z] = Math.min(init(a-1,z)+init(a,z-1),1000000001);
        return dp[a][z];
    }
}
