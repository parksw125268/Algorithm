import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int y;
    static int x;
    static int[][] field;
    static boolean[][] visit;
    static ArrayList<ArrayList<Integer>> aList = new ArrayList<>();
    static ArrayList<Integer>[] selected = new ArrayList[3];
    static int cnt2; //2의개수
    static int cnt1; //1의개수
    static int maxValue = Integer.MIN_VALUE;
    static int[][] side = {{-1,0},{1,0},{0,-1},{0,1}};

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        field = new int[y][x];
        visit = new boolean[y][x];
        for(int i=0;i<y;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<x;j++){
                field[i][j] = Integer.parseInt(st.nextToken());
                if(field[i][j] == 0){
                    aList.add(new ArrayList<Integer>(Arrays.asList(i,j))); //(2 3)
                }else if(field[i][j] == 1){
                    cnt1++;
                }
            }
        }
        cnt1 += 3;
    }
    static void setXY(boolean flag){
        for(int i=0;i<3;i++){

            if(flag){
                field[selected[i].get(0)][selected[i].get(1)] = 1;
            }else{
                field[selected[i].get(0)][selected[i].get(1)] = 0;
            }
        }
        if(!flag){
            for(int i=0;i<visit.length;i++){
                Arrays.fill(visit[i],false);
            }
        }
    }
    static void dfs(int row,int col){
        visit[row][col] = true;
        cnt2++;

        for(int i=0;i<4;i++){
            int newR = row+side[i][0];
            int newC = col+side[i][1];
            if(newR <0 || newR >= y || newC <0 ||newC>=x){
                continue;
            }
            if(!visit[newR][newC] && (field[newR][newC] == 0|| field[newR][newC] == 2) ){
                dfs(newR,newC);
            }
        }
    }
    static void work(int idx, int start){
        if(idx == 3){
            setXY(true);
            cnt2 = 0;
            for(int i=0;i<y;i++){
                for(int j=0;j<x;j++){
                    if(!visit[i][j] && field[i][j] == 2){
                        dfs(i,j);  //전파 다 시키고
                    }
                }
            }
            maxValue = Math.max(maxValue, y*x - cnt2 - cnt1 );
            setXY(false);
            return;
        }
        for(int i=start;i<aList.size();i++){
            selected[idx] = aList.get(i);
            work(idx+1 , i+1);
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        work(0,0);
        sb.append(maxValue);
        System.out.println(sb.toString());
    }
}
