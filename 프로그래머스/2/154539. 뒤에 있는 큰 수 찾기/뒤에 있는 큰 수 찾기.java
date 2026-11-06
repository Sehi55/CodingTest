import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        stack.push(0);
        
        
        for(int i = 1; i< numbers.length;i++){
            while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        return answer;
        
    }
}