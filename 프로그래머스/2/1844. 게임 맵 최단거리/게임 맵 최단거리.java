import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        
        Queue<List<Integer>> queue = new LinkedList<>();
        int[] mv_y = {-1, 0, 1, 0};
        int[] mv_x = {0, 1, 0, -1};
        queue.add(List.of(0,0));
        int N = maps.length;
        int M = maps[0].length;
        int[][] visited= new int[maps.length][maps[0].length] ;
        visited[0][0] = 1;
        while(queue.size()>0){
            List<Integer> list = queue.poll();
            
            int y = list.get(0);
            int x= list.get(1);
            if(y==N-1 && x==M-1){
                return visited[N-1][M-1];
            }
            for(int i =0;i<4;i++){
                if(x+mv_x[i]<0|| x+mv_x[i]>=M || y+mv_y[i]<0||y+mv_y[i]>=N || visited[y+mv_y[i]][x+mv_x[i]]!=0 || maps[y+mv_y[i]][x+mv_x[i]]==0){
                    continue;
                } else {
                    queue.add(List.of(y+mv_y[i],x+mv_x[i]));
                    visited[y+mv_y[i]][x+mv_x[i]]=visited[y][x]+1;
                }
            }
        }
        return -1;
    }
}