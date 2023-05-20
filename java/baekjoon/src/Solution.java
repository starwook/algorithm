import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;
    public SinglyLinkedListNode before;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.before = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.before = this.tail;
        }
        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}



class Result {

    /*
     * Complete the 'deleteEven' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST listHead as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode deleteEven(SinglyLinkedListNode listHead) {
        SinglyLinkedListNode firstNode =null;
        while(listHead!=null){
            if(listHead.data%2==0) {
                if(listHead.before!=null){
                    listHead.before.next = listHead.next;
                }
                if(listHead.next !=null){
                    listHead.next.before = listHead.before;
                }
            }
            if(listHead.data%2!=0 &&firstNode==null){
                firstNode = listHead;
            }
            listHead = listHead.next;
        }
        return firstNode;
        // Write your code here

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList listHead = new SinglyLinkedList();

        int listHeadCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, listHeadCount).forEach(i -> {
            try {
                int listHeadItem = Integer.parseInt(bufferedReader.readLine().trim());

                listHead.insertNode(listHeadItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        SinglyLinkedListNode result = Result.deleteEven(listHead.head);

        SinglyLinkedListPrintHelper.printList(result, "\n", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
