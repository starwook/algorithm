import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _2504 {
    public static int answer;
    public static boolean rightInput =true;
    public static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        int tmpNumber =1;
        for(int i=0;i<st.length();i++){
            char newChar = st.charAt(i);
            if(newChar=='(') {
                stack.add('(');
                tmpNumber*=2;
            }
            else if(newChar=='['){
                stack.add('[');
                tmpNumber*=3;
            }
            else{
                if(newChar==']'){
                    if(stack.isEmpty()||stack.peek()!='['){
                        rightInput =false;
                        break;
                    }
                    if(st.charAt(i-1)=='[')answer+=tmpNumber;
                    tmpNumber/=3;
                    stack.pop();
                }
                else if(newChar==')'){
                    if(stack.isEmpty()||stack.peek()!='('){
                        rightInput =false;
                        break;
                    }
                    if(st.charAt(i-1)=='('){
                        answer +=tmpNumber;
                    }
                    tmpNumber/=2;
                    stack.pop();
                }
                else{
                    rightInput =false;
                    break;
                }
            }
        }
        if(!rightInput || !stack.isEmpty()){
            System.out.println(0);
        }
        else{
            System.out.println(answer);
        }

    }

}
