import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a,b)-> a.get(1)-b.get(1));
        for(int i =0; i<routes.length;i++){
            queue.add(List.of(routes[i][0],routes[i][1]));
        }
        Integer x = -30001;
        while(queue.size()>0){
            List<Integer> list = queue.poll();
            if(list.get(0)>x){
                answer++;
                x = list.get(1);
            }
        }
        return answer;
    }
}