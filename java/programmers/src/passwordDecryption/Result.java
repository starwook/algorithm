package passwordDecryption;
import java.util.*;
import java.io.*;
class Result {

    public static String decryptPassword(String s) {
        String tmp="";
        Queue<Character> charStack = new LinkedList<>();
        Stack<Character> intStack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='1'&&s.charAt(i)<='9') {
                intStack.add(s.charAt(i));
                continue;
            }
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                charStack.add(s.charAt(i));
            }
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                charStack.add(s.charAt(i));
            }
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                tmp+= intStack.pop();
                continue;
            }
            if(s.charAt(i) =='*'){
                char last = tmp.charAt(tmp.length()-1);
                char first = tmp.charAt(tmp.length()-2);
                tmp = tmp.substring(0,tmp.length()-2)+last+first;
                continue;
            }
            if(!charStack.isEmpty() &&s.charAt(i) == charStack.peek()){
                tmp+=charStack.poll();
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
