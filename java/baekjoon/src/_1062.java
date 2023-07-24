import java.util.*;
public class _1062 {
    public static boolean[] arr= new boolean[26];
    public static char[] startCheck = {'a','n','c','t','i'};
    public static int answer;
    public static int n,m;
    public static List<String> strings = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        if(m<5) {
            System.out.println("0");
            return;
        }
        if(m==26){
            System.out.println(n);
            return;
        }
        for(int i=0;i<n;i++) {
            String tmp = scanner.nextLine();
            String newTmp = tmp.replace("anta","");
            newTmp = newTmp.replace("tica","");
            strings.add(newTmp);
        }
        arr['a' - 'a'] = true;
        arr['c' - 'a'] = true;
        arr['i' - 'a'] = true;
        arr['n' - 'a'] = true;
        arr['t' - 'a'] = true;
        dfs(0,0);
        System.out.println(answer);
    }
    public static void dfs(int index,int count) {
        arr[index] =true;
        if(count==m-5){ // 2.다 체크 했다면(목적지라면)
            calculateAnswer();
        }
        else{
            for(int i=index;i<26;i++){ //3.순회
                if(!arr[i]){ //4.갈수 있는가
                    dfs(i,count+1); //5.간다
                }
            }
        }
        arr[index] = false;
    }
    private static void calculateAnswer() {
        int tmpAnswer =0;
//        for(int i=0;i<arr.length;i++ ) {
//         if(arr[i]) System.out.print((char)(i+'a'));
//        }
//        System.out.println();
        for(int i=0;i<strings.size();i++){
            String tmp = strings.get(i);
            boolean isReadable = true;
            for(int j=0;j<tmp.length();j++){
                if(!arr[tmp.charAt(j)-'a']){


                    isReadable = false;
                    break;
                }
            }
            if(isReadable) tmpAnswer++;
        }
        answer = Math.max(tmpAnswer,answer);
    }
}
