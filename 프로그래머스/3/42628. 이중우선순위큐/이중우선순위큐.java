import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> queueMin = new PriorityQueue<>();
        PriorityQueue<Integer> queueMax = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> deleted = new HashMap<>();
        
        for(int i =0; i< operations.length; i++){
            String[] parts = operations[i].split(" ");
            if(parts[0].equals("I")){
                Integer num = Integer.parseInt(parts[1]);
                queueMax.add(num);
                queueMin.add(num);
                deleted.put(num, deleted.getOrDefault(num,0)+1);
            }
            if(parts[0].equals("D")){
                if(parts[1].equals("1")){
                    if(getMax(queueMax, deleted)==null)
                        continue;
                }
                if(parts[1].equals("-1")){
                    if(getMin(queueMin, deleted)==null)
                        continue;
                }
            }
            
        }
        Integer max= getMax(queueMax, deleted);
        Integer min = getMin(queueMin, deleted);
        
        if(max ==null && min == null){
            answer[0]=0;
            answer[1]=0;
            return answer;
        }
        if( min == null){
            answer[0] = max;
            answer[1] = max;
            return answer;
        }
        answer[0]= max;
        answer[1]= min;
        return answer;

    }
    public Integer getMax(PriorityQueue<Integer> queueMax, Map<Integer,Integer> deleted){
        while(queueMax.size()>0){
                        Integer max = queueMax.poll();
                        if(deleted.getOrDefault(max,0).equals(0)) continue;
                        else{
                            deleted.put(max, deleted.getOrDefault(max,0)-1);
                            return max;
                        }
                    }
        return null;
    }
   public Integer getMin(PriorityQueue<Integer> queueMin, Map<Integer,Integer> deleted){
        while(queueMin.size()>0){
                        Integer min = queueMin.poll();
                        if(deleted.getOrDefault(min,0).equals(0)) continue;
                        else{
                            deleted.put(min, deleted.getOrDefault(min,0)-1);
                            
                            return min;
                        }
                    }
        return null;
    }

}