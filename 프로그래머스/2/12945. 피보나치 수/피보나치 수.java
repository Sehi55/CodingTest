class Solution {
    public int solution(int n) {
        int[] list = new int[n+1];
        list[0]=0; list[1]=1;
        for(int i =2;i<n+1;i++){
            list[i]=(list[i-2]+list[i-1])%1234567;
        }
        return list[n];
    }
}