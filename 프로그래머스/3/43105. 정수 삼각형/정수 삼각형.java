class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        int[][] answerTree = new int[size][size];
        
        for(int i =0; i< size ; i++){
            for(int j =0;j<triangle[i].length;j++){
                if(i-1<0) answerTree[i][j] = triangle[i][j];
                else{
                    if(j-1<0) answerTree[i][j] = answerTree[i-1][j] + triangle[i][j];
                    else if ( j == triangle[i].length-1) answerTree[i][j] = answerTree[i-1][j-1] + triangle[i][j];
                    else {
                    answerTree[i][j] = Math.max(answerTree[i-1][j],answerTree[i-1][j-1])+triangle[i][j];
                    }
                }
            }
        }
        int answer = 0;
        for(int i =0; i< size;i++){
            answer = answer < answerTree[size-1][i] ? answerTree[size-1][i] : answer;
        }
        return answer;
    }
}