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
    static void bfs(int startRow, int startCol){
        visit[startRow][startCol] = true;
        houseCnt++;
        ArrayList<Integer> rowQ = new ArrayList<>();
        ArrayList<Integer> colQ = new ArrayList<>();
        rowQ.add(startRow);
        colQ.add(startCol);
        while(rowQ.size() != 0){
            int row = rowQ.remove(0);
            int col = colQ.remove(0);
            //여기에 연결된 애를 모두 탐색. 연결되어있다면 Q에 추가
            for(int i=0;i<4;i++){
                int newRow = row+edge[i][0];
                int newCol = col+edge[i][1];
                if(newRow < 0 || newRow >n-1 || newCol < 0 || newCol >n-1){ //허수
                    continue;
                }
                if(!visit[newRow][newCol] && village[newRow].charAt(newCol) == '1'){
                    visit[newRow][newCol] = true;
                    houseCnt++;
                    rowQ.add(newRow);
                    colQ.add(newCol);
                }
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
                    bfs(i,j);
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
