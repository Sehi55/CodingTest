import java.util.*;
class Solution {
    
    public int solution(String s) {
        String answer2 = "";
        int answer = s.length();
        StringBuilder sb;
        for(int i = 1; i<=s.length()/2; i++){
            String tmp = s.substring(0,i);
            int cnt = 1;
            sb = new StringBuilder();
            for(int j = i; j<=s.length();j=j+i){
                if(i+j<=s.length()){
                    if(tmp.equals(s.substring(j,j+i))){
                        cnt++;
                    }else {
                        if(cnt==1){
                            sb.append(tmp);
                        }else{
                            sb.append(cnt);
                            sb.append(tmp);
                        }
                        tmp = s.substring(j,j+i);
                        cnt=1;
                    }
                }else if(j==s.length()){
                    if(cnt==1){
                            sb.append(tmp);
                        }else{
                            sb.append(cnt);
                            sb.append(tmp);
                        }
                } else {
                    if(cnt==1){
                            sb.append(tmp);
                        }else{
                            sb.append(cnt);
                            sb.append(tmp);
                        }
                    sb.append(s.substring(j,s.length()));
                }
                
            }
            if(answer>sb.toString().length()){
                answer = sb.toString().length();
                answer2 = sb.toString();
            }
        }
        
        
        
        return answer;
    }
}