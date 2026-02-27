class Solution {
    int count =0;
    public int solution(int[] numbers, int target) {
        dfs(target, numbers, 0,0);
        return count;
    }
    public void dfs(int targetNumber, int[] numbers, int idx,int sum){
        
        if(idx<numbers.length){
            dfs(targetNumber, numbers,idx+1, sum+numbers[idx]);
            dfs(targetNumber, numbers, idx+1, sum-numbers[idx]);
        }
        if(idx==numbers.length && sum== targetNumber)
            count++;
    }
    
}