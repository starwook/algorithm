import java.util.*;
import java.io.*;
class Alphabet{
    char value;
    int  cnt;
    Alphabet(char value){
        this.value = value;
        this.cnt =0;
    }
    public void setCnt(int a){
        this.cnt+=a;
    }

}
class 소프티어_1 {
    public static List<Character> alphabets = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        String answer = "";
        for(int i=0;i<n;i++){
            String tmp = br.readLine();
            String[] tmps = tmp.split(" ");
            if(tmps[0].equals("enqueue")){
                Character toAdd = tmps[1].charAt(0);
                alphabets.add(toAdd);
            }
            if(tmps[0].equals("dequeue")){
                if(alphabets.isEmpty()) {
                    if(!answer.equals("")) answer +=" ";
                    answer +="*";
                    continue;
                }
                Map<Character,Integer> alphabetCnts = new LinkedHashMap<>();
                for(int j=0;j<alphabets.size();j++){
                    char toCount = alphabets.get(j);
                    if(alphabetCnts.containsKey(toCount)){
                        alphabetCnts.put(toCount,alphabetCnts.get(toCount)+1);
                        continue;
                    }
                    alphabetCnts.put(toCount,1);
                }
                List<Character> keySet = new ArrayList<>(alphabetCnts.keySet());
                keySet.sort(new Comparator<Character>() {
                    @Override
                    public int compare(Character o1, Character o2) {
                        return alphabetCnts.get(o2)-alphabetCnts.get(o1);
                    }
                });
                for(int j=0;j<alphabets.size();j++){
                    if(alphabets.get(j)== keySet.get(0)){
                        if(!answer.equals("")) answer +=" ";
                        answer +=alphabets.get(j);
                        alphabets.remove(j);
                        break;
                    }
                }

            }


        }
        System.out.println(answer);
    }

    /*private static void extracted(Character toAdd) {
        alphabets.add(toAdd);
        if(alphabetCnts.containsKey(toAdd)){
            alphabetCnts.put(toAdd,alphabetCnts.get(toAdd)+1);
        }
        else{
            alphabetCnts.put(toAdd,1);
        }
    }*/
}

