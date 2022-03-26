import java.util.*;
class Solution {
    ArrayList<Character> stack = new ArrayList<>();
    ArrayList<Character> sList = new ArrayList<>();
    int cnt = 0; String s; int leng;
    public int solution(String s) {
        this.s = s; this.leng = s.length();
        init();
        rotation();
        return cnt;
    }
    void init(){
        for(int i=0;i<leng;i++){
            sList.add(s.charAt(i));
        }
    }
    void rotation(){
        for(int i=0;i<leng;i++){
            char c= sList.remove(0);
            sList.add(c);
            if(isValid()) cnt++;
        }
    }
    boolean isValid(){ // '(':1 , '[':2 , '{':3
        stack.clear();
        for(int i=0;i<leng;i++){
            char c=sList.get(i);
            if(i==0){
                if (c==')' ||c==']' ||c=='}') return false;
            }
            if(c=='('){
                stack.add(')');
            }else if(c=='['){
                stack.add(']');
            }else if(c=='{'){
                stack.add('}');
            }else{
                if(stack.size() == 0) return false;
                if(stack.get(stack.size()-1) != c) return false;
                stack.remove(stack.size()-1);
            }
            
        }     
        if(stack.isEmpty()) return true;
        else return false;
    }             
}