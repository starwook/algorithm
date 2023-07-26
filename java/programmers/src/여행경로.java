import java.util.*;
public class 여행경로 {

    boolean[] visited;
    List<String> allRoute = new ArrayList<>();
    int ticketNum;
    public String[] solution(String[][] tickets) {
        ticketNum = tickets.length;
        visited = new boolean[tickets.length];
        Arrays.fill(visited,false);
        dfs("ICN","ICN",0,tickets);
        Collections.sort(allRoute);
        return allRoute.get(0).split( " ");
    }
    public void dfs(String lastRoute,String route,int index,String[][] tickets){
        if(index ==visited.length){
            allRoute.add(route);
            return;
        }
        for(int i=0;i<tickets.length;i++){
            if(visited[i]) continue; //이미 쓴 항공권이라면
            if(!tickets[i][0].equals(lastRoute)) continue; //출발할 곳이 다르다면
            visited[i] = true;
            dfs(tickets[i][1],route +" "+ tickets[i][1],index+1,tickets);
            visited[i] = false;
        }


    }
}
