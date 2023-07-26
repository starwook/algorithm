import java.io.*;
class 연산_키워드 {
    public static String[] commands;
    public static String answer ="";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        commands = input.split(" ");
        answer += makeString("",commands[commands.length-1],commands.length-2);
        System.out.println(answer);

    }
    public static String makeString(String type,String tmp,int index){
        if(index<=0) return "";
        String toAdd = commands[index];
        String nextType= commands[index+1];
        String toAddString = makeAfter(tmp)+makeAfter(tmp);
        String newTmp ="";
        if(nextType ==">"){
            newTmp+= makeBefore(toAdd);
            newTmp+="\n  ";
            newTmp+=toAddString;
            newTmp+="\n";
            newTmp+=makeAfter(toAdd);
        }
        if(nextType =="+"){
            newTmp+=makeBefore(toAdd);
            newTmp+=makeAfter(toAdd);
            newTmp+="\n";
            newTmp+=toAddString;
        }

        if(nextType=="*"){
           for(int i=0;i<Integer.parseInt(tmp);i++){
               newTmp+=makeBefore(toAdd);
               newTmp+=makeAfter(toAdd);
               newTmp+="\n";
           }

        }
        return makeString("",newTmp,index-2);

    };
    public static String makeBefore(String str){
        return "<"+str+">";
    }
    public static String makeAfter(String str){
        return "</"+str+">";
    }

}