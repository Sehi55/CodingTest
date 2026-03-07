import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> arrays = new ArrayList<>();
        int n = progresses.length;
        int[] time = new int[n];
        for(int i=0; i<n; i++){
            int extra_time = 100-progresses[i];
            time[i] = (extra_time)%speeds[i]>0 ? extra_time/speeds[i]+1 : extra_time/speeds[i];
        }
        
        int start = 0;
        int count =0;
        
        for(int i =0; i<n; i++){
            if(start ==0){
                count++;
                start = time[i];
            } else {
                if(start >= time[i]){
                    count++;
                }else {
                    arrays.add(count);
                    start = time[i];
                    count = 1;
                }
            }
        }
        arrays.add(count);
        answer = new int[arrays.size()];
        for(int i =0; i< arrays.size();i++){
            answer[i] = arrays.get(i);
        }
        return answer;
    }
}