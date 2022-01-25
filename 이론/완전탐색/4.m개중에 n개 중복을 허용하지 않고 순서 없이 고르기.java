import java.util.*;
//O(mCn). start를 파라매터로 함께 넘겨주고 i를 start부터 시작하도록 
//중복을 허용하지 않으므로 rec_func에 start에 i+1을 넘겨준다. <-> 중복허용시 i넘겨준다. 

public class Main {
    private static String[] item = {"a","b","c","d","e"};
    private static String[] selected = new String[3];//3개 고르기
    public static void main(String[] args) {

        rec_func(0, 0);
    }

    private static void rec_func(int idx, int start){
        if(idx == 3){
            System.out.println(Arrays.toString(selected));
            return;
        }

        for(int i=start;i<item.length;i++){
            selected[idx] = item[i];

            rec_func(idx+1,i+1);

            selected[idx] = "";
        }
    }
}