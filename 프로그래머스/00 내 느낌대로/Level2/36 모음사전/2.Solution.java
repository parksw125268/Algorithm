import java.util.*;
class Solution {
    String word;
    String[] alphas = {"A","E","I","O","U"};
    int SelectCnt;
    String[] Selected;
    ArrayList<String> sList = new ArrayList<>();
    public int solution(String word) {
        this.word = word;
        for(int i=1;i<=5;i++){
            SelectCnt = i;
            Selected = new String[SelectCnt];
            brute(0);
        }
        Collections.sort(sList);
        return sList.indexOf(word)+1;
    }
    void brute(int idx){
        if(idx == SelectCnt){
            addList();
            return;
        }
        for(int i=0;i<5;i++){
            Selected[idx] = alphas[i];
            brute(idx + 1);
        }
    }
    void addList(){
        String s = "";
        for(int i=0;i<Selected.length;i++){
            s += Selected[i];
        }
        sList.add(s);
    }
}