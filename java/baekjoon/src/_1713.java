import java.util.*;
public class _1713 {
    public static int pictureNumber,studentNumber;
    public static List<Student> pictures = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        pictureNumber = scanner.nextInt();scanner.nextLine();
        studentNumber = scanner.nextInt();scanner.nextLine();
        String tmp = scanner.nextLine();
        String[] tmps = tmp.split(" ");
        int pictureNumberStart =0;
        for(int i=0;i<tmps.length;i++) {
            int nowNumber =Integer.parseInt(tmps[i]);
            boolean exist =false;
            for(int j=0;j<pictures.size();j++){
                Student student =pictures.get(j);
                if(student.number == nowNumber){
                    student.count++;
                    exist =true;
                    break;
                }
            }
            if(!exist){
                Collections.sort(pictures, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        if(o1.count==o2.count){
                            return o2.age-o1.age;
                        }
                        return o2.count-o1.count;
                    }
                });
                if(pictureNumberStart<pictureNumber){ //넣을 곳이 있다면
                    pictures.add(new Student(i,nowNumber,1));
                    pictureNumberStart++;
                }
                else{//꽉 찼다면
                    pictures.remove(pictures.size()-1);
                    pictures.add(new Student(i,nowNumber,1));
                }

            }
        }
        Collections.sort(pictures,(p1,p2)-> p1.number-p2.number);
        for(int i=0;i<pictures.size();i++) System.out.print(pictures.get(i).number+" ");


    }
}
class Student{
    public int age;
    public int number;
    public int count;

    public Student(int age,int number, int count) {
        this.age = age;
        this.number = number;
        this.count = count;
    }
}
