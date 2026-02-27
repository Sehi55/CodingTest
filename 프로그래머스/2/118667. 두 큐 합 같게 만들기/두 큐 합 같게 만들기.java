class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int size = queue1.length;
        
        int[] queue = new int[size*2];
        long sum1 =0;
        long sum2=0;
        long sumTotal =0;
        int indexFirst=0;
        int indexLast = size-1;
        
        
        for(int i =0; i< size ; i++){
            queue[i] = queue1[i];
            sumTotal+= queue1[i];
            sum1+= queue1[i];
        }
        for(int i =0; i< size ; i++){
            queue[i+size] = queue2[i];
            sumTotal+= queue2[i];
            sum2+= queue2[i];
        }
        
        if(checkEqual(sum1,sum2)) return 0;
        
        sumTotal/=2;
        for(int i =0; indexLast<size*2-1&&indexFirst<=indexLast&& indexFirst<size*2-1 ; i++){
            if(sum1>sumTotal){
                sum1-=queue[indexFirst];
                indexFirst++;
                answer++;
            }
            if(sum1<sumTotal){
                indexLast++;
                sum1+=queue[indexLast];
                answer++;
            }
            if(checkEqual(sum1,sumTotal))
                return answer;
        }
        return -1;
    }
    public boolean checkEqual(long sum1, long sum2){
        return sum1 == sum2;}
}