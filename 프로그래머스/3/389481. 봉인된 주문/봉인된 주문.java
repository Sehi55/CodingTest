import java.util.*;
class Solution {
    public String solution(long n, String[] bans) {
        List<Long> banNum = new ArrayList<>();
        for(int i = 0; i< bans.length;i++){
            String current = bans[i];
            int length = current.length();
            long num = 0;
            for(int j = length-1;j>=0;j--){
                char tmp = current.charAt(length-1-j);
                num+= Math.pow(26,j)*(tmp-'a'+1);
            }
            banNum.add(num);
        }
        
        Collections.sort(banNum);
        for(long b : banNum){
            if(b<=n) n++;
        }
        StringBuilder sb = new StringBuilder();
        while(n>0){
            n--;
            long index = n%26;
            sb.append((char)('a'+index));
            n= n/26;
        }
        
        return sb.reverse().toString();
    }
}