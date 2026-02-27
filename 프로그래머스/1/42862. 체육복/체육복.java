import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int tmp =0;
        int flag = 0;
        boolean[] used = new boolean[reserve.length];
        boolean[] lent = new boolean[lost.length];
        
        for(int i=0;i<reserve.length;i++){
            for(int j =tmp;j<lost.length;j++){
                if((reserve[i]-1== lost[j]||reserve[i]+1 ==lost[j])&&lent[j]==false&&used[i]==false){
                        used[i]= true;
                        lent[j]= true;
                        answer++;
                }
                if( reserve[i]==lost[j]){
                    if(used[i]==false&&lent[j]==false){
                        used[i]= true;
                        lent[j]= true;
                        answer++;
                    }
                    tmp = j+1;
                    break;
                }
            }
        }
        
        
        
        return answer;
    }
}