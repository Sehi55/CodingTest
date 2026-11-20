import java.util.*;
class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] answer = new int[m][n];
        boolean[][] blocked = new boolean[m][n];
        
        for(int i = 0; i< puddles.length;i++){
            blocked[puddles[i][0]-1][puddles[i][1]-1]=true;
        }
        
        answer[m-1][n-1]=1;
        
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                if( i==m-1 && j==n-1) continue;
                if(!blocked[i][j]){
                    long count = 0; 
                    if(i+1<m)
                        count+= answer[i+1][j];
                    if(j+1<n)
                        count+= answer[i][j+1];
                    answer[i][j] = (int) (count % 1000000007);
                }
                    
            }
        }
        return answer[0][0];
    }
}