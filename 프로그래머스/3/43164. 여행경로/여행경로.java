import java.util.*;
import java.util.stream.*;
class Solution {
    List<String> allRoute = new ArrayList<>();
    boolean[] visited ;
    
    
    public String[] solution(String[][] tickets) {  
        visited = new boolean[tickets.length];
        dfs("ICN","ICN",tickets,0);
        
        Collections.sort(allRoute);
        return allRoute.get(0).split(" ");
} 
    
    public void dfs(String start, String route, String[][] tickets, int count){
        if(count == tickets.length){
            allRoute.add(route);
            return;
        }
        
        for(int i =0;i< tickets.length;i++ ){
            if(!visited[i]&& tickets[i][0].equals(start)){
                visited[i] = true;
                dfs(tickets[i][1],route+" "+tickets[i][1], tickets, count+1);
                visited[i] = false;
            }
            
        }
        
    }


}