import java.util.*;
class Solution {
    String[] goods;
    String[] ans;
    public String[] solution(String[] goods) {
        this.goods = goods;
        this.ans = new String[goods.length];

        for(int i=0;i<goods.length;i++){
            ans[i] = work(goods[i]);
        }
        return ans;
    }
    String work(String str){
        int leng = str.length();
        ArrayList<String> sList  = new ArrayList<>();
        for(int i=leng;i>0;i--){//글자 길이만큼 
            int keyLeng = 0;
            for(int j=0;j<i;j++){
                String s = str.substring(j,j+1+leng-i);
                if(isKeyword(s)){
                    keyLeng = s.length();  
                    if(!sList.contains(s)){
                        sList.add(s);
                    }
                } 
            }
            if(keyLeng > 0){
                break;
            }
        }
        if (sList.size() == 0){
            return "None";
        }else{
            String result = "";
            Collections.sort(sList);
            for(int i=0;i<sList.size();i++){
                result = result + sList.get(i);
                if(i != sList.size()-1 )
                    result = result + " ";
            }
            return result;
        }
    }
    boolean isKeyword(String s){
        int cnt=0;
        for(int i=0;i<goods.length;i++){
            if(goods[i].contains(s)){
                cnt++;
            }
        }
        if(cnt == 1)  return true;
        else return false;
    }
}