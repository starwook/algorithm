
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
    public static int[] visited = new int[200000];
    public static int[] rMax = new int[200000];
    public static int[] cMax = new int[200000];
    public static List<Integer> rMaxs = new ArrayList<>();
    public static List<Integer> cMaxs = new ArrayList<>();
    public static int answer =0;
    public static void main(String args[]) throws Exception {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();sc.nextLine();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            arr = new int[200000];
            visited = new int[200000];
            rMaxs = new ArrayList<>();
            cMaxs = new ArrayList<>();
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
                    if(newNumber>rMax[i]) rMax[i] = newNumber;
                    if(newNumber>cMax[j]) cMax[j] = newNumber;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[N*i+j]==rMax[i]&&arr[N*i+j]==cMax[j]){


                    }
                }
            }
            int tmpAnswer = firstNumber;
            for(int i=0;i<Q;i++){
                tmp = sc.nextLine();
                tmps = tmp.split(" ");
                int r=Integer.parseInt(tmps[0]);
                int c =Integer.parseInt(tmps[1]);
                int x = Integer.parseInt(tmps[2]);
                int originalNumber = arr[r*N+c];
                if(rMax[r]==c &&cMax[c]==r){ //해당 셀이 안전한 셀이었다면
                    if(x>rMax[r]) rMax[r] = x;
                    if(x>cMax[c]) cMax[c] = x;
                    if(rMax[r]!=cMax[c]) tmpAnswer--;
                }
                if(rMax[r]!=cMax[c] ||rMax[r] !=originalNumber){ //해당 셀이 안전한 셀이 아니였다면
                    if(x>rMax[r]) rMax[r] = x;
                    if(x>cMax[c]) cMax[c] = x;
                    if(rMax[r] ==cMax[c]) tmpAnswer++;
                }
                answer += tmpAnswer;
                System.out.println(tmpAnswer);
                arr[r*N+c] = x;
            }
            System.out.println("#"+test_case+" "+answer);
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
        }
    }
}