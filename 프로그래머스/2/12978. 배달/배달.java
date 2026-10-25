import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        List<int[]>[] grid = new ArrayList[N+1];
        
        for(int i = 1;i<N+1;i++){
            grid[i] = new ArrayList<>();
        }
        for(int i = 0; i<road.length;i++){
            int[] tmp = road[i];
            int x = tmp[0];
            int y = tmp[1];
            int w = tmp[2];
            
            grid[x].add(new int[]{y,w});
            grid[y].add(new int[]{x,w});
        }
        int[] visited = new int[N+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[1] = 0;
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        q.offer(new int[]{1,0});
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int currentNode = tmp[0];
            int currentLength = tmp[1];
            
            if(currentLength>visited[currentNode])
                continue;
            for(int[] arr: grid[currentNode]){
                int nextLength = arr[1];
                int nextNode = arr[0];
                
                if(visited[nextNode]>currentLength+ nextLength)
                    visited[nextNode] = currentLength+ nextLength;
                    q.offer(new int[]{nextNode, currentLength+ nextLength});
            }
            
        }
        int answer =0;
        for(int i =1;i<N+1;i++){
            if(visited[i]<=K) answer++;
        }
        return answer;
    }
}