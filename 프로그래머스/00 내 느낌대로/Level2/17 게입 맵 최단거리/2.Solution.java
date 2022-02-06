import java.util.*;
class Solution {
    private int[][] maps;
    private int[][] dist;
    private int y;
    private int x;
    private int[][] side = {{-1,0},{1,0},{0,-1},{0,1}};
    public int solution(int[][] maps) {
        this.maps = maps;
        this.y = maps.length;
        this.x = maps[0].length;
        this.dist = new int[y][x];
        init();
        bfs();
        return dist[y-1][x-1];
    }
    public void init(){
        for(int i =0;i<y;i++){
            Arrays.fill(dist[i],-1);
        }
    }
    
    public void bfs(){
        dist[0][0] = 1;
        ArrayList<Integer> que = new ArrayList<>();
        que.add(0);
        que.add(0);
        
        while(!que.isEmpty()){
            int r = que.remove(0);
            int c = que.remove(0);
            for(int i=0;i<4;i++){
                int newR = r+side[i][0];
                int newC = c+side[i][1];
                if(newR<0||newR>=y||newC<0||newC>=x) continue;
                if(dist[newR][newC] != -1 || maps[newR][newC] == 0) continue;
                dist[newR][newC] = dist[r][c]+1;
                que.add(newR);
                que.add(newC);
            }
        }
    }
}




