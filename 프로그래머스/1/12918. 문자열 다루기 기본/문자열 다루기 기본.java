import java.util.*;
class Solution {
    public boolean solution(String s) {
        String s_temp = s.toUpperCase();
        if(s_temp.length()!=4 && s_temp.length()!=6) return false;
        List<String> arrays = List.of("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
        
        for(int i =0; i<arrays.size();i++){
            if(s_temp.contains(arrays.get(i)))
                return false;
        }
        
        return true;
    }
}