import java.util.*;
class Solution
{
    public static int[] arr;
    public static int n;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            List<Laser> lasers = new ArrayList<>();
            for(int i=0;i<n;i++){
                int x = sc.nextInt();
                int f = sc.nextInt();
                lasers.add(new Laser(x,f));
            }
            int answer =0;
            for(int i=0;i<lasers.size();i++){
                answer++;
                Laser laser = lasers.get(i);
                while(i<lasers.size()-1 &&laser.x+laser.f >= lasers.get(i+1).x){
                    i++;
                }
            }
            System.out.println("#" + test_case + " "+answer);
        }
        sc.close();
    }
}
class Laser{

    public int x;
    public int f;
    Laser(int x,int f){
        this.x = x;
        this.f = f;
    }
}