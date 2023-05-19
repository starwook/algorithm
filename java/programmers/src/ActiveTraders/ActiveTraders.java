package ActiveTraders;
import java.util.*;
import java.io.*;

class Result {

    /*
     * Complete the 'mostActive' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY customers as parameter.
     */
    public static Map<String,Integer> map = new LinkedHashMap<>();
    public static List<String> mostActive(List<String> customers) {

        double tmp = customers.size()/20.0;
        System.out.println(tmp);
        List<String> customersSelected = new ArrayList<>();
        for(int i=0;i< customers.size();i++){
            if(map.containsKey(customers.get(i))){
                map.put(customers.get(i),map.get(customers.get(i))+1);
                continue;
            }
            map.put(customers.get(i),0);
        }
        for(String string : map.keySet()){
            if(map.get(string) >= tmp){
                customersSelected.add(string);
            }
        }
        Collections.sort(customersSelected);
        // Write your code here
        return customersSelected;

    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int customersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> customers = IntStream.range(0, customersCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.mostActive(customers);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
