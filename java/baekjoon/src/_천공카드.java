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
//     * Complete the 'autocompletes' function below.
//     *
//     * The function is expected to return an INTEGER_ARRAY.
//     * The function accepts STRING_ARRAY inputs as parameter.
//     */
//
//    public static List<Node> nodes = new ArrayList<>();
//    public static List<String> numbers = new ArrayList<>();
//    public static List<Integer> answer = new ArrayList<>();
//    public static List<Integer> autocompletes(List<String> inputs) {
//        for(int i=0;i<inputs.size();i++){
//            String card = inputs.get(i);
//            getNumber(card,inputs);
//        }
//        // Write your code here
//        return answer;
//    }
//    public static void getNumber(String card,List<String> inputs){
//        boolean found = false;
//        for(int j=card.length();j>0;j--){
//            String subString = card.substring(0,j);
//            for(int k=numbers.size()-1;k>=0;k--){
//                if(numbers.get(k).startsWith(subString)){
//                    found =true;
//                    answer.add(k);
//                    numbers.add(card);
//                    return;
//                }
//            }
//        }
//        numbers.add(card);
//        answer.add(inputs.size()-1);
//    }
//    public static class Node{
//        int nowNum;
//        List<Integer> nextNumber = new ArrayList<>();
//        boolean end;
//    }
//
//}
//
//public class _천공카드 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int inputsCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> inputs = IntStream.range(0, inputsCount).mapToObj(i -> {
//                    try {
//                        return bufferedReader.readLine();
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                })
//                .collect(toList());
//
//        List<Integer> result = Result.autocompletes(inputs);
//
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
