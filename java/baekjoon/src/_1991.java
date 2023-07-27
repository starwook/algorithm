import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _1991 {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        Node root = null;
        for(int i=0;i<N;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String parent = stringTokenizer.nextToken();
            String left = stringTokenizer.nextToken();
            String right = stringTokenizer.nextToken();
            if(i==0){
                root = new Node(parent,left,right);
            }
            else{
                Node newNode = new Node(parent,left,right);
                root.addChild(newNode);
            }
        }
        root.printPre();
        System.out.println();
        root.printMid();
        System.out.println();
        root.printAfter();

    }

    public static class Node{
        public char alphabet;
        public Node leftNode =null;
        public Node rightNode=null;


        public Node(String alphabet){
            this.alphabet = alphabet.charAt(0);
        }
        public Node(String alphabet,String left,String right) {
            this.alphabet = alphabet.charAt(0);
            if(!left.equals(".")) this.leftNode = new Node(left);
            if(!right.equals(".")) this.rightNode = new Node(right);
        }
        public void addChild(Node child){
            if(child.alphabet== this.alphabet){
                this.leftNode = child.leftNode;
                this.rightNode = child.rightNode;
                return;
            }
            if(this.leftNode!=null) leftNode.addChild(child);
            if(this.rightNode!=null) rightNode.addChild(child);
        }
        public void printPre(){
            System.out.print(this.alphabet);
            if(this.leftNode!=null) leftNode.printPre();
            if(this.rightNode!=null) rightNode.printPre();
        }
        public void printMid(){
            if(this.leftNode!=null) leftNode.printMid();
            System.out.print(this.alphabet);
            if(this.rightNode!=null) rightNode.printMid();

        }
        public void printAfter(){
            if(this.leftNode!=null) leftNode.printAfter();
            if(this.rightNode!=null) rightNode.printAfter();
            System.out.print(this.alphabet);
        }
    }
}
