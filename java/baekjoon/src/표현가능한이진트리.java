public class 표현가능한이진트리 {
    class Solution {
        String binary;
        public int[] solution(long[] numbers) {
            int[] answer = new int[numbers.length];
            for(int i=0;i<numbers.length;i++){

                binary = Long.toBinaryString(numbers[i]);
                int startNum =2;
                while(startNum<=binary.length()){
                    startNum*=2;
                }
                int deep = startNum-binary.length()-1;
                for(int j=0;j<deep;j++){
                    binary = "0"+binary;
                }
//                System.out.println(startNum);
//                System.out.println(binary);
//                if(binary.charAt())
                boolean flag = checkTree(0,binary.length()-1);
//                System.out.println(flag);
                if(flag) {
                    answer[i] =1;
//                    System.out.println(answer[i]);
                }
            }
            return answer;
        }
        public boolean checkTree(int start,int end){
            if(start >=end) return true;
            int root = (start+end)/2;
//            /**/System.out.println(root+":root");
            if(binary.charAt(root)=='0') {
                for(int i=start;i<=end;i++){
                    if(binary.charAt(i)=='1') return false;
                }
                /*System.out.println("binary.charAt:"+ binary.charAt(root));*/
                return true;
            }
            return checkTree(start,root-1)&&checkTree(root+1,end);
        }
    }
}