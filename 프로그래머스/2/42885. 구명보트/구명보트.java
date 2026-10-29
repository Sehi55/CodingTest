import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i< people.length; i ++){
            arr.add(people[i]);
        }
        Collections.sort(arr);
        int index = -1;
        int largeIndex = arr.size()-1;
        while(index<largeIndex){
            int large = arr.get(largeIndex);
            
            if(largeIndex>index&&arr.get(index+1)+large<=limit){
                index++;
            }
            largeIndex--; // arr.remove()는 한번 삭제할 때 O(N)이다. 
            answer++;
        }
        return answer++;
    }
}