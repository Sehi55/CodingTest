import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        List<String> arrays = new ArrayList<>();
        for(int i =0; i<words.length;i++){
            arrays.add(words[i]);
        }
        if(!arrays.contains(target)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        int[] visited = new int[words.length];
        queue.add(begin);
        
        while(queue.size()>0){
            String standard = queue.poll();
            for(int i = 0; i< words.length ; i++){
                if(visited[i]==0&&canChange(standard, words[i])){
                    if(standard.equals(begin)){
                         visited[i] = 1;
                    }else {
                    visited[i] = visited[arrays.indexOf(standard)]+1;}
                    if(words[i].equals(target)) return visited[i]; 
                    queue.add(words[i]);
                }
            }
        
        }
        return 0;
    }
    public boolean canChange(String start, String end){
        int count = start.length();
        for(int i =0; i<start.length();i++){
            if(!start.substring(i,i+1).equals(end.substring(i,i+1)))
                count --;
        }
        return count == start.length()-1;
    }
}