import java.util.*;
class Solution {
    private String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    private int[] used = new int[8];
    String[] data;
    int n;
    private ArrayList<String> lines = new ArrayList<>();
    public int solution(int n, String[] data) {
        this.n = n;
        this.data = data;
        dfs(0,"");
        return lines.size();
    }

    private boolean isAble(String s){
        for(int i=0;i<n;i++){
            String buho = data[i].substring(3,4);
            int dist = Integer.parseInt(data[i].substring(4,5))+1;
            int pos1 = s.indexOf(data[i].charAt(0));
            int pos2 = s.indexOf(data[i].charAt(2));
            if (buho.equals("=")) {
                if (Math.abs(pos1 - pos2) != dist) {
                    return false;
                }
            } else if (buho.equals(">")) {
                if (Math.abs(pos1 - pos2) <= dist) {
                    return false;
                }
            } else {
                if (Math.abs(pos1 - pos2) >= dist) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(int idx, String s){
        if(idx == 8){
            if(isAble(s)){
                lines.add(s);
            }
            return;
        }
        for(int i=0;i<8;i++){
            if(used[i] != 1){
                used[i] = 1;
                dfs(idx+1, s+friends[i]);
                used[i] = 0;
            }
        }
    }
}

