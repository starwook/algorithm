import java.io.*;
import java.math.*;
import java.net.HttpURLConnection;
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



class Result {

    /*
     * Complete the 'getTotalGoals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING team
     *  2. INTEGER year
     */

    public static int getTotalGoals(String team, int year) throws IOException {
        String originalUrl ="https://jsonmock.hackerrank.com/api/football_matches";
        int totalGoalsAtHome = getPageTotalGoals(originalUrl+"?year="+year+"&team1="+team);
        int totalGoalsAtAway = getPageTotalGoals(originalUrl+"?year="+year+"&team2="+team);
        return totalGoalsAtAway+totalGoalsAtHome;
    }
    public static int getPageTotalGoals(String request) throws IOException {
        URL url = new URL(request);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.addRequestProperty("Content-Type","application/json");
        InputStream in = conn.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String responseLine;
        while((responseLine =br.readLine())!=null) System.out.println(responseLine);

        br.close();
        conn.disconnect();
        return 0;

    }

}

public class hackerRank_getTotalGoals {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String team = bufferedReader.readLine();

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.getTotalGoals(team, year);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
