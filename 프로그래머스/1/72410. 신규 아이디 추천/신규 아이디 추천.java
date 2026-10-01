class Solution {
    public String solution(String new_id) {
        
        StringBuilder sb = new StringBuilder();
        for(char c : new_id.toCharArray()){
            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }
            else if(c=='.' && sb.length()!= 0){
                if (sb.charAt(sb.length()-1)!='.')
                    sb.append('.');
            }
            else if(c=='-'||c=='_'||Character.isDigit(c))
                sb.append(c);
        }
        if(sb.length()>0){
            if(sb.charAt(0)=='.')
                sb.deleteCharAt(0);
            
        }
        if(sb.length()==0)
            sb.append("a");
        if(sb.length()>15)
            sb.setLength(15);
        if(sb.charAt(sb.length()-1)=='.')
                sb.deleteCharAt(sb.length()-1);
        while(sb.length()<3){
            sb.append(sb.charAt(sb.length()-1));}
        return sb.toString();
    }
}