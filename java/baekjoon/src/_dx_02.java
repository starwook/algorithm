
import java.util.*;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static int N,M,Q;
    public static int[] arr = new int[200000];
    public static int[] rMax = new int[200000];
    public static int[] cMax = new int[200000];
    public static int answer =0;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();sc.nextLine();
        for (int test_case = 1; test_case <= T; test_case++) {
            arr = new int[200000];
            answer =0;
            int firstNumber=0;
            String tmp = sc.nextLine();
            String[] tmps = tmp.split(" ");
            N = Integer.parseInt(tmps[0]);
            M = Integer.parseInt(tmps[1]);
            Q = Integer.parseInt(tmps[2]);
            for (int i = 0; i < N; i++) {
                String inform = sc.nextLine();
                String[] informs = inform.split(" ");
                for (int j = 0; j < M; j++) {
                    int newNumber = Integer.parseInt(informs[j]);
                    arr[N *i+j] = newNumber;
                    if(arr[N*i + rMax[i]]<newNumber) rMax[i] = j;
                    if(arr[cMax[j]*N+j]<newNumber) cMax[j] = i;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(rMax[i]==j&&cMax[j]==i){
                        firstNumber++;
                    }
                }
            }
            int tmpAnswer = firstNumber;
            for(int i=0;i<Q;i++){
                tmp = sc.nextLine();
                tmps = tmp.split(" ");
                int r=Integer.parseInt(tmps[0])-1;
                int c =Integer.parseInt(tmps[1])-1;
                int x = Integer.parseInt(tmps[2]);
                if(rMax[r]==c&&cMax[c]==r){
                    answer+=tmpAnswer;
                    arr[r*N+c] =x;
                    continue;
                }
                //안전한 셀이 아닐 경우만 확인
                if(rMax[r]!=c){ // 같은 행 중에 최대값이 아닐 경우
                    int rMaxNumber = arr[N*r+rMax[r]];
                    if(rMaxNumber<x){
                        if(cMax[rMax[r]] ==r){
                            tmpAnswer--;
                        }
                        rMax[r] =c;
                    }
                }
                if(cMax[c]!=r){ //같은 열중에 최댓값이 아닐 경우
                    int cMaxNumber = arr[N*cMax[c]+c];
                    if(cMaxNumber<x){
                        if(rMax[cMax[c]]==c){
                            tmpAnswer--;
                        }
                        cMax[c] =r;
                    }
                }
                if(rMax[r] ==c&&cMax[c] ==r) tmpAnswer++;
                answer += tmpAnswer;
                arr[r*N+c] = x;
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}