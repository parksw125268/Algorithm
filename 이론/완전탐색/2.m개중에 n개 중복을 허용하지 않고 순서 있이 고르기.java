import java.util.*;
//O(mPn). used를 사용하여 사용되었는지 체크 사용 안된것만 쓰도록
// * 주의 * 사용후에는 반드시 =0; 해줘서 사용안한것으로 만들어줘야함.

public class Main {
    private static String[] item = {"a","b","c","d","e"};
    private static int[] used = new int[item.length];
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
            if(used[i] != 1){
                used[i] = 1;
                selected[idx] = item[i];

                rec_func(idx+1);

                used[i] = 0;
                selected[idx] = "";
            }
        }
    }
}