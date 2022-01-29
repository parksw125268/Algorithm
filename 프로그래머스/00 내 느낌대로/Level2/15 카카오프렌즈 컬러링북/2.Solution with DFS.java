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
                    dfs(i,j, picture[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,cnt);
                }
            }
        }
        

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    private void dfs(int row, int col, int value){
        cnt++;
        visit[row][col] = true;
        
        for(int i=0;i<4;i++){
            int y = row + edge[i][0];
            int x = col + edge[i][1];
            if(y<0||y>m-1||x<0||x>n-1){//허수인지 확인
                continue;
            }
            if(!visit[y][x] && picture[y][x] == value){
                dfs(y,x,value);
            }
            
        }
        
    }
}