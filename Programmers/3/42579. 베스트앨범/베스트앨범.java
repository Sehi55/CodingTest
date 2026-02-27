import java.util.*;
class Solution {
    static class Music{
        int id;
        int plays;
        public Music(int id, int plays){
            this.id = id;
            this.plays = plays;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String,Integer> map = new HashMap<>(); 
        
        for(int i =0; i<genres.length;i++){
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
        }
        List<String> sortList = new ArrayList<>(map.keySet());
        sortList.sort((g1,g2)-> map.get(g2)- map.get(g1));
        List<Integer> answerList = new ArrayList<>();
        for(String key : sortList){
            List<Music> musics = new ArrayList<>();
            for(int i =0; i<genres.length;i++){
                if(key.equals(genres[i])){
                    musics.add(new Music(i,plays[i]));
                }
            }
            musics.sort((m1,m2) -> {
                if(m1.plays == m2.plays)
                    return m1.id - m2.id;
                return m2.plays - m1.plays;
                });
            answerList.add(musics.get(0).id);
            if(musics.size()>1){
                answerList.add(musics.get(1).id);
            }
        }
        answer = new int[answerList.size()];
        for(int i=0; i<answerList.size();i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}