import java.util.*;
//O(m^n)  m개 중에 n개 중복 허용해서 고르기 
public class Main {
    private static String[] item = {"a","b","c","d","e"};
    private static String[] selected = new String[3];//3개 고르기
    public static void main(String[] args) {

        rec_func(0);
    }

    private static void rec_func(int idx){
        if(idx == 3){
            System.out.println(Arrays.toString(selected));
            return;
        }

        for(int i=0;i<item.length;i++){
            selected[idx] = item[i];
            rec_func(idx+1);
            selected[idx] = "";
        }
    }
}