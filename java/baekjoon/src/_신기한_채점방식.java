import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'GetMaxScore' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static int dp[][];
    public static int GetMaxScore(List<Integer> scores) {
        // Write your code here
        dp = new int[scores.size()][2];
        dp[0][0] = 0;
        dp[0][1] = scores.get(0);
        for(int i=1;i<scores.size();i++){
            dp[i][0] = dp[i-1][1];
            dp[i][1] =  Math.max(dp[i-1][1],dp[i-1][0]) +scores.get(i);
        }
        return Math.max(dp[scores.size()-1][0],dp[scores.size()-1][1]);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = IntStream.range(0, scoresCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.GetMaxScore(scores);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
