import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int[] answer;
        List<Integer> answers = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i =0; i<26 ; i++){
            map.put(String.valueOf((char)('A'+i)),i+1);
        }
        for(int i =0; i< msg.length();i++){
            if(i==msg.length()-1){
                answers.add(map.get(msg.substring(i,i+1)));
            }else {
                for(int j = i+1;j<msg.length();j++){
                    if(!map.containsKey(msg.substring(i,j+1))){
                        map.put(msg.substring(i,j+1), map.size()+1);
                        answers.add(map.get(msg.substring(i,j)));
                        i=j-1;
                        break;
                    }else {
                        if(j+1<msg.length()) continue;
                        answers.add(map.get(msg.substring(i,j+1)));
                        i = j;
                    }
                }
            }
        }
            
        
        
        answer = new int[answers.size()];
        for(int i =0; i< answers.size();i++){
            answer[i] = answers.get(i);
        }
        return answer;
    }
}