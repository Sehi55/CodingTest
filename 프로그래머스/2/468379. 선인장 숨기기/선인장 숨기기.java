import java.util.*;
class Solution {

    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        
        int[][] grid = new int[m][n];
        for(int[] a: grid) Arrays.fill(a, Integer.MAX_VALUE);
        
        for(int i = 0 ;i < drops.length;i++){
            int x = drops[i][0];
            int y = drops[i][1];
            grid[x][y] = i+1;
        }
        
        
        List<Integer> win = new ArrayList<>();
        int[][] rowMin = new int[m][n-w+1];
        for(int i = 0; i< m;i++){
            for(int k = 0; k<w;k++) {
                    if(win.size()==0)
                        win.add(grid[i][k]);
                    if(win.size()>0)
                        while(win.size()>0 && win.get(win.size()-1)>=grid[i][k])
                            win.remove(win.size()-1);
                        win.add(grid[i][k]);
            }
            rowMin[i][0] = win.get(0);
            
            for(int j = 1; j<n-w+1;j++){
                if(win.get(0)== grid[i][j-1]) win.remove(0);
                    if(win.size()==0)
                        win.add(grid[i][j+w-1]);
                    if(win.size()>0)
                        while(win.size()>0 && win.get(win.size()-1)>=grid[i][j+w-1])
                            win.remove(win.size()-1);
                        win.add(grid[i][j+w-1]);
                
                rowMin[i][j] = win.get(0);
            }
            win.clear();
        }
        
        
        int[][] colMin = new int[m-h+1][n-w+1];
        win = new ArrayList<>();
        for(int i = 0; i< n-w+1;i++){
            for(int k = 0; k<h;k++) {
                    if(win.size()==0)
                        win.add(rowMin[k][i]);
                    if(win.size()>0)
                        while(win.size()>0 && win.get(win.size()-1)>=rowMin[k][i])
                            win.remove(win.size()-1);
                        win.add(rowMin[k][i]);
            }
            colMin[0][i] = win.get(0);
            
            for(int j = 1; j<m-h+1;j++){
                if(win.get(0)== rowMin[j-1][i]) win.remove(0);
                    if(win.size()==0)
                        win.add(rowMin[j+h-1][i]);
                    if(win.size()>0)
                        while(win.size()>0 && win.get(win.size()-1)>=rowMin[j+h-1][i])
                            win.remove(win.size()-1);
                        win.add(rowMin[j+h-1][i]);
                
                colMin[j][i] = win.get(0);
            }
            win.clear();
        }
        
        
        int num = Integer.MIN_VALUE;
        int[] answer = new int[2];
        for(int i = 0; i<m-h+1;i++){
            for(int j = 0; j<n-w+1;j++){
                if(colMin[i][j]==Integer.MAX_VALUE)
                    return new int[]{i,j};
                if(num< colMin[i][j]){
                    num = colMin[i][j];
                    answer = new int[]{i,j};
                }
                if(num == colMin[i][j]){
                    if(i<answer[0])
                        answer = new int[]{i,j};
                    else if(i== answer[0] && j < answer[1])
                        answer = new int[]{i,j};
                }
                
            }
        }
        
        return answer;
    }
    
    
}