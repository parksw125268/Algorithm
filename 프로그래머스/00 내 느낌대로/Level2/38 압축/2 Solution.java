import java.util.*; 
class Solution {
    String msg;
    int[] answer;
    ArrayList<String> dicList = new ArrayList<>();
    ArrayList<Integer> ansList = new ArrayList<>();
    public int[] solution(String msg) {
        this.msg = msg;
        init();
        work();
        listToArr();
        return answer;
    }
    void listToArr(){
        answer = new int[ansList.size()];
        for(int i=0;i<ansList.size();i++){
            answer[i] = ansList.get(i);
        }
    }
    void work(){
        int idx1 = 0; //시작
        int idx2 = 1; //끝
        while(idx1 < msg.length()){
            String subStr = msg.substring(idx1,idx2);
            while(dicList.contains(subStr)){
                idx2++;
                if(idx2>msg.length()){
                    subStr = msg.substring(idx1,idx2-1);
                    ansList.add(dicList.indexOf(subStr));
                    return;
                }
                subStr = msg.substring(idx1,idx2);
            }
            dicList.add(subStr);
            subStr = msg.substring(idx1,idx2-1);
            ansList.add(dicList.indexOf(subStr));
            idx1 = idx2-1; //시작
            idx2 = idx2; //끝
        }
    }
    
    
    void init(){
        dicList.add("");//인덱스를 1번부터 쓰기 위해 
        for(int i=0;i<26;i++){
            dicList.add(Character.toString('A'+i));
        }
    }
}