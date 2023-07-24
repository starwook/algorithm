import java.util.*;
public class _1062 {
    public static int[] arr= new int[26];
    public static char[] startCheck = {'a','n','c','t','i'};
    public static int answer;
    public static int n,m;
    public static int count =0;
    public static List<String> strings = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();





        scanner.nextLine();
        for(int i=0;i<n;i++) {
            String tmp = scanner.nextLine();
            String newTmp = tmp.replaceAll("[antic]","");
            strings.add(newTmp);
        }
        for(int i=0;i< startCheck.length;i++) arr[startCheck[i]-'a'] =1;
        count =5;
        for(int i=0;i<26;i++){
            if(arr[i]==0) dfs(i);
        }
        System.out.println(answer);
    }
    public static void dfs(int index) {
        arr[index] =1;//1.체크인
        count++;
        if(count==m){ // 2.다 체크 했다면(목적지라면)
            calculateAnswer();
        }
        else{
            for(int i=index+1;i<26;i++){ //3.순회
                if(arr[i]==0){ //4.갈수 있는가
                    dfs(i); //5.간다
                }
            }
        }
        arr[index] =0;//6.체크아웃
        count--;
    }
    private static void calculateAnswer() {
        int tmpAnswer =0;
//        for(int i=0;i<26;i++){
//            if(arr[i]==1) System.out.print((char)(i+'a')+" ");
//        }
//        System.out.println();
        for(int i=0;i<strings.size();i++){
            String tmp = strings.get(i);
            boolean isReadable = true;
            for(int j=0;j<tmp.length();j++){
                if(arr[tmp.charAt(j)-'a']==0){
                    isReadable = false;
                    break;
                }
            }
            if(isReadable) tmpAnswer++;
        }
        answer = Math.max(tmpAnswer,answer);
    }
}
