import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] nums;
    static int[] operators = new int[4];
    static int[] order;
    static int max, min;

    static void input() throws IOException {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine()); //숫자 개수
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()); //숫자 집합
        nums = new int[n];
        for(int i=0 ;i<n ;i++){
            nums[i] =  Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()); //숫자 집합
        for(int i=0;i<4;i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }
        order = new int[n-1];
    }
    static int calc(){
        int value = nums[0];
        for (int i=0;i<n-1;i++){
            if (order[i] == 0){//+
                value += nums[i+1] ;
            } else if (order[i] == 1){//-
                value -= nums[i+1] ;
            } else if (order[i] == 2){//*
                value *= nums[i+1] ;
            } else if (order[i] == 3){// /
                value /= nums[i+1] ;
            }
        }
        return value;
    }
    static void work(int idx){
        if(idx == n-1){
            //출력
            int value =  calc();
            max = Math.max(max, value);
            min = Math.min(min, value);
        }else{
            //계산
            for(int i=0;i<4;i++){
                if(operators[i] != 0){
                    operators[i]--;
                    order[idx] = i;
                    work(idx+1);
                    operators[i]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        work(0);
        sb.append(max + "\n");
        sb.append(min);

        System.out.println(sb.toString());
    }
}
