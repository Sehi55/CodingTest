import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2;
        StringBuilder answer = new StringBuilder();
        
        String[] map = new String[]{"A","B","C","D","E","F"};
        sb.append(0);
        for(int i = 1; i<=t*m;i++){
            sb2 = new StringBuilder();
            int tmp = i;
            while(tmp>0){
                int num = tmp%n;
                if(num>=10){
                    sb2.append(map[num-10]);
                }else sb2.append(num);
                tmp= tmp/n;
            }
            sb.append(sb2.reverse().toString());
        }
        String entire = sb.toString();
        int index = p-1;
        for(int i=0; i<t; i++){
            if(index<entire.length()){
                answer.append(entire.charAt(index));
                index+=m;
            }else break;   
        }
    
        return answer.toString();
    }
}