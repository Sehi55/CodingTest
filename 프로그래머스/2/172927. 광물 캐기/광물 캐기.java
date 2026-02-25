import java.util.*;
class Solution {
    public class Bag{
        public int diamond = 0;
        public int iron = 0;
        public int stone = 0;
        public Bag(){
            
        }
    }
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int tools = 0;
        int[] picked = picks;
        
        for(int i =0; i< picks.length;i++){
            tools += picks[i];
        }
        
        List<Bag> bags  = new ArrayList<Bag>();
        for(int i =0; i<Math.min(tools,minerals.length/5+1);i++){
            bags.add(new Bag());
        }
        
        for(int i =0; i< Math.min(tools*5,minerals.length);i++){
            switch(minerals[i]) {
                case "diamond" : 
                    bags.get(i/5).diamond++;
                    break;
                case "iron" : 
                    bags.get(i/5).iron++;
                    break;
                case "stone" : 
                    bags.get(i/5).stone++;
                    break;
            }
        }
        
        bags.sort((a, b) -> {
            if (b.diamond != a.diamond) {
                return b.diamond - a.diamond;
            }
            if(b.iron!=a.iron){
                return b.iron - a.iron;
            }
            return b.stone - a.stone;
        });        
        for(int i =0; i<bags.size(); i++){
            Bag bag = bags.get(i);
            if(picked[0]!=0){
                answer = answer +bag.diamond+ bag.iron + bag.stone;
                picked[0]--;
            }
            else if (picked[1]!=0){
                answer = answer +5*bag.diamond+ bag.iron + bag.stone;
                picked[1]--;
            }
            else if(picked[2]!=0){
                answer = answer +25*bag.diamond+ 5*bag.iron + bag.stone;
                picked[2]--;
            }
        }
        return answer;
    }
}