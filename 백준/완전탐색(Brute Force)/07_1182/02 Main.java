import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int s;
    static int[] array;
    static int ans;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
    }
    static void work(int curr, int untilNum , int calcedValue, int startIdx){
        if (curr == untilNum){
            if(calcedValue == s)
                ans++;
        }else{
            for(int i=startIdx;i<n;i++){
                calcedValue += array[i];
                work(curr+1,untilNum, calcedValue, i+1);
                calcedValue -= array[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        for (int i=1;i<=n;i++){
            work(0,i,0, 0);
        }
        System.out.println(ans);
    }
}
