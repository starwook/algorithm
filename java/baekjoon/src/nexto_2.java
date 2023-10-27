//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.function.*;
//import java.util.regex.*;
//import java.util.stream.*;
//import static java.util.stream.Collectors.joining;
//import static java.util.stream.Collectors.toList;
//
//
//
//class Result {
//
//    /*
//     * Complete the 'findMaximumGreatness' function below.
//     *
//     * The function is expected to return an INTEGER.
//     * The function accepts INTEGER_ARRAY arr as parameter.
//     */
//
//    public static int findMaximumGreatness(List<Integer> arr) {
//        Collections.sort(arr);
//        int answer =0;
//        int lastIndex = arr.size()-1;
//        int enable = lastIndex;
//        boolean first =true;
//        while(lastIndex>0){
//            int count =1;
//            while(arr.get(lastIndex).equals(arr.get(lastIndex-1))){
//                count++;
//                lastIndex--;
//                enable--;
//                if(lastIndex==0) break;
//            }
//            if(enable-count>=0){
//                answer +=count;
//                enable -=count;
//            }
//            else{
//                if(enable<0) enable =0;
//                answer += enable;
//            }
//            lastIndex--;
//        }
//        return answer;
//        // Write your code here
//
//    }
//
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
//                    try {
//                        return bufferedReader.readLine().replaceAll("\\s+$", "");
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result.findMaximumGreatness(arr);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
