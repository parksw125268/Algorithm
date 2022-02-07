import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int r;
    static int c;
    static char[][] field;
    static boolean[][] visit;
    static int[][] dist;
    static int[] locate_D = {0,0};
    static int[] locate_S = {0,0};
    static ArrayList<Integer> locateWater =  new ArrayList<>();
    static int[][] side = {{-1,0},{1,0},{0,-1},{0,1}};

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        field = new char[r][c];
        visit = new boolean[r][c];
        dist = new int[r][c];
        for(int i=0;i<r;i++){
            String s = br.readLine();
            Arrays.fill(dist[i],-1);
            for(int j =0;j<c;j++){
                field[i][j] = s.charAt(j);
                if(field[i][j] == 'D'){
                    locate_D[0] = i;
                    locate_D[1] = j;
                }else if (field[i][j] == 'S' ){
                    locate_S[0] = i;
                    locate_S[1] = j;
                }else if (field[i][j] == '*' ) {
                    locateWater.add(i);
                    locateWater.add(j);
                }
            }
        }
    }          
    static void bfs(){
        Queue<Integer> wBeforeQue = new LinkedList<>(); //water Queue
        Queue<Integer> wAfterQue = new LinkedList<>(); //water Queue
        for(int i=0;i<locateWater.size();i+=2){
            int tem_r = locateWater.get(i);
            int tem_c = locateWater.get(i+1);
            visit[tem_r][tem_c] = true;
            wBeforeQue.add(tem_r);
            wBeforeQue.add(tem_c);
        }

        Queue<Integer> gBeforeQue = new LinkedList<>(); //Gosumdochi Queue
        Queue<Integer> gAfterQue = new LinkedList<>(); //Gosumdochi Queue
        gBeforeQue.add(locate_S[0]);
        gBeforeQue.add(locate_S[1]);
        dist[locate_S[0]][locate_S[1]] = 0;
        while(!gBeforeQue.isEmpty()){
            while(!wBeforeQue.isEmpty()) {
                int wr = wBeforeQue.poll();
                int wc = wBeforeQue.poll();
                for (int i = 0; i < 4; i++) {
                    int newWR = wr + side[i][0];
                    int newWC = wc + side[i][1];
                    if (newWR < 0 || newWR >= r || newWC < 0 || newWC >= c) continue;
                    if (!visit[newWR][newWC] && field[newWR][newWC] != 'X' && field[newWR][newWC] != 'D') {
                        visit[newWR][newWC] = true;
                        field[newWR][newWC] = '*';
                        wAfterQue.add(newWR);
                        wAfterQue.add(newWC);
                    }
                }
            }
            wBeforeQue.addAll(wAfterQue);
            wAfterQue.clear();

            while(!gBeforeQue.isEmpty()) {
                int gr = gBeforeQue.poll();
                int gc = gBeforeQue.poll();
                for (int i = 0; i < 4; i++) {
                    int newGR = gr + side[i][0];
                    int newGC = gc + side[i][1];
                    if (newGR < 0 || newGR >= r || newGC < 0 || newGC >= c) continue;
                    if (dist[newGR][newGC] != -1) continue;
                    if (field[newGR][newGC] == 'D' || field[newGR][newGC] == '.') {
                        dist[newGR][newGC] = dist[gr][gc] + 1;
                        gAfterQue.add(newGR);
                        gAfterQue.add(newGC);
                        if(locate_D[0] == newGR && locate_D[1] ==newGC){
                            gBeforeQue.clear();
                            gAfterQue.clear();
                            break;
                        }
                    }
                }
            }
            gBeforeQue.addAll(gAfterQue);
            gAfterQue.clear();
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        if(dist[locate_D[0]][locate_D[1]] == -1){
            System.out.println("KAKTUS");
        }else{
            System.out.println(dist[locate_D[0]][locate_D[1]]);
        }
    }
}
