import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> {
            if(a[2]!=b[2])
                return Integer.compare(a[2],b[2]);
            if(a[0]!=b[0])
                return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        for(int i = 0; i< costs.length;i++){
            q.offer(costs[i]);
        }
        UnionFind uf = new UnionFind(n);
        while(!uf.unionAll()){
            int[] start = q.poll();
            if(uf.union(start[0],start[1]))
                answer+=start[2];
        }
        
        return answer;
    }
    public class UnionFind{
        int[] parent;
        int[] ranked;
        
        UnionFind(int n){
            parent = new int[n];
            ranked = new int[n];
            
            for(int i = 0;i <n; i++){
                parent[i] = i;
            }
        }
        public boolean unionAll(){
            int tmp = find(0);
            for(int i = 1; i<parent.length;i++){
                if(tmp != find(i)) return false;
            }
            return true;
        }
        public int find(int a){
            if(parent[a]==a)
                return a;
            return parent[a] = find(parent[a]);
        };
        public boolean union(int x, int y){
            int a = find(x);
            int b = find(y);
            
            if(a==b) return false;
            if(ranked[a]>ranked[b])
                parent[b] = a;
            else if ( ranked[a]<ranked[b])
                parent[a] = b;
            else{
                parent[b] = a;
                ranked[a]++;
            }
            return true;
        };
        public boolean connected(int x, int y){
            return find(x)==find(y);
        }
        
    }
}