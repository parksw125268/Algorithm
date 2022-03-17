import java.util.*;
class Solution {
  int N; int[][] road; int K;
  ArrayList<Some>[] village;
  int[] dist;

  public int solution(int N, int[][] road, int K) {
    this.N=N; this.road = road; this.K = K;

    init();
    work(1);
    System.out.println(Arrays.toString(dist));
    return getAns();
  }
  int getAns(){
    int ans=0;
    for(int i=1;i<=N;i++){
        if(dist[i]<=K){
            ans++;
        }
    }
    return ans;
  }  
    
  void work(int startIdx){
    dist[startIdx] = 0;
    ArrayList<Integer> haveToVisit = new ArrayList<>();
    haveToVisit.add(startIdx);
    while(!haveToVisit.isEmpty()){
      int curr = haveToVisit.remove(0);
      for(int i =0;i<village[curr].size();i++){
        int toVill = village[curr].get(i).toVill;
        int toDist = village[curr].get(i).dist;
        if(toVill == 1) continue;
        if(dist[toVill] == 0 ){
            dist[toVill] = dist[curr] + toDist;
            haveToVisit.add(toVill);   
        }else{
          if(dist[curr] + toDist < dist[toVill]){
            dist[toVill] = dist[curr] + toDist;
            haveToVisit.add(toVill);
          }
        }
      }
    }
  }

  void init(){
    village = new ArrayList[N+1];
    dist = new int[N+1];
    for(int i=1;i<dist.length;i++){
      dist[i] = 0;
    }

    for(int i=0;i<road.length;i++){
      int f = road[i][0];  //from
      int t = road[i][1];  //to
      int d = road[i][2];  //distance
      if (village[f] == null){
        village[f] = new ArrayList<>();
      }
      if (village[t] == null){
        village[t] = new ArrayList<>();
      }
      village[f].add(new Some(t,d));
      village[t].add(new Some(f,d));
    }
  }
  class Some{
    int toVill; int dist;
    public Some(int toVill, int dist){
      this.toVill = toVill;
      this.dist = dist;
    }
  }
}