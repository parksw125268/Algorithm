import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int t; //test케이스 개수
    static int m; //가로길이
    static int n; //세로길이
    static int k;
    static int x;
    static int y;
    static int cnt;
    static int[][] field;
    static boolean[][] visit;
    static int[][] side = {{-1,0},{1,0},{0,-1},{0,1}};

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            field = new int[n][m];
            visit = new boolean[n][m];
            for(int j=0;j<k;j++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }
            work();
        }

    }
    static void dfs(int row,int col){
        visit[row][col] = true;

        for(int i=0;i<4;i++){
            int newRow = side[i][0]+row;
            int newCol = side[i][1]+col;
            if(newRow <0 || newRow >= n || newCol < 0 || newCol >= m  ){//허수인지 판단
                continue;
            }
            if(visit[newRow][newCol] || field[newRow][newCol] == 0){
                continue;
            }
            dfs(newRow,newCol);
        }
    }

    static void work(){
        cnt = 0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(!visit[row][col] && field[row][col] != 0){
                    dfs(row,col);
                    cnt++;
                }
            }
        }
        sb.append(cnt+"\n");
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(sb.toString());
    }
}
