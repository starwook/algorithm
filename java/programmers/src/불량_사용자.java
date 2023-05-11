import java.util.*;
public class 불량_사용자 {
    String[] user_clone;
    String[] banned_clone;
    int answer = 0;
    List<String> list = new ArrayList<>();
    Set<String> set = new LinkedHashSet<>();
    public int solution(String[] user_id, String[] banned_id) {

        user_clone=user_id.clone();
        banned_clone = banned_id.clone();
        bfs(0,0,0);
        return set.size();
    }
    public void bfs(int uIndex,int bIndex,int index){
        if(index == banned_clone.length){
            Collections.sort(list,(a,b)-> a.compareTo(b));
            String tmp = "";
            for(int i=0;i<list.size();i++){
                tmp+=(list.get(i)+" ");
            }
            set.add(tmp);
            // System.out.println(set);
            return;
        }

        for(int i=0;i<user_clone.length;i++){
            if(list.contains(user_clone[i])) continue;
            for(int j=bIndex;j<banned_clone.length;j++){
                if(compareString(user_clone[i],banned_clone[j])){
                    list.add(user_clone[i]);
                    bfs(i+1,j+1,index+1);
                    list.remove(user_clone[i]);

                }
            }
        }
    }
    public boolean compareString(String a,String b){
        if(a.length() != b.length()) return false;
        for(int i=0;i<a.length();i++){
            if(b.charAt(i) =='*') continue;
            if(a.charAt(i) !=b.charAt(i)) return false;
        }
        return true;
    }
}
