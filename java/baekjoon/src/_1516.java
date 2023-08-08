import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _1516 {
    public static int N;
    public static List<Integer>[] nextBuilding;
    public static Queue<Building> buildings = new LinkedList<>();
    public static int[] shoudbuildCount;
    public static long[] costs;
    public static long[] results;
    public static boolean[] build;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        costs = new long[N+1];
        results = new long[N+1];

        shoudbuildCount = new int[N+1];
        build = new boolean[N+1];

        nextBuilding = new List[N+1];
        for(int i=1;i<=N;i++){
            nextBuilding[i] = new ArrayList<>();
        }
        for(int buildingNumber=1;buildingNumber<=N;buildingNumber++){
            String information = br.readLine();
            String[] informations = information.split(" ");
            Long cost = Long.parseLong(informations[0]);
            costs[buildingNumber] = cost;
            for(int index =1;index<informations.length-1;index++) {
                int preBuilding = Integer.parseInt(informations[index]);
                shoudbuildCount[buildingNumber]++;
                nextBuilding[preBuilding].add(buildingNumber);
            }
            if(informations.length-2==0){
                buildings.add(new Building(buildingNumber));
                results[buildingNumber] = cost;
            }
        }
        while(!buildings.isEmpty()){
            Building nowBuilding = buildings.poll();
            for(int i=0;i<nextBuilding[nowBuilding.number].size();i++) {
                int nextBuildingNumber = nextBuilding[nowBuilding.number].get(i);
                shoudbuildCount[nextBuildingNumber]--;
                results[nextBuildingNumber] =Math.max(results[nextBuildingNumber],results[nowBuilding.number]+ costs[nextBuildingNumber]);
                if (shoudbuildCount[nextBuildingNumber] == 0) buildings.add(new Building(nextBuildingNumber));
            }
            build[nowBuilding.number] =true;
        }
        for(int i=1;i<=N;i++){
            System.out.println(results[i]+" ");
        }

    }
    public static class Building{
        public int number;

        public Building(int number) {
            this.number = number;
        }
    }
}
