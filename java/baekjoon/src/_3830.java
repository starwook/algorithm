import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _3830 {
    public static int[] distance,parent;
    public static int N,M;
    public static int find(int num){
        if(parent[num]<0) return num;
        int r = find(parent[num]); //최신화부터 해주기
        distance[num] += distance[parent[num]]; //최신화가 된 원래 부모의 DISTANCE를 더해줘야함
        //distance[parent[num]] 은 한 번 통합이 되고나서부턴 언제나 0
        //계속 재귀해도 문제없음
        //하지만 처음 UNION하고 나서의 find할 때는 원래 부모의 거리를 더해줌
        return parent[num] =r;

    }
    public static void union(int light,int heavy,int diff){
        int lightRoot = find(light);
        int heavyRoot = find(heavy);
        if(lightRoot==heavyRoot) return;
        parent[heavyRoot] = lightRoot;
        int distanceToHeavy = distance[light]+diff;
        distance[heavyRoot] = distanceToHeavy-distance[heavy];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer tokenizer =new StringTokenizer(br.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            M = Integer.parseInt(tokenizer.nextToken());
            if(N==0&&M==0)break;
            distance = new int[N+1];
            parent = new int[N+1];
            Arrays.fill(parent,-1);
            for(int m=0;m<M;m++){
                tokenizer = new StringTokenizer(br.readLine());
                if(tokenizer.nextToken().equals("!")){
                    int a = Integer.parseInt(tokenizer.nextToken());
                    int b = Integer.parseInt(tokenizer.nextToken());
                    int diff = Integer.parseInt(tokenizer.nextToken());
                    union(a,b,diff);
                }
                else{
                    int a = Integer.parseInt(tokenizer.nextToken());
                    int b =Integer.parseInt(tokenizer.nextToken());
                    if(find(a)==find(b)) System.out.println(distance[b]-distance[a]);
                    else System.out.println("UNKNOWN");
                }
            }
        }
    }
}
