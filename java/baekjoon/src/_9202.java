import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _9202 {
    public static int[] xi ={-1,1,0,0,-1,1,-1,1};
    public static int[] yi = {0,0,-1,1,-1,1,1,-1};
    public static int W,B;
    public static int score,foundCount;
    public static StringBuilder sb;
    public static char[][] board;
    public static boolean[][] visited;
    public static String longestWord;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        W = Integer.parseInt(br.readLine());
        Node startNode =  new Node(" ");
        startNode.length=0;
        for(int i=0;i<W;i++){
            String newWord = br.readLine();
            startNode.addChild(newWord);
        }
        br.readLine();
        B = Integer.parseInt(br.readLine());
        for(int i=0;i<B;i++){
            clearWord(startNode);
            sb = new StringBuilder();
            longestWord="";
            score =0;foundCount=0;
            board = new char[4][4];
            visited = new boolean[4][4];
            for(int t=0;t<4;t++) {
                String word = br.readLine();
                for (int j = 0; j < word.length(); j++) {
                    board[t][j] = word.charAt(j);
                }
            }

            for(int r =0;r<4;r++){
                for(int c=0;c<4;c++){
                    if(startNode.tries.containsKey(board[r][c])){
                        dfs(r,c,startNode.tries.get(board[r][c]));
                    }
                }
            }
            System.out.println(score+" "+longestWord+" "+foundCount);
            if(i!=B-1)br.readLine();
        }
    }
    public static void addScore(int length){
        if(length==3||length==4) score+=1;
        if(length==5) score+=2;
        if(length==6) score+=3;
        if(length==7) score+=5;
        if(length==8) score+=11;
    }
    public static void dfs(int r,int c,Node node){
//        System.out.print(node.alphabet+":");
        visited[r][c] =true;
        sb.append(node.alphabet);
        if(node.isWord){ //목적지라면
            if(!node.alreadyFound){
                String newWord = sb.toString();
//                System.out.println("목적지 도달"+newWord);
                //처음 발견 된 단어
                if(longestWord.length()<newWord.length()) longestWord = newWord;
                if(longestWord.length()==newWord.length()&& longestWord.compareTo(newWord)>0) longestWord = newWord;
                addScore(node.length);
                foundCount++;
                node.alreadyFound =true;
            }
        }
        for(int i=0;i<8;i++){ //순회
            int newR = r+xi[i];
            int newC = c+yi[i];
            if(newR>=0&&newR<4&&newC>=0&&newC<4){ //양옆 순회
                if(!visited[newR][newC]){ //방문하지 않았고
                    if(node.tries.containsKey(board[newR][newC])){//등록된 단어라면
                        dfs(newR,newC,node.tries.get(board[newR][newC]));
                    }
                }
            }
        }
        visited[r][c] =false;
        sb.deleteCharAt(sb.length()-1);
    }
    public static void clearWord(Node node){
        if(node.isWord){
            node.alreadyFound = false;
            return;
        }
        for(Character character : node.tries.keySet()){
            clearWord(node.tries.get(character));
        }
    }
    public static void showWord(Node node){
        System.out.print(":"+node.alphabet);
        if(node.isWord){
            System.out.println();
            return;
        }
        for(Character character : node.tries.keySet()){
            showWord(node.tries.get(character));
        }
    }
    public static class Node{
        public Character alphabet;
        public Map<Character,Node> tries = new HashMap<>();
        public boolean isWord;
        public int length;
        public boolean alreadyFound;
        Node(String start){
            this.alphabet =start.charAt(0);
            this.isWord = false;
            this.alreadyFound =false;
        }
        public void addChild(String str){
            if(str.length()==0){
                isWord = true;
                return;
            }
            if(tries.containsKey(str.charAt(0))){
                Node alreadyNode = tries.get(str.charAt(0));
                alreadyNode.addChild(str.substring(1));
                return;
            }
            Node newNode = new Node(str);
            newNode.length = this.length+1;
            newNode.addChild(str.substring(1));
            tries.put(str.charAt(0),newNode);
        }
        Node(Character start,String str){
            this.alphabet =start;
            this.isWord = false;
            this.alreadyFound =false;
            if(str.length()==0) isWord =true;
            else{
                tries.put(str.charAt(0),new Node(str.charAt(0),str.substring(1)));
            }
        }
    }
}
