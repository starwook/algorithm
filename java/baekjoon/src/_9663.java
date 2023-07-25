import java.util.*;

public class _9663 {
    public static int n;
    public static int answer;
    public static int[] colIndex;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();scanner.nextLine();
        colIndex = new int[n];
        Arrays.fill(colIndex,-1);
        for(int i=0;i<n;i++){
            nQueen(0,i,1);
        }
        System.out.println(answer);

    }
    public static void nQueen(int r,int c,int count){

        colIndex[r] =c; //1.체크인
//        for(int i=0;i<n;i++ ) System.out.print(colIndex[i]);
//        System.out.println();
        if(count==n){//2.목적지인가
            answer++;
        }
        else{
            int nextR=r+1;
            if(nextR<n){
                for(int nextC=0;nextC<n;nextC++){ //3.순회한다
                    boolean canPut = true;
                    for(int i=0;i<=r;i++){
                        if(colIndex[i] == nextC){ //4.이미 같은 열에 있다면 스킵
                            canPut = false;
                            break;
                        }
                    }
                    if(!canPut) continue;
                    int index =1;
                    for(int i=r;i>=0;i--){;
                        if(colIndex[i] ==nextC+index|| colIndex[i] ==nextC-index){
                            canPut = false;
                            break;
                        }
                        index++;
                    }
                    if(!canPut) continue;
                    nQueen(nextR,nextC,count+1); //5.간다
                }
            }
        }
        colIndex[r] =-1;//6.체크아웃

    }
}
