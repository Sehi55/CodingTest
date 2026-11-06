import java.util.*;
class Solution {
    
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
    
        Deque<Integer> stack3 = new ArrayDeque<>();
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] deleted = new boolean[n];
        prev[0] = -1; 
        prev[n-1] = n-2;
        next[0] = 1;
        next[n-1] = -1;
        for(int i = 1; i<n-1; i++){
            prev[i] = i-1;
            next[i] = i+1;
        }
        
        
        
        int current = k;
        for(int i = 0; i< cmd.length;i++){
            String[] arr = cmd[i].split(" ");
            String c = arr[0];
            if(c.equals("U"))
                current= up(prev, next, current, Integer.parseInt(arr[1]));
            if(c.equals("D"))
                current= down(prev, next, current,Integer.parseInt(arr[1]));
            if(c.equals("C"))
                current = cancel(prev,next, stack3,deleted, current);
            if(c.equals("Z"))
                back(prev, next, stack3.pop(), deleted, current);
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i< n;i++){
            if(deleted[i]) sb.append("X");
            else sb.append("O");
                
        }
        
        return sb.toString();
    }

    
    
    public int up(int[] prev, int[] next,int current, int num){
        int tmp = current;
        for(int i = 0; i< num ;i++){
            tmp = prev[tmp];
        }
        return tmp;
    }
    public int down(int[] prev, int[] next, int current, int num){
        int tmp = current;
        for(int i = 0; i< num ;i++){
            tmp = next[tmp];
        }
        return tmp;
    }
    public int cancel(int[] prev, int[] next, Deque<Integer> stack3,boolean[] deleted,  int current){
        stack3.push(current);
        deleted[current] = true;
        int nextNum=0;
        if(prev[current]!=-1 && next[current]!= -1){
            next[prev[current]] = next[current];
            prev[next[current]] = prev[current];
            nextNum = next[current];
            
        }
        else if(prev[current]!=-1){
            next[prev[current]]= -1;
            nextNum = prev[current];
        }
        else {
            nextNum = next[current];
            prev[next[current]]= -1;
        }
        
        
        return nextNum;
    }
    public void back(int[] prev, int[] next, int backNum,boolean[] deleted, int current){
        int tmp = current;
        deleted[backNum] = false;
        if(prev[backNum]!=-1){
            next[prev[backNum]] = backNum;
        }
        if( next[backNum]!= -1){
            prev[next[backNum]] = backNum;
        }
    }
}