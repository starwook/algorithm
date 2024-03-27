public class k진수에서 {
    class Solution {
        public String tmpNumber ="";
        public int answer = 0;
        public int solution(int n, int k) {

            StringBuilder number = change(n,k);
            number = number.reverse();
            String[] numbers = number.toString().split("0");
            for(String tmp : numbers){
                tmpNumber = tmp;
                if(!tmpNumber.isEmpty()&&check()&&!tmpNumber.equals("1")) answer++;
            }
            return answer;
        }

        public boolean check(){
            long realNumber = Long.parseLong(tmpNumber);
            for(int i=2;i<=Math.sqrt(realNumber);i++){
                if(realNumber%i ==0 ) return false;
            }
            return true;
        }
        public StringBuilder change(int n,int k){
            String tmp ="";
            while(n>0){
                tmp += (n%k);
                n = n/k;
            }
            return new StringBuilder(tmp);
        }
    }
}
