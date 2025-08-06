public class Ex_13 {

    static int sum =0;
    int data =0;
    public static void main(String[] args) {
        Ex_13 ex = new Ex_13();
        int data =0;
        int sum =0;
        while(data<=10){
            sum+=data;
            data++;
        }
        System.out.println(data+":"+ Ex_13.sum);
    }
}
