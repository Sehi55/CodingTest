import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            if(a[2] > b[2]) return 1;
            if(a[2] < b[2]) return -1;
            if(a[1] > b[1]) return 1;
            if(a[1] < b[1]) return -1;
            if(a[0]> b[0]) return 1;
            if(a[0] < b[0]) return -1;
            return 0;
        });
        PriorityQueue<int[]> timequeue = new PriorityQueue<>((a,b)->{
            if(a[1] > b[1]) return 1;
            if(a[1] < b[1]) return -1;
            if(a[0]> b[0]) return 1;
            if(a[0] < b[0]) return -1;
            return 0;
        });
        for(int i = 0; i< jobs.length;i++){
            timequeue.offer(new int[]{i, jobs[i][0]});
        }
        
        int[] tmp = timequeue.poll();
        int t = tmp[1];
        queue.offer(new int[]{ tmp[0], tmp[1], jobs[tmp[0]][1]});
        while(!timequeue.isEmpty() && tmp[1] == timequeue.peek()[1]){
                    tmp = timequeue.poll();
                    queue.offer(new int[]{ tmp[0], tmp[1], jobs[tmp[0]][1]});
        }
        
        
        while(!timequeue.isEmpty()|| !queue.isEmpty()){
            if(!queue.isEmpty()){
                int[] active = queue.poll();
                t+=active[2];
                answer += t-active[1];
                while(!timequeue.isEmpty() && timequeue.peek()[1] <= t){
                    int[] tmpTime = timequeue.poll();
                    queue.offer(new int[]{ tmpTime[0], tmpTime[1], jobs[tmpTime[0]][1]});
                }
            }else {
                int[] time = new int[2];
                time = timequeue.poll();
                t = time[1];
                queue.offer(new int[]{ time[0], time[1], jobs[time[0]][1]});
                
                while(!timequeue.isEmpty() && time[1] == timequeue.peek()[1]){
                    time = timequeue.poll();
                    queue.offer(new int[]{ time[0], time[1], jobs[time[0]][1]});
                }
                
            }
        }
        
        
        return answer/jobs.length;
    }
}