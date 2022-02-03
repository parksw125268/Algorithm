import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static boolean[] visit;
    static ArrayList<Integer>[] tree;
    static int[] parentArr;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        tree = new ArrayList[n+1];
        visit = new boolean[n+1];
        parentArr = new int[n+1];
        for(int i=1;i<=n;i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=1;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
    }
    private static void bfs(int start){
        visit[start] = true;
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        while(!que.isEmpty()){
            int parent = que.poll();
            for(int child : tree[parent]){
                if(!visit[child]){
                    parentArr[child] = parent;
                    visit[child] = true;
                    que.add(child);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        bfs(1);
        for(int i=2;i<parentArr.length;i++){
            sb.append(parentArr[i]+"\n");
        }
        System.out.println(sb.toString());
    }
}
