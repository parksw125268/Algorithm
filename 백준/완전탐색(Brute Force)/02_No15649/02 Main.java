import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] selected;
    static int[] used;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected= new int[m];
        used = new int[n];
    }
    static void work(Integer idx){
        if(idx == m){
            for (int i=0;i<m;i++) {
                sb.append(selected[i]+" ");
            }
            sb.append("\n");
        }else{
            for(int cand=1;cand<=n;cand++) {
                if(used[cand-1] != 1){
                    used[cand-1] = 1;
                    selected[idx] = cand;
                    work(idx + 1);
                    selected[idx] = 0;
                    used[cand-1] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        //work
        work(0);

        //print
        System.out.println(sb.toString());
    }
}

