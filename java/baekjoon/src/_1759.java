import java.util.*;
public class _1759 {
    public static int l,c;
    public static String str;
    public static char[] chars;
    public static char[] moEum ={'a','e','i','o','u'};
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        l = scanner.nextInt();
        c = scanner.nextInt();
        chars = new char[c];
        scanner.nextLine();
        String[] tmpStr = scanner.nextLine().split(" ");
        for(int i=0;i<c;i++) chars[i] = tmpStr[i].charAt(0);
        Arrays.sort(chars);
        dfs(0,"");

    }
    public static void dfs(int index,String tmp){
        if(tmp.length() ==l){
            printIfPass(tmp);
        }
        else{
            for(int i=index;i<c;i++){
                dfs(i+1,tmp+chars[i]);
            }
        }

    }
    public static void printIfPass(String s){
        int moEumCount =0;
        int jaEumCount =0;
        for(int i=0;i<s.length();i++){
            boolean isMoEum = false;
            for(int j=0;j<moEum.length;j++){
                if(s.charAt(i)== moEum[j]) {
                    isMoEum = true;
                    break;
                }
            }
            if(isMoEum) moEumCount++;
            else jaEumCount++;
        }
        if(moEumCount>=1&& jaEumCount>=2) System.out.println(s);
    }
}
