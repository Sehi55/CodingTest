class Solution {
    
    public int solution(int sticker[]) {
        int n = sticker.length;
        if(n==1) return sticker[0];
        
        int[] visited_1 = new int[n];
        
        int[] visited_2 = new int[n];
        visited_2[0] = sticker[0];
        for(int i = 1; i< n;i++){
            dp(visited_1, sticker, i);
        }
        for(int i = 1; i<n-1;i++){
            dp(visited_2,sticker, i);
        }
        

        return Math.max(visited_1[n-1], visited_2[n-2]);
    }
    public void dp(int[] visited, int[] sticker, int i){
        if(i==1){
            if(visited[0]==0)
                visited[1] = sticker[1];
            else visited[1] = visited[0];
        }
        else visited[i] = Math.max(visited[i-1], visited[i-2]+sticker[i]);
    }
}