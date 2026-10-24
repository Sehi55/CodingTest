import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> 
            Integer.compare(a[1],b[1])
        );
        for(int i = 0;i<routes.length;i++){
            q.offer(routes[i]);
        }
        int[] standard =  q.poll();
        int answer = 1;   
        for(int i = 1; i<routes.length;i++){
            int[] tmp = q.poll();
            if(standard[1]< tmp[0]) {
                answer++;
                standard = tmp;
            }
        }
        return answer;
    }
}