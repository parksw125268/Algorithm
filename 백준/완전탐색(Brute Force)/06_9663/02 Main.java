import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] colIdxArray;
    static int cnt = 0;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        colIdxArray = new int[n];
    }
    static boolean isAvailable(int row, int col){
        for(int i=0 ;i<row;i++){
            if( (colIdxArray[i] == col) ||               //세로체크
                (row + col) == (i + colIdxArray[i] ) || //우상향 대각체크
                (row - col == i - colIdxArray[i])){       //우하향 대각체크
                return false;
            }
        }
        return true;
    }
    static void work(int rowIdx){
        if(rowIdx == n){
            cnt++;
            return;
        }
        for (int i=0 ; i<n ; i++){
            if(isAvailable(rowIdx, i)){
                colIdxArray[rowIdx] = i;
                work(rowIdx+1);
            }else{
                continue;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        work(0);
        System.out.println(cnt);
    }
}
