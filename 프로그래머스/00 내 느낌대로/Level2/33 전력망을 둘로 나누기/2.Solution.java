import java.util.*;
class Solution {
    int n; int[][] wires;  
    int answer = Integer.MAX_VALUE; boolean[] visit;  int cnt;
    ArrayList<Integer>[] tree;     
    public int solution(int n, int[][] wires) {
        this.n = n; this.wires = wires;
        this.visit = new boolean[n+1]; 
        work();
        return answer;
    }
    int getDifference(){
        Arrays.fill(visit,false);   
        cnt = 0;
        dfs(1);
        int negativeCnt = Math.abs(cnt - n);
        return Math.abs(cnt - negativeCnt);
    }
    void dfs(int startIdx){
        visit[startIdx] = true;
        cnt++;
        
        for(int i=0;i<tree[startIdx].size();i++){
            int newIdx = tree[startIdx].get(i);
            if(visit[newIdx]) continue;
            dfs(newIdx);
        }
    }
    
    void work(){
        for(int excl=0;excl<wires.length;excl++){ //제외할 간선
            tree = new ArrayList[n+1];   
            for(int i=1;i<n+1;i++){
                tree[i] = new ArrayList<Integer>();
            }
            for(int i=0;i<wires.length;i++){//트리 연결 
                if(i == excl) continue;//간선 자르기 
                int a = wires[i][0];
                int b = wires[i][1];
                tree[a].add(b);
                tree[b].add(a);                
            }
            int diff = getDifference(); //잘린 트리에서 차이점 찾기 
            if(diff == 0) {
                answer = 0;
                return;
            }
            answer = Math.min(answer, diff);
        }        
    }
}