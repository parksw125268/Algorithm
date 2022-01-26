import java.util.*;
public class Main {
    private static boolean[] visit;
    private static ArrayList<Integer>[] listArr;
    public static void main(String[] args) {
        listArr = new ArrayList[7]; //1~6까지 사용
        visit = new boolean[listArr.length];

        listArr[1] = new ArrayList<>(Arrays.asList(5,2));
        listArr[2] = new ArrayList<>(Arrays.asList(1,6,5,4));
        listArr[3] = new ArrayList<>(Arrays.asList(5));
        listArr[4] = new ArrayList<>(Arrays.asList(2));
        listArr[5] = new ArrayList<>(Arrays.asList(1,2,3));
        listArr[6] = new ArrayList<>(Arrays.asList(2));
        dfs(2);
        System.out.println(Arrays.toString(visit));
    }

    private static void dfs(int x){
        visit[x] = true;

        for(int y : listArr[x]){
            if(visit[y]){
                continue;
            }
            dfs(y);
        }
    }
}