import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> types = new HashSet<>(Arrays.asList(gems));
        HashMap<String,Integer> count = new HashMap<>();
        
        int bestRight = gems.length-1;
        int bestLeft = 0;
        int left = 0;
        for(int i = 0; i< gems.length;i++){
            count.put(gems[i],count.getOrDefault(gems[i],0)+1);
            
            while(count.size()==types.size()){
                if(i-left < bestRight-bestLeft){
                        bestRight = i;
                        bestLeft = left;
                }  
                count.put(gems[left],count.get(gems[left])-1);
                if(count.get(gems[left])==0){
                    count.remove(gems[left]);
                }
                left++;
            }
        }
        return new int[]{bestLeft+1,bestRight+1};
    }
}