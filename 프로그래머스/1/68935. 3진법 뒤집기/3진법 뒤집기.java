class Solution {
    public int solution(int n) {
        int answer = 0;
        int m =0;
        StringBuilder sb = new StringBuilder();
        while(n>=3){
            m=n%3;
            n/=3;
            sb.append(m);
        }
        
        sb.append(n);
        answer = Integer.parseInt(sb.toString(),3);
        return answer;
    }
}