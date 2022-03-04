import java.util.*;

public class Solution {
  int n; int[] dist;
  public int solution(int n) {
    this.dist = new int[n+1];
    Arrays.fill(dist,Integer.MAX_VALUE);
    this.n = n;
    if(n == 0){
      return 0;
    }else if(n == 1 || n == 2){
      return 1;
    }
    bfs();
    int ans = dist[n];
    return ans;
  }

  private void bfs(){
    ArrayList<Integer> que = new ArrayList<>();
    que.add(0);
    dist[0]=0;
    while(!que.isEmpty()){
      int x = que.remove(0);
      for(int i=0;i<2;i++){
        int newX;
        if(i==0){
          newX = x+1;
        if(newX > n) continue;
          if(dist[newX] <= dist[x]+1) continue;
          dist[newX] = dist[x]+1;
        }else{
          newX = x*2;
          if(newX > n) continue;
          if(dist[newX] <= dist[x]) continue;
          dist[newX] = dist[x];
        }
        que.add(newX);
      }
    }
  }
}