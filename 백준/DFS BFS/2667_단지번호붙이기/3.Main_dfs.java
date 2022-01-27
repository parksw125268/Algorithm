import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static boolean[][] visit;
    static String[] village;
    static int houseCnt;
    static int[][] edge = {{-1,0},{1,0},{0,-1},{0,1}}; //상 하 좌 우

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        village = new String[n];
        visit = new boolean[n][n];
        for(int i=0;i<n;i++){
            village[i] = br.readLine();
        }
    }
    static void dfs(int row, int col){
        visit[row][col] = true;
        houseCnt++;

        //연결된 모든 정점 탐색
        for (int i=0;i<4;i++){
            int newRow = row+edge[i][0];
            int newCol = col+edge[i][1];
            if(newRow < 0 || newRow >= n || newCol < 0 || newCol >=n){
                continue;
            }
            if(!visit[newRow][newCol] && village[newRow].charAt(newCol) == '1'){
                dfs(newRow,newCol);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        ArrayList<Integer> aList = new ArrayList<>();
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(!visit[i][j] && village[i].charAt(j) == '1'){
                    houseCnt = 0;
                    dfs(i,j);
                    aList.add(houseCnt);
                }
            }
        }
        Collections.sort(aList);
        sb.append(aList.size()+"\n");
        for(int cnt : aList){
            sb.append(cnt+"\n");
        }
        System.out.println(sb.toString());
    }
}
