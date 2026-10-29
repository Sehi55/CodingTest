class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        
        new_id= new_id.toLowerCase();
        for(int i=0; i< new_id.length();i++){
            char x = new_id.charAt(i);
            if((x>='0'&& x<='9') || x=='-' || x=='_' || (x>='a'&& x<='z'))
                sb.append(x);
            else if(x=='.'){
                String tmp = sb.toString();
                if(tmp.length()!=0)
                    if(tmp.charAt(tmp.length()-1)=='.')
                        continue;
                sb.append(x);
            }
        }
        new_id = delete(sb.toString());
        
        if(new_id.isEmpty()||new_id.isBlank())
            new_id = "a";
        if(new_id.length()>=16)
            new_id = new_id.substring(0,15);
        new_id = delete(new_id);
        int length = new_id.length();
        if(length<=2){
            for(int i =0;i<3-length;i++)
                new_id+=new_id.charAt(length-1);
        }
        return new_id;
    }
    public String delete(String s){
        if(s.charAt(0)=='.'){
            if(s.length()==1){
                return "";
            }
            s = s.substring(1, s.length());
        }
        if(s.charAt(s.length()-1)=='.'){
            
            s = s.substring(0, s.length()-1);
        }
        return s;
    }
}