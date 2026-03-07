import java.util.*;
class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer=0;
        boolean[] visited = new boolean[computers.length];
        
        for(int i =0; i<computers.length;i++){
            if(!visited[i]){
                dfs(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    public void dfs(int current, int[][] computers, boolean[] visited){
        visited[current] = true;
        for(int i = 0;i<computers.length;i++){
            if(i!=current && computers[current][i]==1 && !visited[i]){
                visited[i] = true;
                dfs(i, computers, visited);
            }
        }
    }
}