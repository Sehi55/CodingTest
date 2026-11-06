import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i< scoville.length;i++){
            queue.offer(scoville[i]);
        }
        int t = 0;
        while(queue.peek() < K){
            if(queue.size()<2) return -1;
            int a = queue.poll();
            int b = queue.poll();
            t = a + b*2;
            answer++;
            queue.offer(t);
        }
        return answer;
    }
}