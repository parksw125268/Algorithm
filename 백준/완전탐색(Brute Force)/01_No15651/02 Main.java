import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] selected;

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
            for(int i=1;i<=n;i++){
                selected[idx] = i;
                work(idx+1);
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

