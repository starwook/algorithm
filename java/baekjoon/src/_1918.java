import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1918 {
    public static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        stack.push('(');
        for(int i=0;i<command.length();i++){
            char c = command.charAt(i);
            if(c=='*' ||c =='/'){
                Stack<Character> tempStack = new Stack<>();
                if(command.charAt(i-1)==')'){
                    while(!stack.isEmpty()){
                        char tempC =  stack.pop();
                        tempStack.push(tempC);
                        if(tempC =='('){
                            break;
                        }
                    }
                    stack.push('(');
                    while(!tempStack.isEmpty()){
                        stack.push(tempStack.pop());
                    }
                }
                else if(command.charAt(i-1)!=')'){
                    char tempC = stack.pop();
                    stack.push('(');
                    stack.push(tempC);
                }
                stack.push(c);
                if(command.charAt(i+1)=='('){

                }
                else if(command.charAt(i+1)!='('){
                    stack.push(command.charAt(i+1));
                    stack.push(')');
                    i++;
                }
            }
            else{
                stack.push(command.charAt(i));
            }
        }
        stack.push(')');

        for(int i=0;i<stack.size();i++){
            System.out.print(stack.get(i)+" ");
        }
    }
}