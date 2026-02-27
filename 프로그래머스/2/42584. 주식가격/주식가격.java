import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i =0; i<prices.length;i++){
            if(i == prices.length-1){
                answer[i] =0;
                while(stack.size()>0){
                    int num = stack.poll();
                    answer[num] = i-num;
                }
            }else if(stack.size()==0|| prices[stack.peek()]<=prices[i]){
                stack.push(i);
            }else {
                while(stack.size()>0){
                    int index = stack.peek();
                    if(prices[index]<=prices[i]){
                        break;
                    }
                    answer[index] = i-index;
                    stack.poll();
                }
                stack.push(i);
            }
        }
        return answer;
    }
}

