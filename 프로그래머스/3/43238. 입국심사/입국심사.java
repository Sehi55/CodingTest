import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        Long min = (long)1;
        Long max = (long)times[times.length-1]*n;
        
        
        while(max>= min){
            Long mid = (long)(min+max)/2;
            Long total = (long)0;
            
            for(int time: times){
               total += mid/time; 
            }
            if(total>=n){
                answer = mid;
                max = mid-1;
            } else {
                min = mid+1;
            }
        }
        
        return answer;
    }
}