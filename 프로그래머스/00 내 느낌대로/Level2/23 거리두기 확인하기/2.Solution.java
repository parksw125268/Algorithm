import java.util.*;
class Solution {
    int[][] dist = new int[5][5]; 
    int[] sideY = {-1,1,0,0};
    int[] sideX = {0,0,-1,1};
    
    private void setDist(){
        for(int i=0;i<5;i++){
            Arrays.fill(dist[i],99);//99가 될수가 없어서 99로 셋팅 (visitCheck)
        }
    }
    
    private boolean isKeepDistance(String[] place){
        ArrayList<Integer> pList = new ArrayList<>();
        char[][] map = new char[5][5];
        for(int i =0;i<5;i++){
            for(int j=0;j<5;j++){
                map[i][j] = place[i].charAt(j);
                if(map[i][j] == 'P'){
                    pList.add(i);
                    pList.add(j);
                }
            }
        }
        for(int i=0;i<pList.size();i+=2){
            int y = pList.get(i);
            int x = pList.get(i+1);
            if(pList.size() > 2){
                setDist();
                if(!bfs(map, y, x)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean bfs(char[][] map, int row, int col){
        dist[row][col] = 0;
        ArrayList<Integer> que = new ArrayList<>();
        que.add(row);
        que.add(col);
        while(!que.isEmpty()){
            int r = que.remove(0);
            int c = que.remove(0); 
            for(int i=0;i<4;i++){
                int newR = r+sideY[i];
                int newC = c+sideX[i];
                if(newR<0||newR>=5||newC<0||newC>=5) continue;
                if(dist[newR][newC] < 99) continue;
                if(map[newR][newC] == 'X') continue;
                dist[newR][newC] = dist[r][c]+1;
                que.add(newR);
                que.add(newC);
                if(map[newR][newC] == 'P' &&  dist[newR][newC] <= 2){
                    return false;
                }
            }
        }
        return true;
    }
    
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i=0;i<places.length;i++){
            if(isKeepDistance(places[i])){
                answer[i] = 1;
            }
        }
        return answer;
    }
    
    
}