import java.util.*;

class Solution {
    public int[] solution(int n) {
        int size = n*(n+1)/2;
        int[] answer = new int[size];
        int[][] arrays = new int[n][n];
        int x =0, y =0;
        int k = n;
        int k_end = 0;
        for(int i =0; i<size; i++){
            arrays[y][x] = i+1;
            if(k==1){
                break;
            }
            int tmp = (i-k_end)/(k-1);
            if(tmp == 0) y++;
            if(tmp == 1) x++;
            if(tmp == 2) {
                if( i+1-k_end == (k-1)*3){
                    k_end = i+1;
                    k= k-3;
                    y++;
                }
                else{
                    x--; y --;
                }
            }
        }
        int index = 0;
        for( int i =0 ; i<n; i++){
            for(int j = 0; j<i+1; j++){
                answer[index] = arrays[i][j];
                index++;
            }
        }
        return answer;
    }
}