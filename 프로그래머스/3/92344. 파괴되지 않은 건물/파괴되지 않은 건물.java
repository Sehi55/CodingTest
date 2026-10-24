class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] diff = new int[n][m];
        
        
        for(int i = 0 ; i< skill.length;i++){
            int sx = skill[i][1];
            int sy = skill[i][2];
            int ex = skill[i][3];
            int ey = skill[i][4];
            int tmp = skill[i][5];
            
            int d = skill[i][0] == 1 ? -tmp : tmp;
            diff[sx][sy]+= d;
            if(ey+1<m)
                diff[sx][ey+1] -=d;
            if(ex+1<n)
                diff[ex+1][sy] -=d;
            if(ex+1<n&&ey+1<m)
                diff[ex+1][ey+1] +=d;
        }
        
        
        for(int i =0;i<n;i++){
            for(int j = 1; j<m;j++){
                diff[i][j] += diff[i][j-1];
            }
        }
        for(int i =1;i<n;i++){
            for(int j = 0; j<m;j++){
                diff[i][j] += diff[i-1][j];
            }
        }
        
        for(int i =0;i<n;i++){
            for(int j = 0; j<m;j++){
                if(board[i][j]+diff[i][j]>0) answer++;
            }
        }
        return answer;
    }
}