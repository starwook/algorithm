import java.io.*;
class Main {
    public static int[][] arr;
    public static int xi[] = {-1,1,0,0};
    public static int yi[] = {0,0,-1,1};
    public static int totalStart=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        arr = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            String tmp = br.readLine();
            String[] tmps = tmp.split(" ");
            for(int j=1;j<=n;j++){
                arr[i][j] = Integer.parseInt(tmps[j-1]);
                if(Integer.parseInt(tmps[j-1])!=0){
                    totalStart++;
                }
            }
        }
        int day =0;
        System.out.println(totalStart);
        while(true){
            if(totalStart==0){
                break;
            }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(arr[i][j]>0){
                        for(int t=0;t<4;t++){
                            if(arr[i][j] ==0){
                                totalStart--;
                                break;
                            }
                            int newR = i+xi[t];
                            int newC = j+yi[t];
                            if(newR>=1&&newR<=n&&newC>=1&&newC<=n){
                                if(arr[newR][newC]==0){
                                    arr[i][j]--;
                                }
                            }
                        }
                    }
                }
            }
            day++;
        }
        System.out.println(day);


    }
    private static void printMap(int n) {
        for(int i1 = 1; i1 <= n; i1++){
            for(int j1 = 1; j1 <= n; j1++){
                System.out.print(arr[i1][j1]+" ");
            }
            System.out.println();
        }
    }

}