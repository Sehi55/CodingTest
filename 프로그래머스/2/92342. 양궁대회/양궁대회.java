import java.util.*;
class Solution {
    int max =0;
    List<List<Integer>> allAnswers = new ArrayList<List<Integer>>();
    public int[] solution(int n, int[] info) {
        int[] answer = new int[info.length];
        List<Integer> l_info = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0));
        
        dfs(0,n,l_info,info,0);
        
        allAnswers.sort((a,b)-> {
            for(int i = 10;i>=0;i--){
                if(b.get(i).equals(a.get(i)))
                    continue;
                else return b.get(i)-a.get(i);
            }
            return 0;
        });
        if(allAnswers.size()==0){
            return new int[]{-1};
        }
        for(int i =0; i<info.length;i++){
            answer[i] = allAnswers.get(0).get(i);
        }
        return answer;
    }
    
    public void dfs(int count, int n, List<Integer> l_info, int[] info,int index){
        if(count==n){
            int diff = whoWin(info,l_info);
            if(diff>0 && max< diff ){
                allAnswers.clear();
                max = diff;
                allAnswers.add(new ArrayList<>(l_info));
                
            } else if(diff >0 && max==diff){
                allAnswers.add(new ArrayList<>(l_info));
            }
            return;
        }
        for(int i = index; i<info.length;i++){
            l_info.set(i,l_info.get(i)+1);
            dfs(count+1, n,l_info,info,i);
            l_info.set(i,l_info.get(i)-1);
        }
    }
    public int whoWin(int[] info, List<Integer> l_info){
        int a = 0;
        int b = 0;
        for(int i =0; i<info.length-1;i++){
            if(info[i] ==0 && l_info.get(i).equals(0)) continue;
            if(info[i] < l_info.get(i)){
                b= b+ (10-i);
            }else a = a+(10-i);
        }
        return b-a;
    }
}