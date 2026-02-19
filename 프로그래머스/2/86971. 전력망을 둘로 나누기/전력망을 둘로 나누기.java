import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        for(int i =0; i< wires.length;i++){
            int count = countNodes(n, wires, i);
        
            int diff = Math.abs(count-( n-count));
            
            if(answer>diff)
                answer = diff;
        }
        return answer;
    }
    public int countNodes(int n, int[][] wires, int j){
        Queue<Integer> nodes = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        
        nodes.add(1);
        visited[1] = true;
        int count =1;
        while(!nodes.isEmpty()){
            int current = nodes.poll();
            
            for(int i =0; i<wires.length;i++){
                if(i ==j) continue;
                int v1 = wires[i][0];
                int v2 = wires[i][1];
                if(v1 == current || v2 == current){
                    int next = current == v1 ? v2 : v1;
                
                
                if(!visited[next]){
                    visited[next] = true;
                    nodes.add(next);
                    count++;
                }
                                
            }}
        }
        return count;
    }
    
}