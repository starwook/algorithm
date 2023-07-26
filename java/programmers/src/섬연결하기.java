import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기 {
    public int answer;
    public int startNumber =1;
    public int[] parent;
    public boolean union(int x,int y){
        x = findParent(x);
        y = findParent(y);
        if(x==y) return false;
        startNumber++;
        if(x>y){
            parent[x] =y;
            return true;
        }
        parent[y] =x;
        return true;
    }
    public int findParent(int x){
        if(x ==parent[x]) return x;
        return parent[x] = findParent(parent[x]);
     }
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        for(int i=0;i<costs.length;i++){
            if(union(costs[i][0],costs[i][1])) answer+=costs[i][2];
            if(startNumber==n) break;
        }
        return answer;
    }
}
