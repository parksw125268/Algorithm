import java.util.*;
class Solution {
    private int[] singo_cnt, answer;
    private String[] id_list, report; 
    private int k;
    private ArrayList<String> mailList = new ArrayList<>();
    private HashMap<String,ArrayList<String>> hash = new HashMap<>();
    public int[] solution(String[] id_list, String[] report, int k) {
        this.id_list = id_list;
        this.report = report;
        this.k = k;
        
        init();        //초기화
        singoInsert(); //신고횟수 저장
        singoCountK(); //k번 이상 신고된 사람 있는지 찾고 리스트에 넣기 
        sendMail();    //이용자 목록 돌면서 신고한 id중 k이상 신고된 사람이 몇개있는지 answer에 저장
        return answer;
    }
    private void sendMail(){
        for(int i=0;i<id_list.length;i++){
            ArrayList<String> temp = hash.get(id_list[i]);
            for(int j=0;j<mailList.size();j++){
               if(temp.contains(mailList.get(j))){
                   answer[i]++;
               }
            }                 
        }
    }
    
    private void singoCountK(){
        for(int i=0;i<singo_cnt.length;i++){
            if(singo_cnt[i] >= k){
                mailList.add(id_list[i]);
            }
        }
    }
    
    private void singoInsert(){
        for(int i=0;i<report.length;i++){
            String[] srr = report[i].split(" ");
            if(!hash.get(srr[0]).contains(srr[1])){
                hash.get(srr[0]).add(srr[1]);
                for(int j=0;j<id_list.length;j++){
                    if(id_list[j].equals(srr[1])){
                        singo_cnt[j]++;
                    }
                }
            }
        }
    }
    private void init(){
        singo_cnt = new int[id_list.length];
        answer = new int[id_list.length];
        for(int i =0;i<id_list.length;i++){
            hash.put(id_list[i], new ArrayList<>());
        }
        
    }
}
/*
idList, ArrayList<String>
muzi , frodo;neo

1. idlist를 키로하고 value를 ArrayList<STring>으로하는 hashmap만들기
2. report를 돌며 key별로 value를 추가하는데 contains(value)해보고 넣기
3. value를 추가할 때 신고 당한 횟수 추가 (id_list와 똑같은 int[] 만들기 )
*/