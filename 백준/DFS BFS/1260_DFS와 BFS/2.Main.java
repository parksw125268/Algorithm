import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int v;
    static boolean[] visit;

    static ArrayList<Integer>[] graph;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        visit = new boolean[n+1];
        for (int i=1;i<=n;i++){
            graph[i] = new ArrayList<Integer>();
        }
        for (int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i=1;i<=n;i++){
            Collections.sort(graph[i]);
        }
    }
    static void dfs(int x){
        visit[x] = true;
        sb.append(Integer.toString(x)+" ");

        for(int y : graph[x]){
            if(visit[y]){
                continue;
            }
            dfs(y);
        }
    }
    static void bfs(int start){
        ArrayList<Integer> que = new ArrayList<>();
        visit[start] = true;
        sb.append(Integer.toString(start)+" ");
        que.add(start);

        while(!que.isEmpty()){
            int x = que.remove(0);
            for(int y : graph[x]){
                if(visit[y]){
                    continue;
                }
                visit[y] = true;
                sb.append(Integer.toString(y)+" ");
                que.add(y);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        dfs(v);
        System.out.println(sb.toString());

        sb.setLength(0);
        for(int i=1;i<=n;i++){
            visit[i] = false;
        }

        bfs(v);
        System.out.println(sb.toString());
    }
}
