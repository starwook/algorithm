import java.util.Arrays;

class Mai {
    public int[] solution(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);


        int[] c = {};
        return c;
    }

    public static void main(String[] args) throws Exception {
        Mai mai = new Mai();
        int[] a = {1,2,2,3,3,3};
        int[] b = {2,3,3,4,5};
        int[] result = mai.solution(a,b);

        System.out.println(Arrays.toString(result));
    }
}
