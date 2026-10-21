import java.util.*;
class Solution {
    public boolean[][] visited1;
    public boolean[][] visited2;
    public int[] dx = new int[]{0,1,-1,0};
    public int[] dy = new int[]{1,0,0, -1};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        int n = table.length;
        visited1 = new boolean[n][n];
        visited2 = new boolean[n][n];
        List<List<int[]>> arr = new ArrayList<>();
        List<List<int[]>> arr2 = new ArrayList<>();
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                if(table[i][j]==1 && visited1[i][j]==false)
                     arr.add(dfs(i,j, table, visited1,1));
                
                if(game_board[i][j]==0 && visited2[i][j]==false)
                     arr2.add(dfs(i,j, game_board, visited2,0));
            }
        }
        
        for(int i = 0; i<arr.size();i++){
            for(int j = 0; j< arr2.size();j++){
                if(arr.get(i).size()!= arr2.get(j).size()) continue;
                if(isEqual(arr.get(i), arr2.get(j))){
                    answer+= arr.get(i).size();
                    arr2.remove(j);
                    break;
                }
                   
            }}
        return answer;
    }
    public boolean isEqual(List<int[]> arr, List<int[]> arr2){
        boolean equal = false;
        int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
        for(int i = 0; i<arr.size();i++){
                a = Math.min(a, arr.get(i)[1]);
                b = Math.min(b,arr.get(i)[0]);
        }
        List<int[]> newArray = normalize(b, a, arr);
        for(int i = 0; i<4;i++){
            int x = Integer.MAX_VALUE;
            int y = Integer.MAX_VALUE;
            
            for(int k = 0; k<arr.size();k++){
                arr2.set(k,new int[]{arr2.get(k)[1],-arr2.get(k)[0]});
                x = Math.min(x, arr2.get(k)[1]);
                y = Math.min(y, arr2.get(k)[0]);
            }
            
            List<int[]> newArray2 = normalize(y, x, arr2);
            boolean flag = true;
            for(int k = 0; k<arr.size();k++){
                if(newArray.get(k)[0]!=newArray2.get(k)[0]|| newArray.get(k)[1]!=newArray2.get(k)[1]) flag= false;
            }
            if(flag == true) return true;
        }
        return false; 
    }
    public List<int[]> normalize(int y, int x, List<int[]> arr){
        List<int[]> newArray = new ArrayList<>();
        for(int i =0; i<arr.size();i++){
            newArray.add(new int[]{arr.get(i)[0]-y,arr.get(i)[1]-x });
        }
        newArray.sort((p0,p1)->{
            if(p0[0]!=p1[0])
                return Integer.compare(p0[0],p1[0]);
            return Integer.compare(p0[1],p1[1]);
        });
        return newArray;
    }
                   
    
    public List<int[]> dfs(int j, int i, int[][] grid, boolean[][] visited,int t){
        
        
        Deque<int[]> stack = new ArrayDeque<>();
        List<int[]> shape = new ArrayList<>();
        stack.push(new int[]{j,i});
        visited[j][i]=true;
        while(!stack.isEmpty()){
            int[] current = stack.pop();
            int x = current[1];
            int y = current[0];
            shape.add(new int[]{y,x});
            for(int d = 0; d<4; d++){
                if(x+dx[d]<0 || y+dy[d]<0 || x+dx[d] >= grid.length || y+dy[d]>= grid.length) continue;
                if(grid[y+dy[d]][x+dx[d]]==t && visited[y+dy[d]][x+dx[d]]==false){
                    visited[y+dy[d]][x+dx[d]] = true; 
                    stack.push(new int[]{y+dy[d], x+dx[d]});
                }
            }
        }
        return shape;
    }
}