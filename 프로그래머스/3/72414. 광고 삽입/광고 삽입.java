import java.util.*;
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int n=convert(play_time);
        
        long[] play = new long[n+1];
        long[] sum = new long[n+1];
        for(int i = 0 ; i<logs.length;i++){
            String[] time = logs[i].split("-");
            play[convert(time[0])] += 1;
            int tmp = convert(time[1]); 
            if(tmp<n+1)
                play[tmp] -=1;
        }
        
        sum[0] = play[0];
        
        for(int i = 1; i<n+1;i++){
            play[i]+=play[i-1];
            sum[i] = sum[i-1]+ play[i];
        }
        int gap = convert(adv_time);
        
        int index = 0;
        long max = sum[gap-1];
        for(int i = 1; i<n+1-gap;i++){
            if(max < sum[i+gap]- sum[i]){
                max = sum[i+gap]- sum[i];
                index = i+1;
            }
        }
        return back(index);
    }
    public int convert(String log){
        String[] array = log.split(":");
        int n=0;
        n+= Integer.parseInt(array[0])*60*60;
        n+= Integer.parseInt(array[1])*60;
        n+= Integer.parseInt(array[2]);
        return n;
    }
    public String back(int n){
        int h = n /3600;
        n= n%3600;
        int m = n /60;
        int s = n%60;
        StringBuilder sb = new StringBuilder();
        if(h<10)
            sb.append("0");
        sb.append(h+":");
        if(m<10)
            sb.append("0");
        sb.append(m+":");
        if(s<10)
            sb.append("0");
        sb.append(s);
            
        
        return sb.toString();
    }
}