import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        
        List<Integer> array = number.chars().map(c-> c-'0').boxed().collect(Collectors.toCollection(ArrayList::new));
        
       
        
        int cnt = 0;
        int i = 0;
        int cycle = 0;
        while(cnt<k && i<array.size()){
            if(i == array.size()-1){
                array.remove(i);
                i--;
                cnt++;
            }
            if(i+1<array.size() && array.get(i)< array.get(i+1)){
                array.remove(i);
                cnt++;
                if(i>0) i--;
            } else {
                i++;
            }
        }
        
        
        
        for(int j = 0; j<array.size() ;j++){
            sb.append(array.get(j));
        }
        return sb.toString();
    }
}