class Solution {
    public int solution(String s) {
        return split(s);
    }
    public int split(String s){
        if(s.length()==1)
            return 1;
        if(s.length()==0)
            return 0;
        char first = s.charAt(0);
        int count =1;
        int count_other = 0;
        for(int i =1; i<s.length();i++){
            if(s.charAt(i)==first)
                count++;
            else count_other++;
            
            if(count==count_other)
                return 1+ split(s.substring(i+1,s.length()));
        }
        return 1;
    }
}