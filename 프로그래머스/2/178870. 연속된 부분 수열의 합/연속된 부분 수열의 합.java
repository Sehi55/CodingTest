import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int[] answer = new int[]{0,n-1};
        int x = 0;
        int y = 0;
        int sum = 0;
        for(int i = 0; i< sequence.length;i++){
            if(sequence[i]==k) return new int[]{i,i};
            if(sequence[i]>k) break;
            else{
                sum+=sequence[i];
                y = i;
                while(sum>k){
                    sum-=sequence[x];
                    x++;
                }
                if(sum==k){
                    if(answer[1]-answer[0]>y-x){
                        answer = new int[]{x,y};
                    }
                }
            }
        }
        
        return answer;
    }
}