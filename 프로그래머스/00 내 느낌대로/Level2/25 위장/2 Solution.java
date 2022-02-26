import java.util.*;
class Solution {
    HashMap<String, ArrayList<String>> hash = new HashMap<>();
    String[][] clothes;
    ArrayList<String> keyList = new ArrayList<>();
    String[] selected;
    int answer, getCnt;
    public int solution(String[][] clothes) {
        this.answer = 0;
        this.clothes = clothes;
        init();//hash 초기화 
        if(keyList.size() == 30){
            return 1073741823;
        }
        counting();
        
        return answer;
    }
    void counting(){
        for(int i=0;i<keyList.size();i++){
            getCnt = i+1;
            if(getCnt == 1){
                for(int j=0;j<keyList.size();j++){
                    answer += hash.get(keyList.get(j)).size();
                }   
                
            }else if(getCnt == keyList.size()){
                int tem_ans = 1;
                for(int j=0;j<keyList.size();j++){
                    tem_ans *= hash.get(keyList.get(j)).size();
                }    
                answer += tem_ans;
            }else{
                selected = new String[getCnt];
                work(0,0); //나머지 갯수 다 세버리기 
            }
        }
    }
    
    void work(int idx, int start){
        if(idx == getCnt){
            //System.out.println(Arrays.toString(selected));
            int tem_ans = 1;
            for(int j=0;j<selected.length;j++){//개수새기 
                tem_ans *= hash.get(selected[j]).size();
            }
            answer += tem_ans;
            return;
        }
        for(int i=start;i<keyList.size();i++){
            selected[idx] = keyList.get(i);
            work(idx+1,i+1);
        }
    }
    
    void init(){
        for(int i=0;i<clothes.length;i++){
            if(hash.get(clothes[i][1]) == null){
                hash.put(clothes[i][1],new ArrayList<>(Arrays.asList(clothes[i][0])));
            }else{
                hash.get(clothes[i][1]).add(clothes[i][0]);
            }
        }
        for (String key: hash.keySet()){
            keyList.add(key);
        }
    }
}