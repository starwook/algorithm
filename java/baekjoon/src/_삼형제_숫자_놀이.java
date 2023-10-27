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
     * Complete the 'three_numbers' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER t
     *  2. INTEGER_ARRAY d
     */

    public static long three_numbers(int t, List<Integer> d) {
        long answer =0;
        Collections.sort(d);
        for(int first=0;first<d.size()-2;first++){
            int second = first+1;
            int third = d.size()-1;

            while(second<third){
                int sum = d.get(first)+d.get(second)+d.get(third);
                if(sum<=t){
                    for(int k=third;k>second;k--){
                        answer++;
                    }
                    second++;
                }
                else{
                    third--;
                }
            }
        }
        return answer;
        // Write your code here

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        int dCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> d = IntStream.range(0, dCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.three_numbers(t, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
