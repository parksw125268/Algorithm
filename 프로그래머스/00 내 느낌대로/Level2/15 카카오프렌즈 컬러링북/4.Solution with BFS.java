import java.util.ArrayList;
class Solution {
    boolean[][] visit;
    int[][] edge = {{-1,0},{1,0},{0,-1},{0,1}};//상 하 좌 우
    int cnt;
    int m,n;
    int[][] picture;
    public int[] solution(int m, int n, int[][] picture) {
        this.m = m;
        this.n = n;
        this.picture = picture;
        visit = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j] && picture[i][j] != 0){
                    numberOfArea++;
                    cnt = 0;
                    bfs(i,j, picture[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,cnt);
                }
            }
        }
        

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    private void bfs(int startRow, int startCol, int value){
        cnt++;
        visit[startRow][startCol] = true;
        ArrayList<Integer> rQ = new ArrayList<>();
        ArrayList<Integer> cQ = new ArrayList<>();
        rQ.add(startRow);
        cQ.add(startCol);
        
        while(!rQ.isEmpty()){
            int y = rQ.remove(0);
            int x = cQ.remove(0);
            
            for(int i=0;i<4;i++){
                int newRow = y + edge[i][0];
                int newCol = x + edge[i][1];
                if(newRow<0||newRow>m-1||newCol<0||newCol>n-1){//허수인지 확인
                    continue;
                }
                if(!visit[newRow][newCol] && picture[newRow][newCol] == value){
                    cnt++;
                    visit[newRow][newCol] = true;
                    rQ.add(newRow);
                    cQ.add(newCol);
                }
            
            }
        }
        
        
    }
}