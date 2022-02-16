import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int y;
    static int x;
    static char[][] field;
    static int[][] visitCnt;
    static int[][] side = {{-1,0},{1,0},{0,-1},{0,1}};

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        field = new char[y][x];
        visitCnt = new int[y][x];
        for(int i=0;i<y;i++){
            Arrays.fill(visitCnt[i],-1);
            String s = br.readLine();
            for(int j=0;j<x;j++){
                field[i][j] = s.charAt(j);
            }
        }
    }
    static void bfs(int startR,int startC){
        visitCnt[startR][startC] = 0;
        ArrayList<Integer> que = new ArrayList<>();
        que.add(startR);
        que.add(startC);
        while(!que.isEmpty()){
            int r = que.remove(0);
            int c = que.remove(0);
            for(int i=0;i<4;i++){
                int newR = side[i][0]+r;
                int newC = side[i][1]+c;
                //허수체크
                if(newR<0|| newR>=y||newC<0||newC>=x) continue;
                if(field[newR][newC] == '1' && visitCnt[newR][newC] == -1){
                    que.add(newR);
                    que.add(newC);
                    visitCnt[newR][newC] = visitCnt[r][c]+1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs(0,0);
       // for(int i=0;i<visitCnt.length;i++){
       //     System.out.println(Arrays.toString(visitCnt[i]));
       // }
        System.out.println(visitCnt[y-1][x-1]+1);
    }
}
