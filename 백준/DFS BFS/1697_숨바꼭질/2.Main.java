import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int k;
    static int visitCnt[] = new int[100000+1];

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Arrays.fill(visitCnt,-1);
    }
    static void bfs(int start){
        visitCnt[start] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        while(!que.isEmpty()){
            int x = que.poll();
            for(int i=0;i<3;i++){
                int newX;
                if(i == 0) newX = x+1; else if(i==1)newX = x-1; else newX = x*2;
                //허수체크
                if(newX<0 || newX>100000) continue;
                if(visitCnt[newX] != -1) continue;
                visitCnt[newX] = visitCnt[x]+1;
                que.add(newX);
                if(newX == k){
                    que.clear();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs(n);

        System.out.println(visitCnt[k]);
      //  System.out.println(Arrays.toString(visitCnt));
    }
}
