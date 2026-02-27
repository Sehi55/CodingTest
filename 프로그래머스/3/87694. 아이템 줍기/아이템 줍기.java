import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] maps = new int[101][101];
        
        for(int i =0; i<rectangle.length;i++){
            int x_1 = rectangle[i][0]*2;
            int x_2 = rectangle[i][2]*2;
            int y_1 = rectangle[i][1]*2;
            int y_2 = rectangle[i][3]*2;
            for(int j = x_1; j<=x_2;j++){
                for(int k = y_1;k<= y_2;k++){
                    if(j == x_1 || j == x_2 || k == y_1 || k== y_2 ){   if(maps[j][k]!=2){
                        maps[j][k] = 1;}
                    }else maps[j][k] = 2;
                }
            }
        }

        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1,0,-1,0};
        
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(characterX*2,characterY*2));
        maps[characterX*2][characterY*2]=3;
        while(queue.size()>0){
            List<Integer> list = queue.poll();
            int x = list.get(0);
            int y = list.get(1);
            if(x==itemX*2 && y == itemY*2){
                return (maps[x][y]-2)/2;
            }
            for(int i =0; i<4;i++){
                int tx = x+dx[i];
                int ty = y+dy[i];
                if(tx<0|| tx>100 || ty<0 || ty>100) continue;
                if(maps[tx][ty]!=1) continue;
                
                queue.add(List.of(tx,ty));
                maps[tx][ty]= maps[x][y]+1;
            }
        }
        
        return answer;
    }
}