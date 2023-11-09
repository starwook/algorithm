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
//     * Complete the 'minimumMovement' function below.
//     *
//     * The function is expected to return an INTEGER.
//     * The function accepts INTEGER_ARRAY obstacleLanes as parameter.
//     */
//    public static int startIndex =2;
//    public static int answer =100001;
//    public static List<Integer> lanes;
//    public static int laneLength;
//    public static int[][] dp;
//    public static int minimumMovement(List<Integer> obstacleLanes) {
//
//        lanes = obstacleLanes;
//        laneLength = obstacleLanes.size();
//        dp = new int[laneLength+1][4];
//        for(int i=0;i<=laneLength;i++){
//            for(int position=1;position<=3;position++){
//                dp[i][position] = 100001;
//            }
//        }
//        dp[0][startIndex] = 0;
//        // Write your code here
////        getAllLine(0,2,0);
//        for(int i=1;i<=laneLength;i++){
//            if(obstacleLanes.get(i-1)==1){
//                dp[i][2] = Math.min(dp[i-1][1]+1,dp[i-1][3]+1);
//                dp[i][2] = Math.min(dp[i-1][2],dp[i][2]);
//
//                dp[i][3] = Math.min(dp[i-1][2]+1,dp[i-1][1]+1);
//                dp[i][3] = Math.min(dp[i-1][3],dp[i][3]);
//            }
//            if(obstacleLanes.get(i-1)==2){
//                dp[i][1] = Math.min(dp[i-1][2]+1,dp[i-1][3]+1);
//                dp[i][1] = Math.min(dp[i-1][1],dp[i][1]);
//
//                dp[i][3] = Math.min(dp[i-1][2]+1,dp[i-1][1]+1);
//                dp[i][3] = Math.min(dp[i-1][3],dp[i][3]);
//            }
//            if(obstacleLanes.get(i-1)==3){
//                dp[i][2] = Math.min(dp[i-1][1]+1,dp[i-1][3]+1);
//                dp[i][2] = Math.min(dp[i-1][2],dp[i][2]);
//
//                dp[i][1] = Math.min(dp[i-1][2]+1,dp[i-1][3]+1);
//                dp[i][1] = Math.min(dp[i-1][1],dp[i][1]);
//            }
//        }
//        for(int i=1;i<=3;i++) answer = Math.min(answer,dp[laneLength][i]);
//        return answer;
//    }
//    public static void getAllLine(int index,int position,int moveCount){
//        if(index==laneLength) {
//            answer = Math.min(answer, moveCount);
//            return;
//        }
//        if(dp[index][position-1]<moveCount) {
//            System.out.println("더욱 ㅋ높음"+position+"/"+index);
//            return;
//        }
//        dp[index][position-1] =moveCount;
//        if(lanes.get(index)!=position) {
//            getAllLine(index + 1, position, moveCount);
//            return;
//        }
//        if(position==1){
//            getAllLine(index+1,2,moveCount+1);
//            getAllLine(index+1,3,moveCount+1);
//        }
//        if(position==2){
//            getAllLine(index+1,1,moveCount+1);
//            getAllLine(index+1,3,moveCount+1);
//        }
//        if(position==3){
//            getAllLine(index+1,1,moveCount+1);
//            getAllLine(index+1,2,moveCount+1);
//        }
//    }
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int obstacleLanesCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> obstacleLanes = IntStream.range(0, obstacleLanesCount).mapToObj(i -> {
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
//        int result = Result.minimumMovement(obstacleLanes);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
