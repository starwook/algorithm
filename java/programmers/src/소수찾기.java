import java.util.*;
public class 소수찾기 {
    Set<Integer> numberSet = new LinkedHashSet<>();
    int answer = 0;
    public int solution(String numbers) {
        bf(numbers,"");
        for(Integer number : numberSet){
            if(isPrime(number)) answer++;
        }
        System.out.println(numberSet);
        return answer;
    }
    public void bf(String number,String tmpNumber){
        if(!tmpNumber.equals("")){
            numberSet.add(Integer.valueOf(tmpNumber));
        }
        for(int i=0;i<number.length();i++){
            bf(number.substring(0,i)+number.substring(i+1),tmpNumber+number.charAt(i));
        }
    }

    public boolean isPrime(int num) {
        if (num == 0 || num == 1)
            return false;

        int lim = (int)Math.sqrt(num);

        for (int i = 2; i <= lim; i++)
            if (num % i == 0)
                return false;

        return true;
    }
}
