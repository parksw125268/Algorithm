import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static ArrayList<Integer>[] tree;
    static int cut;
    static int startIdx;
    static int answer = 0;
    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                startIdx = i;
            }else{
                tree[parent].add(i); //'부모 -> 자식' O / '자식 -> 부모' 는 넣지 않음.
            }
        }
        cut = Integer.parseInt(br.readLine());
    }
    static void dfs(int x){
        int cnt = 0;
        for(int y : tree[x]){
            if(y != cut){
                dfs(y);
                cnt++;
            }
        }
        if(cnt == 0){
            answer++;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        if(cut == startIdx){
            System.out.println(0);
            return;
        }
        dfs(startIdx);
        System.out.println(answer);
    }
}
