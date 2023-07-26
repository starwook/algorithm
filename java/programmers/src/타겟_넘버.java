public class 타겟_넘버 {
    public static void main(String[] args) {

    }
    static char PLUS ='+';
    static char MINUS ='-';
    static int lastIndex;
    static int answer = 0;
    static String[][] visited = new String[50][50];
    public int solution(int[] numbers, int target) {
        lastIndex = numbers.length;
        checkEveryCount(0,0,target,numbers);
        return answer;
    }
    public void checkEveryCount(int index,int sum,int target,int[] numbers){
        if(index==lastIndex){
            if(sum ==target){
                answer++;
            }
            return;
        }
        checkEveryCount(index+1,sum-numbers[index],target,numbers);
        checkEveryCount(index+1,sum+numbers[index],target,numbers);
    }

}
