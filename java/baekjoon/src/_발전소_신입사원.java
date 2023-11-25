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
//     * Complete the 'GetMaxTime' function below.
//     *
//     * The function is expected to return an INTEGER.
//     * The function accepts following parameters:
//     *  1. INTEGER_ARRAY initialEnergy
//     *  2. LONG_INTEGER th
//     */
//
//    public static int GetMaxTime(List<Integer> initialEnergy, long th) {
//        int time =0;
//        long startEnergy =0;
//        int index =0;
//        Collections.sort(initialEnergy);
//        for(int i=0;i<initialEnergy.size();i++) startEnergy+=initialEnergy.get(i);
//        while(true){
//            time++;
//            startEnergy-=initialEnergy.size();
//            while(initialEnergy.get(index)<time) index++;
//            startEnergy+=(index);
//            if(startEnergy<th) break;
//        }
//        return time-1;
//        // Write your code here
//    }
//
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int initialEnergyCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> initialEnergy = IntStream.range(0, initialEnergyCount).mapToObj(i -> {
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
//        long th = Long.parseLong(bufferedReader.readLine().trim());
//
//        int result = Result.GetMaxTime(initialEnergy, th);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
