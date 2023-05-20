import java.io.*;
import java.math.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result4 {

    /*
     * Complete the 'bestInGenre' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING genre as parameter.
     *
     * Base URL: https://jsonmock.hackerrank.com/api/tvseries?page=
     */
    public static URL url;

    static {
        try {
            url = new URL("https://jsonmock.hackerrank.com/api/tvseries");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static String bestInGenre(String genre) {

        // Write your code here
        return url.toString();

    }

}

public class 장르별_최고의_TV_프로그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String genre = bufferedReader.readLine();

        String result = Result4.bestInGenre(genre);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
