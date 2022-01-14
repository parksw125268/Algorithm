import java.util.*;
class Solution
{
    public int solution(String s)
    {
        ArrayList<Character> cList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int answer = -1;
        char before;
        for(int i = 0;i<sb.length();i++){
            if(cList.size() == 0 ){
                    cList.add(sb.charAt(i));
            }else{
                if(sb.charAt(i) == cList.get(cList.size()-1)){
                    cList.remove(cList.size()-1);
                }else{
                    cList.add(sb.charAt(i));
                }
            }
        }
        if (cList.size() == 0 ){
            return 1;
        }else{
            return 0;
        }
    }
}