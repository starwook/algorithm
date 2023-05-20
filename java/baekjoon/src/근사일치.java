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



class Result2 {

    /*
     * Complete the 'calculateScore' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING text
     *  2. STRING prefixString
     *  3. STRING suffixString
     */
    public static List<String> allText = new ArrayList<>();
    public static String calculateScore(String text, String prefixString, String suffixString) {
        for(int i=0;i<text.length();i++){
            String firstText =text.substring(0,i);
            String nextText = text.substring(i,text.length());
            makeAllStrings(firstText,nextText,prefixString,suffixString);

        }
        System.out.println(allText);
        Collections.sort(allText, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        // Write your code here
        return "";

    }

    private static void makeAllStrings(String firstText,String secondText,String prefixString,String suffixString){

        if(firstText ==""){
            for(int x=0;x<secondText.length();x++){
                for(int y=x+1;y<=secondText.length();y++){
                    String secondTmp = secondText.substring(x,y);
                    if(suffixString.startsWith(secondTmp)){
                        addToAllText(secondTmp);
                    }
                }
            }
        }
        else if(secondText ==""){
            for(int i=0;i<firstText.length();i++){
                for(int j=i+1;j<=firstText.length();j++){
                    String firstTmp = firstText.substring(i,j);
                    if(prefixString.endsWith(firstTmp)){
                        addToAllText(firstTmp);
                    }
                }
            }
        }
        else{
            for(int i=0;i<firstText.length();i++){
                for(int j=i+1;j<=firstText.length();j++){
                    String firstTmp = firstText.substring(i,j);
                    for(int x=0;x<secondText.length();x++){
                        for(int y=x+1;y<=secondText.length();y++){
                            String secondTmp = secondText.substring(x,y);
                            String tmp ="";
                            if(prefixString.endsWith(firstTmp)
                                    && suffixString.startsWith(secondTmp)){
                                addToAllText(firstText.substring(i) + secondText.substring(x));
                            }

                        }
                    }
                }
            }
        }
    }

};


//    private static void makeAllStrings(String firstText,String secondText,String prefixString,String suffixString){
//        List<String> firsts = new ArrayList<>();
//        List<String> seconds = new ArrayList<>();
//
//        System.out.println(firstText+"!!"+secondText);
//        for(int i=0;i<firstText.length();i++){
//            for(int j=i+1;j<=firstText.length();j++){
//                String firstTmp = firstText.substring(i,j);
//                firsts.add(firstTmp);
//            }
//        }
//        for(int x=0;x<secondText.length();x++){
//            for(int y=x+1;y<=secondText.length();y++){
//                String secondTmp = secondText.substring(x,y);
//                seconds.add(secondTmp);
//            }
//        }
//        if(firsts.size()==0){
//            for(int i=0;i<seconds.size();i++){
//                if(suffixString.startsWith(seconds.get(i))){
//                    if(!allText.contains(seconds.get(i))){
//                        allText.add(seconds.get(i));
//                    }
//
//                }
//            }
//        }
//        else if(seconds.size()==0){
//            for(int j=0;j<firsts.size();j++){
//                if(prefixString.endsWith(firsts.get(j))){
//                    if(!allText.contains(seconds.get(j))){
//                        allText.add(firsts.get(j));
//                    }
//
//                }
//            }
//        }
//        else{
//            for(int i=0;i<firsts.size();i++){
//                for(int j=0;j<seconds.size();j++){
//                    String tmp = "";
//                    if(prefixString.endsWith(firsts.get(i))){
//                        tmp+=firsts.get(i);
//                    }
//                    if(suffixString.startsWith(seconds.get(j))){
//                        tmp+=seconds.get(j);
//                    }
//                    if(!allText.contains(tmp)){
//                        allText.add(tmp);
//                    }
//
//                }
//            }
//        }
//    }



public class 근사일치 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String text = bufferedReader.readLine();

        String prefixString = bufferedReader.readLine();

        String suffixString = bufferedReader.readLine();

        String result = Result2.calculateScore(text, prefixString, suffixString);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
