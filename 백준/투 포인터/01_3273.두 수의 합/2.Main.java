import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] arr;
    static int x;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
    }
    static int work(){
        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        int cnt = 0;
        while(left<right){
            if(arr[left]+arr[right] == x){
                cnt++ ;
                left++;
                right--;
            }else if(arr[left]+arr[right] > x){
                right--;
            }else{
                left++;
            }
        }
        return cnt;

    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(work());
    }
}
