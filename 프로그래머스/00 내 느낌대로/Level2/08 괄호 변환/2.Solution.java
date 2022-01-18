import java.util.*;
class Solution {
    public String solution(String p) {
        return work(p);
    }
    private String work(String s){
        if (s.equals("")){ 
            return s;
        }
        ArrayList<Character> stack = new ArrayList<>();
        int cut = 0;
        for(int i=0;i<s.length();i++){
            if(i == 0){
                stack.add(s.charAt(i));   
                continue;
            }
            if(s.charAt(i) != stack.get(stack.size()-1)){
                stack.remove(stack.size()-1);
            }else{
                stack.add(s.charAt(i));
            }
            if(stack.size() == 0){
                cut = i+1;
                break;
            }
        }
        //균형잡힌 문자열 두개
        String u = s.substring(0,cut);
        String v = s.substring(cut, s.length());
        if(isComplete(u)){
            return u + work(v); 
        }else{
            String newU = "";
            for(int i=1;i<u.length()-1;i++){
                if(u.charAt(i) == '('){
                    newU += ")";
                }else{
                    newU += "(";
                }
            }
            return "("+work(v)+")"+newU;
        }
    }
    private boolean isComplete(String s){
        ArrayList<Character> stack = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(stack.size()==0 && s.charAt(i) == ')'){
                return false;
            } 
            if(i == 0){
                stack.add(s.charAt(i));   
                continue;
            }
            if(s.charAt(i) != stack.get(stack.size()-1)){
                stack.remove(stack.size()-1);
            }else{
                stack.add(s.charAt(i));
            }
        }
        if(stack.size()!=0){
            return false;
        }
        return true;
    }
}