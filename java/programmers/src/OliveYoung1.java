public class OliveYoung1 {

    public static void main(String[] args) {

        String number = new String();
        int answer =0;
        boolean refresh = true;
        for(int i=0;i<number.length();i++){
            answer++;
            if(number.charAt(i) =='0'){ //0이라면 다음으로
                continue;
            }
            if(i==number.length()-1){ //마지막이라면
                answer++; //지워줌
                continue;
            }
            if(number.charAt(i+1) ==number.charAt(i)+'1'){ //다음 것이 같다면
                i++;
                continue;
            }
            answer++;
            System.out.println();
        }

    }

}
