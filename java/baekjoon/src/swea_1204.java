
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class swea_1204
{
    public static int T,answer,N,minR,minC,maxR,maxC;
    public static int[][] arr;
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {


            N = Integer.parseInt(br.readLine());
            minR =1;
            minC =1;
            maxR = N;
            maxC = N;
            arr = new int[N+1][N+1];
            roll(1,1,1);
            System.out.println("#"+test_case+" ");
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    System.out.print(arr[i][j] +" ");
                }
                System.out.println();
            }


        }
    }
    static void roll(int r,int c, int number){
        if(number>N*N) return;
        if(r==minR){
            if(c==minC){
                for(int i=minC;i<=maxC;i++){
                    arr[r][i] = number;
                    number++;
                }
                minR++;
                roll(minR,maxC,number);

            }
            else if(c==maxC){
                for(int i= minR;i<=maxR;i++){
                    arr[i][c] = number;
                    number++;
                }
                maxC--;
                roll(maxR,maxC,number);
            }
            return;
        }
        if(r==maxR){
            if(c==maxC){
                for(int i = maxC;i>=minC;i--){
                    arr[r][i] = number;
                    number++;
                }
                maxR--;
                roll(maxR,minC,number);
            }
            else if(c==minC){
                for(int i=maxR;i>=minR;i--){
                    arr[i][c] = number;
                    number++;
                }
                minC++;
                roll(minR,minC,number);
            }
        }
    }
}