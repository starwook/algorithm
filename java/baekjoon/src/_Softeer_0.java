import java.io.*;
import java.util.*;

class softeer_0 {
    public static int shipSize;
    public static int totalNode;
    public static List<String> alreadyCrossed = new ArrayList<>();
    public static Map<String, Node> nodes = new HashMap<>();
    public static Set<String> cantRemainSet = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //배크기 입력
        shipSize = Integer.parseInt(br.readLine());
        //모든 사람 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        totalNode = Integer.parseInt(st.nextToken());
        for(int i=0;i<totalNode;i++){
            String newNode = st.nextToken();
            nodes.put(newNode,new Node(newNode,false));
        }
        // 배를 몰 수 있는 사람 입력
        st = new StringTokenizer(br.readLine());
        int canDrive = Integer.parseInt(st.nextToken());
        for(int i=0;i<canDrive;i++){
            String node = st.nextToken();
            nodes.get(node).drivable =true;
        }

        //강둑에 남으면 안 되는 조합
        int cantRemain = Integer.parseInt(br.readLine());
        for(int i=0;i<cantRemain;i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            List<String> cantRemainList = new ArrayList<>();
            for(int c = 0;c<number;c++){
                String node = st.nextToken();
                cantRemainList.add(node);
            }
            Collections.sort(cantRemainList);
            String lastString = "";
            for(int j=0;j<cantRemainList.size();j++){
                lastString +=(cantRemainList.get(j) +" ");
            }
            cantRemainSet.add(lastString);
        }

        // 동행할 수 없는 조합
        int cantAccompanySituationCount = Integer.parseInt(br.readLine());
        for(int i=0;i<cantAccompanySituationCount;i++){
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            List<String> tmpStrings = new ArrayList<>();
            for(int c = 0;c<count;c++){
                String str = st.nextToken();
                tmpStrings.add(str);
            }
            for(int j = 0;j<tmpStrings.size()-1;j++){
                List<String> tmpCantAccompany = nodes.get(tmpStrings.get(j)).cantAccompany;
                for(int next =j+1;next<tmpStrings.size();next++){
                    tmpCantAccompany.add(tmpStrings.get(next));
                }
            }
        }

    }
    public static class Node{
        String name;
        boolean drivable = false;
        List<String> cantAccompany = new ArrayList<>();
        public Node(String name, boolean drivable) {
            this.name = name;
            this.drivable = drivable;
        }
    }
    public static boolean ifPossible(String one, String two){
        List<String> cantAccompany = nodes.get(one).cantAccompany;
        if(cantAccompany.contains(two)) return false;
        return true;
    }
}