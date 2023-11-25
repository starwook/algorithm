//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
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
//     * Complete the 'extractErrorLogs' function below.
//     *
//     * The function is expected to return a 2D_STRING_ARRAY.
//     * The function accepts 2D_STRING_ARRAY logs as parameter.
//     */
//    public static List<Log> logList= new ArrayList<>();
//
//    public static class Log{
//        LocalDateTime localDateTime;
//        String reason;
//        String status;
//
//        public Log(LocalDateTime localDateTime, String reason,String status) {
//            this.localDateTime = localDateTime;
//            this.reason = reason;
//            this.status = status;
//        }
//    }
//    public static List<List<String>> extractErrorLogs(List<List<String>> logs) {
//        // Write your code here
//
//        for(int i=0;i<logs.size();i++){
//            String year = logs.get(i).get(0);
//            String time = logs.get(i).get(1);
//            String status = logs.get(i).get(3);
//            String reason = logs.get(i).get(2);
//            if(reason.equals("ERROR") || reason.equals("CRITICAL")){
//                String[] years = year.split("-");
//                String[] times = time.split(":");
//                LocalDateTime localDateTime = LocalDateTime.of(Integer.parseInt(years[2]),Integer.parseInt(years[1]),Integer.parseInt(years[0])
//                        ,Integer.parseInt(times[0]),Integer.parseInt(times[1]));
//                Log log = new Log(localDateTime,reason,status);
//                logList.add(log);
//            }
//        }
//        List<List<String>> answer = new ArrayList<>();
//        Collections.sort(logList,((o1, o2) -> o1.localDateTime.compareTo(o2.localDateTime)));
//        for(int i=0;i<logList.size();i++){
//            List<String> tmpAnswer = new ArrayList<>();
//            Log log = logList.get(i);
//            String day = String.format("%02d",log.localDateTime.getDayOfMonth());
//            String month = String.format("%02d",log.localDateTime.getMonthValue());
//            String minute = String.format("%02d",log.localDateTime.getMinute());
//            String hour = String.format("%02d",log.localDateTime.getHour());
//            String year = String.format("%04d",log.localDateTime.getYear());
//            tmpAnswer.add(day+"-"+month+"-"+log.localDateTime.getYear()+" "
//                    +hour+":"+minute+" "+log.reason+" "+log.status);
//            answer.add(tmpAnswer);
//        }
//
//        return answer;
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
//        int logsRows = Integer.parseInt(bufferedReader.readLine().trim());
//        int logsColumns = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<List<String>> logs = new ArrayList<>();
//
//        IntStream.range(0, logsRows).forEach(i -> {
//            try {
//                logs.add(
//                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                .collect(toList())
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        List<List<String>> result = Result.extractErrorLogs(logs);
//
//        result.stream()
//                .map(
//                        r -> r.stream()
//                                .collect(joining(" "))
//                )
//                .map(r -> r + "\n")
//                .collect(toList())
//                .forEach(e -> {
//                    try {
//                        bufferedWriter.write(e);
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                });
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
