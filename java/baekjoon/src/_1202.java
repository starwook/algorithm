import javax.swing.*;
import java.io.*;
import java.util.*;
public class _1202 {
    public static int N,K;
    public static int[] bagWeight;
    public static boolean[] check;
    public static PriorityQueue<Jewel>jewels = new PriorityQueue<>(((o1, o2) -> {
        return o2.price-o1.price;
    }));
    public static int[][] jewelArr;

    public static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        jewelArr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewelArr[i][0] = weight;
            jewelArr[i][1]= price;

        }
        bagWeight = new int[K];
        check = new boolean[K];
        Arrays.sort(jewelArr, Comparator.comparingInt(o -> o[0]));
        for(int i=0;i<K;i++){
            bagWeight[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bagWeight);
        int index =0;
        for(int i=0;i<K;i++){
            while(index<N){
                if(bagWeight[i]>=jewelArr[index][0]) {
                    jewels.add(new Jewel(jewelArr[index][0],jewelArr[index][1]));
                    index++;
                }
                else break;
            }
            if(!jewels.isEmpty()){
                answer+=jewels.poll().price;
            }
        }
        bw.write(Long.toString(answer));

        bw.flush();
        bw.close();
    }
}
class Jewel{
    public int weight;
    public int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}