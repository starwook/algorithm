import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _5568 {
    public static int N,K;
    public static int[] arr;
    public static boolean[] visited;
    public static Set<String> words = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        K = Integer.parseInt(bf.readLine());
        visited = new boolean[N];
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(bf.readLine());
        }
        dfs("",0);
        System.out.println(words.size());
    }
    public static void dfs(String tmp,int index){
        if(index==K){
            words.add(tmp);
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] =true;
                dfs(tmp+arr[i],index+1);
                visited[i] =false;
            }
        }
    }
}
