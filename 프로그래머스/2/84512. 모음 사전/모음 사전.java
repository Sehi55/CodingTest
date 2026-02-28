import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        int length = word.length();
        
        for(int i=0;i<length;i++){
            int static_init = result(4-i);
            answer += switch(word.substring(i,i+1)){
                case "A" ->  1; 
                case "E" -> static_init+1;
                case "I" -> static_init*2+1;
                case "O" -> static_init*3+1;
                case "U" -> static_init*4+1;
                default -> 0;
            };
            
        }
    
        return answer;
    }
    public int result( int n){
        int r = 0;
        for(int i =n; i>=0;i--){
            r+=Math.pow(5,i);
        }
        return r;
    }
}