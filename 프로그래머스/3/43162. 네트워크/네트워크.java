import java.util.*;
class Solution {
    
    public int solution(int n, int[][] computers) {
        UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i< n;i++){
            for(int j = i+1;j<n;j++){
                if(computers[i][j]==1)
                    uf.union(i,j);
            }
        }
        int answer =0;
        for(int i = 0; i<n; i++){
            if(uf.find(i)==i) answer++;
        }
        return answer;
    }
    
    
    public class UnionFind{
        int[] parent;
        int[] ranked;
        
        UnionFind(int n ){
            parent = new int[n];
            ranked = new int[n];
            
            for(int i =0;i<n;i++){
                parent[i] = i;
            }
            
        }
        public int find(int x){
            if(parent[x]==x)
                return x;
            
            return parent[x] = find(parent[x]);
        }
        public boolean union(int x, int y){
            int a = find(x);
            int b = find(y);
            
            if(a==b)
                return false;
            
            if(ranked[a]>ranked[b])
                parent[b] = a;
            else if (ranked[a]< ranked[b])
                parent[a] = b;
            else {
                parent[b] = a;
                ranked[a]++;
                
            }
            return true;
        }
    }
    
}