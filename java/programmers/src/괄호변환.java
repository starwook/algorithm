import java.util.*;
public class 괄호변환 {
    StringBuilder sb = new StringBuilder();
    public String solution(String p) {

        if(checkRight(p)) return p;
        String answer = forU(p);
        return answer;
    }
    public String forU(String str){

        if(str.length()==0){
            return "";
        }
        int leftCnt =0;
        int rightCnt =0;
        String tmp ="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                leftCnt++;
            }
            if(str.charAt(i)==')'){
                rightCnt++;
            }
            if(leftCnt==rightCnt){ //균형잡힌
                if(checkRight(str.substring(0,i+1))){ //올바르다면

                    tmp= str.substring(0,i+1)+forU(str.substring(i+1,str.length()));
                }
                else{

                    tmp= "("+forU(str.substring(i+1,str.length()))+")" + reverseStr(str.substring(1,i));
                }
                break;
            }
        }
        return tmp;
    }
    public String reverseStr(String str){

        String tmp  ="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                tmp+=")";
            }
            else{
                tmp+="(";
            }
        }

        return tmp;
    }
    public boolean checkRight(String str){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                st.push(str.charAt(i));
            }
            if(str.charAt(i)==')') {
                if (st.isEmpty()) return false;
                st.pop();
            }
        }
        return true;
    }
}
