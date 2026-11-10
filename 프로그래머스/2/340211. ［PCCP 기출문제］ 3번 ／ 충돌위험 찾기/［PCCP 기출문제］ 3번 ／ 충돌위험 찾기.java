import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int n = routes.length;
        int m = routes[0].length;
        int[][] time = new int[n][2];
        int[][] end = new int[n][2];
        int[] completed = new int[n];
        for(int i = 0 ;i< n;i++){
            time[i] = points[routes[i][0]-1].clone();
            end[i] = points[routes[i][m-1]-1].clone();
        }
        
        boolean[] visited;
        int remain = n;
        while(remain>0){
            visited = new boolean[n];
            for(int i = 0; i< n; i++){
                int index = completed[i];
                if(index>=m) continue;
                if(time[i][0] > points[routes[i][index]-1][0])
                    time[i][0]--;
                else if(time[i][0] < points[routes[i][index]-1][0])
                    time[i][0]++;
                else if(time[i][1] > points[routes[i][index]-1][1])
                    time[i][1]--;
                else if(time[i][1] < points[routes[i][index]-1][1])
                    time[i][1]++;
            }
            for(int i = 0; i<n; i++){
                int index = completed[i];
                if(visited[i] == true || completed[i] == m)
                    continue;
                int[] current = time[i];
                for(int j = i+1;j<n;j++){
                    int index2 = completed[j];
                    if( completed[j]!=m &&visited[j] ==false&&Arrays.equals(current, time[j])){
                        visited[i] = true;
                        visited[j] = true;
                        if(Arrays.equals(points[routes[j][index2]-1],time[j])) completed[j]++;
                        if(completed[j]==m) remain--;
                    }
                }
                if(visited[i]==true){
                    answer++;
                }
                if(Arrays.equals(points[routes[i][index]-1],time[i])) completed[i]++;
                if(completed[i]==m) remain--;
            }
            
        }
        return answer;
    }
}