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
    }
    static void work(Integer idx){
        if(idx == m){
            for (int i=0;i<m;i++) {
                sb.append(selected[i]+" ");
            }
            sb.append("\n");
        }else{
            int start = 1;
            if (idx != 0){
                start = selected[idx-1];
            }
            for(int cand=start;cand<=n;cand++) {
                selected[idx] = cand;
                work(idx + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        work(0);
        System.out.println(sb.toString());
    }
}

