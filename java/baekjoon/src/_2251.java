import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2251 {
    public static int maxA, maxB, maxC;
    public static boolean[][][] visited;
    public static int total;
    public static List<Integer> cSet = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        maxA = Integer.parseInt(st.nextToken());
        maxB = Integer.parseInt(st.nextToken());
        maxC = Integer.parseInt(st.nextToken());
        visited = new boolean[maxA +1][maxB +1][maxC +1];
        Queue<Bottle> queue = new LinkedList<>();
        queue.add(new Bottle(0,0, maxC));
        while(!queue.isEmpty()){
            Bottle nowBottle = queue.poll();
            if(visited[nowBottle.a][nowBottle.b][nowBottle.c]) continue;
            if(nowBottle.a==0) cSet.add(nowBottle.c);
            visited[nowBottle.a][nowBottle.b][nowBottle.c] =true;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(i==j){
                        continue;
                    }
                    if(i==0){
                        if(j==1){
                            if(nowBottle.a+ nowBottle.b<=maxB) queue.add(new Bottle(0,nowBottle.a+ nowBottle.b,nowBottle.c));
                            else queue.add(new Bottle(nowBottle.a+ nowBottle.b-maxB,maxB, nowBottle.c));
                        }
                        if(j==2){
                            if(nowBottle.a+ nowBottle.c<=maxC) queue.add(new Bottle(0,nowBottle.b,nowBottle.c+ nowBottle.a));
                            else queue.add(new Bottle(nowBottle.a+ nowBottle.c-maxC, nowBottle.b, maxC));
                        }
                    }
                    if(i==1){
                        if(j==0){
                            if(nowBottle.a+ nowBottle.b<=maxA) queue.add(new Bottle(nowBottle.a+nowBottle.b,0,nowBottle.c));
                            else queue.add(new Bottle(maxA,nowBottle.a+nowBottle.b-maxA, nowBottle.c));
                        }
                        if(j==2){
                            if(nowBottle.b+ nowBottle.c<=maxC) queue.add(new Bottle(nowBottle.a,0,nowBottle.c+ nowBottle.b));
                            else queue.add(new Bottle(nowBottle.a, nowBottle.c+nowBottle.b-maxC, maxC));
                        }
                    }
                    if(i==2) {
                        if(j==0){
                            if(nowBottle.a+ nowBottle.c<=maxA) queue.add(new Bottle(nowBottle.a+ nowBottle.c, nowBottle.b, 0));
                            else queue.add(new Bottle(maxA, nowBottle.b,nowBottle.a+ nowBottle.c-maxA));

                        }
                        if(j==1){
                            if(nowBottle.b+ nowBottle.c<=maxB) queue.add(new Bottle(nowBottle.a,nowBottle.c+ nowBottle.b, 0));
                            else queue.add(new Bottle(nowBottle.a, maxB ,nowBottle.b+ nowBottle.c-maxB));
                        }
                    }
                }
            }
        }
        Collections.sort(cSet);
        for(int i=0;i<cSet.size();i++) System.out.print( cSet.get(i)+" ");
    }
    public static class Bottle {
        int a, b, c;

        public Bottle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static int maxBottleNumber(int i){
        if(i==0) return maxA;
        if(i==1) return maxB;
        return maxC;
    }

    public static int bottleNumber(int i, Bottle bottle){
        if(i==0) return bottle.a;
        if(i==1) return bottle.b;
        return bottle.c;
    }
}
