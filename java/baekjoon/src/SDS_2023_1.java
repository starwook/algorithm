import java.util.*;
public class SDS_2023_1 {

    public static int T, LIGHT_COUNT, SWITCH_COUNT, SWITCH_LIGHT_COUNT;
    public static int[] lightArr =new int[30];
    public static int[][] switchArr = new int[18][8];
    public static int answer = Integer.MAX_VALUE;
    public static int[] visited = new int[18];
    public static List<Integer> tmp = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();scanner.nextLine();
        for(int testIndex =1;testIndex<=T;testIndex++){
            input(scanner);
            tryTurnOn(0,0);
            System.out.print("#"+testIndex+" ");
            if(answer==Integer.MAX_VALUE) {
                System.out.println(-1);
                continue;
            }
            System.out.println(answer);
            answer = Integer.MAX_VALUE;
        }
    }
    public static void tryTurnOn(int count,int index){
        if(checkLightsAreAllOn()){
            answer = Math.min(answer,count);
        }
        if(index==SWITCH_COUNT) {
            return;
        }
        if(count>answer) return;
        tryTurnOn(count,index+1);
        turnOnAndOff(index);
        visited[index] =1;
        tryTurnOn(count+1,index+1);
        turnOnAndOff(index);
        visited[index]=0;
    }

    private static void tmpListShow() {
        for(int i=0;i<SWITCH_COUNT;i++){
            System.out.print(visited[i]+" ");
        }
        System.out.println();
    }

    public static void showLights(){
        for(int i=0;i<LIGHT_COUNT;i++) System.out.print(lightArr[i]+" ");
        System.out.println();
    }
    public static void turnOnAndOff(int switchNumber){
        for(int i=0;i<SWITCH_LIGHT_COUNT;i++){
            int lightIndex = switchArr[switchNumber][i];
            if(lightArr[lightIndex-1]==0) {
                lightArr[lightIndex-1]=1;
                continue;
            }
            if(lightArr[lightIndex-1]==1) {
                lightArr[lightIndex-1]=0;
            }
        }
    }
    public static boolean checkLightsAreAllOn(){
        for(int i=0;i<LIGHT_COUNT;i++){
            if(lightArr[i]==0) return false;
        }
        return true;
    }

    private static void input(Scanner scanner) {
        String number = scanner.nextLine();
        String[] numbers = number.split(" ");
        LIGHT_COUNT =Integer.parseInt(numbers[0]);
        SWITCH_COUNT =Integer.parseInt(numbers[1]);
        SWITCH_LIGHT_COUNT =Integer.parseInt(numbers[2]);
        String light = scanner.nextLine();
        String[] lights = light.split(" ");
        for(int i=0;i<lights.length;i++){
            lightArr[i] = Integer.parseInt(lights[i]);
        }
        for(int i=0;i<SWITCH_COUNT;i++){
            String switchToCount = scanner.nextLine();
            String[] switchToCounts = switchToCount.split(" ");
            for(int j=0;j<SWITCH_LIGHT_COUNT;j++){
                switchArr[i][j] = Integer.parseInt(switchToCounts[j]);
            }
        }
    }

}
