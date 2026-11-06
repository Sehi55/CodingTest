import java.util.*;
class Solution {
    
    public int solution(int n, int[][] edge) {
        int answer = 1;
        int[] visited = new int[n+1];
        List<Integer>[] arr = new ArrayList[n+1];
        for(int i = 0; i<n+1;i++){
            arr[i] = new ArrayList<>();
        }
        Deque<int[]> queue = new ArrayDeque<>();
        
        for(int i = 0; i<edge.length; i++){
            arr[edge[i][0]].add(edge[i][1]);
            arr[edge[i][1]].add(edge[i][0]);
        }
        for(int i = 0; i< arr[1].size();i++){
            queue.offer(new int[]{arr[1].get(i), 1});
            visited[arr[1].get(i)] = 1;
        }
        visited[1] = 1;
        
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int tmp = current[0];
            for(int i = 0; i< arr[tmp].size();i++){
                int nextNode = arr[tmp].get(i);
                if(visited[nextNode]!=0) continue;
                queue.offer(new int[]{arr[tmp].get(i), current[1]+1});
                visited[arr[tmp].get(i)] = current[1]+1;
                answer = Math.max(answer, current[1]+1);
            }
            
        }
        int sum = 0;
        for( int i = 0; i< visited.length;i++){
            if( visited[i]==answer ) sum++;
        }
        
        return sum;
    }
}