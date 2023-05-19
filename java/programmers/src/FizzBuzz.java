import  java.io.*;
import java.util.*;
public class FizzBuzz {
    public static void fizzBuzz(int n) {
        // Write your code here
        for(int i=1;i<=n;i++){
            if(i%3==0){
                if(i%5==0){
                    System.out.println("FizzBuzz");
                    continue;
                }
                System.out.println("Fizz");
                continue;
            }
            if(i%5==0){
                System.out.println("Buzz");
                continue;
            }
            System.out.println(i);

        }

    }
}
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        FizzBuzz.fizzBuzz(n);

        bufferedReader.close();
    }
}
