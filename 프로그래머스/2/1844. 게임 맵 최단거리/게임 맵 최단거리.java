import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int sum = current[2];
            if(x==n-1 && y==m-1){
                return sum;
            }
            
            for(int i = 0; i<4;i++){
                int nextX = x+dx[i];
                int nextY = y+dy[i];
                if(nextX<0|| nextX>n-1||nextY<0|| nextY>m-1 || visited[nextX][nextY] || maps[nextX][nextY]==0)
                    continue;
                queue.offer(new int[]{nextX,nextY,sum+1});
                visited[nextX][nextY]= true;
                
            }
        }
        return -1;
    } 
}