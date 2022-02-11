import java.util.*; //System.out.println();
class Solution {
    private String[][] relation;
    private int y,x;
    private ArrayList<Integer> notPkList = new ArrayList<>();
    private int[] selected;
    private int selectColCnt;
    private ArrayList<ArrayList<Integer>> ableList = new ArrayList<>();; //가능한 외부키 조합 리스트
    
    public int solution(String[][] relation) {
        this.relation = relation;
        this.y = relation.length;
        this.x = relation[0].length;
        
        getNotPrimaryKeyList(); //pk 아닌것들 리스트 받기
        bruteForce(); //notPKList 모든경우의수 해보면서 후보키되는것 뽑기
        
        int answer = (x - notPkList.size()) + ableList.size();
        return answer;
    }
    
    private void bruteForce(){
        for(int i=2;i<=x;i++){
            selectColCnt = i;
            selected = new int[i];
            work(0,0);
        }
    }
    
    private boolean isAvailable(){
        if(ableList.size() == 0){
            return true;
        }
        ArrayList<Integer> candList = new ArrayList<>();
        for(int i=0;i<selected.length;i++){
            candList.add(selected[i]);
        }
        for(ArrayList<Integer> aList : ableList){ 
            boolean temBool = true;
            for(int i=0;i<aList.size();i++){
                if(!candList.contains(aList.get(i))){
                    temBool = false;
                }
            }            
            if(temBool){
                return false;
            }
        }
        return true;
    }
    
    private void work(int idx, int start){
        if(idx == selectColCnt){
            if(isAvailable()){
                if(isCheckCandidateKey()){ 
                    ArrayList<Integer> newList = new ArrayList<>();
                    for(int i : selected){
                        newList.add(i);
                    }
                    ableList.add(newList);
                }
            }
            return;
        }
        
        for(int i=start;i<notPkList.size();i++){
            selected[idx] = notPkList.get(i);
            work(idx+1,i+1);
        }
    }
    
    private void getNotPrimaryKeyList(){
        for(int i=0;i<x;i++){
            if(isNotPrimary(i)){
                notPkList.add(i);
            }
        }
    }
    
    private boolean isNotPrimary(int col){
        HashSet<String> hs =new HashSet<>();
        for(int i=0;i<y;i++){
            hs.add(relation[i][col]);
        }
        if(hs.size() == y) return false;
        return true;
    }
    
    private boolean isCheckCandidateKey(){
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<y;i++){
            String s = "";
            for(int j=0;j<selected.length;j++){
                s += relation[i][selected[j]] +";";
            }
            hs.add(s);
        }
        if(hs.size() == y) return true;
        return false;
    }
}