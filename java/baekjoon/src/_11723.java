import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _11723 {
    public static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")){
                int x = Integer.parseInt(st.nextToken());

                set.add(x);
            }
            if(command.equals("remove")){
                int x = Integer.parseInt(st.nextToken());
                set.remove(x);
            }
            if(command.equals("check")){
                int x = Integer.parseInt(st.nextToken());
                if(set.contains(x)){
                    bw.write("1\n");
                }
                else{
                    bw.write("0\n");
                }
            }
            if(command.equals("toggle")){
                int x = Integer.parseInt(st.nextToken());
                if(set.contains(x)){
                    set.remove(x);
                }
                else{
                    set.add(x);
                }
            }
            if(command.equals("all")){
                set.clear();
                for(int j=1;j<=20;j++) set.add(j);
            }
            if(command.equals("empty")){
                set.clear();
            }
        }
        bw.close();

    }
}
