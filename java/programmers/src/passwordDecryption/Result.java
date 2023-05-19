package passwordDecryption;
import java.util.*;
import java.io.*;
class Result {

    public static String decryptPassword(String s) {
        String tmp="";
        for(int i=0;i<s.length();i++){
            if(i<s.length()-1){
                if(s.charAt(i)>'a'&&s.charAt(i)<'z' &&s.charAt(i+1)>'A'&&s.charAt(i+1)<'Z'){
                    tmp+=s.charAt(i+1);
                    tmp+=s.charAt(i);
                    tmp+='*';
                }
            }
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                tmp+='0';
            }
        }
        // Write your code here
        return tmp;

    }
}
class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.decryptPassword(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
